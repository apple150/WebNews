/**
 * 	    Control Work 			17.02.2015
 *
 * 	    MyDao realization
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Statement;

import pojos.News;
import pojos.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * MyDao DP SINGLETON
 */
public class MyDao implements Dao  {
    private static final Logger myLog = LogManager.getLogger(MyDao.class);
    private static MyDao inst = null;
	private Connection connection;
	//private String DirWithOptions = ""; 	// Current Dirrextory where save config.properties, query.properties
	//private String nameConfigFile = null; 	// Full name where save config.properties
	private String nameSQLConfig = null;	// Full name where save query.properties
	
	/**
	 * DP SINGLETON Constructor should be  private
	 */
	private MyDao() {
        /*
        //Load properties file
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            logger.error(FAILED_TO_FIND_PROPERTIES_FILE_ERR);
        }
         */
		
        String driver=null, host="", login="", password="";
        //Load properties file
        Properties property = new Properties();
        try {
            property.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            driver = property.getProperty("driver");
            myLog.error(driver+" - driver");
            host = property.getProperty("host");
            login = property.getProperty("login");
            password = property.getProperty("password");
        } catch (IOException e) {
            myLog.error("FAILED_TO_FIND_PROPERTIES_FILE_ERR");
        }

		/**
		FileInputStream fis;
        Properties property = new Properties();
        try {
        	nameConfigFile = "config.properties";
        	nameSQLConfig  = "query.properties";
        	
        	myLog.error("File not exist: " + nameConfigFile);
            fis = new FileInputStream(nameConfigFile);
            property.load(fis);
            
            driver = property.getProperty("driver");
            host = property.getProperty("host");
            login = property.getProperty("login");
            password = property.getProperty("password");
            myLog.error("DRIVER: " + driver);
            myLog.error("HOST:   " + host);
            myLog.error("LOGIN:  " + login);
            myLog.error("PASSWORD: " + password);
        } catch (IOException e) {
        	myLog.error("Error exist file:  "+nameConfigFile);
        }		
		*/

        if (driver!=null) {
			try {
				Class.forName(driver); //com.mysql.jdbc.Driver
			} catch (ClassNotFoundException cnfe) {
				myLog.error("Driver not download");
				//System.out.println("Error loading driver: " +cnfe);
			}
			
			try {
				connection = DriverManager.getConnection(host, login, password); //jdbc:mysql://localhost:3306/webnews, root, 		
			} catch (SQLException e) {
                myLog.error("File with SQL not exist: "+e.toString());
			}
        }
	}
	
	/**
	 * Metod for DP Singletone
	 *   public static synchronized MyDao getDao()
	 */
	public static synchronized MyDao getDao() {
		if (inst == null) {
			inst = new MyDao();
			myLog.error("MuDao crete DAO Singleton");
		}
		return inst;
	}

	/**
	 * get SQL from file query.properties
	 */	
	public String getSQL(String param) {
		String ret="";
        Properties property = new Properties();
        try {
            property.load(getClass().getClassLoader().getResourceAsStream("query.properties"));
            ret = property.getProperty(param);
        } catch (IOException e) {
            myLog.error("FAILED_TO_FIND_PROPERTIES_FILE_ERR");
        }
        /*
		FileInputStream fis;
        Properties property = new Properties();
		try {
            fis = new FileInputStream(nameSQLConfig);
            property.load(fis);
            ret = property.getProperty(param);
		} catch (IOException e) {
            myLog.error("File with SQL not exist: "+e.toString());
        }
        */
		return ret;
	}
	
	/**
	 * Get User for E-MAIL
	 */
	@Override
	public User getUser(String email) {
		User user = null;
		String query=getSQL("SQL_USERS_EMAIL")+"\""+email+"\"";
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			//String query="SELECT * FROM users WHERE email="+"\""+email+"\"";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {			
				user = new User();
				user.setId(Integer.parseInt(rs.getString("id")));		// Users ID
				user.setRole(Integer.parseInt(rs.getString("role")));	// Rules users (1-admin, 2-user)
				user.setName(rs.getString("name"));						// Users Name
				user.setFam(rs.getString("fam"));						// Users Surname
				user.setEmail(rs.getString("email"));					// Users E-Mail
				user.setPassword(rs.getString("password"));				// Users password
				myLog.error("Object: " + user.toString());
			} else return null;				
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: "+e.toString());
		}
		return user;
	}

	/**
	 * Get list all Users
	 */	
	@Override
	public List<User> getUsers() {
		List<User> array_users = new ArrayList<User>();
		String query=getSQL("SQL_USERS_ALL"); // query="SELECT * FROM users"
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);			
			while (rs.next()) {
				User user = new User();			
				user.setId(Integer.parseInt(rs.getString("id")));		// Users ID
				user.setRole(Integer.parseInt(rs.getString("role")));	// Rules users (1-admin, 2-user)
				user.setName(rs.getString("name"));						// Users Name
				user.setFam(rs.getString("fam"));						// Users Surname
				user.setEmail(rs.getString("email"));					// Users E-Mail
				user.setPassword(rs.getString("password"));				// Users password
				array_users.add(user);				
			}
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}		
		return array_users;		
	}

	/**
	 * Get News for ID
	 */	
	@Override
	public News getNews(int num) {
		News news = null;
		String query=getSQL("SQL_NEWS_ID")+num;
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {			
				news = new News();
				news.setId(Integer.parseInt(rs.getString("id")));// ID News
				news.setCategory(rs.getString("category"));		 // Category of News (Politic, Economic ...)
				news.setTitle(rs.getString("title"));			 // Title of news (Headline)
				news.setAnnotation(rs.getString("annotation"));	 // Annatation to News
				news.setAuthor(rs.getString("author"));			 // Author of News
				news.setAgency(rs.getString("agency"));			 // Information Agency like Reiters, TASS, RIA
				news.setDrelease(rs.getString("drelease"));		 // Date of release News
				news.setDocument(rs.getString("document"));		 // Text of News
				myLog.error("Object: " + news.toString());
			} else return null;				
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}
		return news;
	}

	/**
	 * Get List News
	 */		
	@Override
	public List<News> getNews() {
		List<News> array_news = new ArrayList<News>();
		String query=getSQL("SQL_NEWS_ALL"); // query="SELECT * FROM news"
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				News news = new News();			
				news.setId(Integer.parseInt(rs.getString("id")));// ID News
				news.setCategory(rs.getString("category"));		// Category of News (Politic, Economic ...)
				news.setTitle(rs.getString("title"));			// Title of news (Headline)
				news.setAnnotation(rs.getString("annotation"));	// Annatation to News
				news.setAuthor(rs.getString("author"));			// Author of News
				news.setAgency(rs.getString("agency"));			// Information Agency like Reiters, TASS, RIA
				news.setDrelease(rs.getString("drelease"));		// Date of release News
				news.setDocument(rs.getString("document"));		// Text of News
				array_news.add(news);				
			}
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}		
		return array_news;
	}

	/**
	 * Add   USER
	 */
	@Override
	public int addUser(User user) {
		int ret=0;
		String query=getSQL("SQL_USERS_ADD")+"("+user.getId()+", "+user.getRole()+", \""+user.getName()+"\", \""+
												user.getFam()+"\", \""+user.getEmail()+"\", \""+user.getPassword()+"\")";		
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.error("Object add: " + user.toString());
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}		
		return ret;
	}

	/**
	 * Delete USER (for ID)
	 */
	@Override
	public int delUser(User user) {
		int ret=0;
		String query=getSQL("SQL_USERS_DEL")+user.getId();		
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.error("Object delete: " + user.toString());
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}		
		return ret;		
	}

	/**
	 * Add News NEWS
	 */	
	@Override
	public int addNews(News news) {
		int ret=0;
		String query=getSQL("SQL_NEWS_ADD")+"("+news.getId()+", \""+news.getCategory()+"\", \""+news.getTitle()+"\", \""+
				news.getAnnotation()+"\", \""+news.getAuthor()+"\", \""+news.getAgency()+"\", \""+news.getDrelease()+"\", \""+news.getDocument()+"\")";		
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.error("Object add: " + news.toString());
		} catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}		
		return ret;
	}

	/**
	 * delete NEWS (for ID)
	 */	
	@Override
	public int delNews(News news) {
		int ret=0;
		String query=getSQL("SQL_NEWS_DEL")+news.getId();
		myLog.error(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.error("Object delete: " + news.toString());
        } catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
		}
		return ret;		
	}
}