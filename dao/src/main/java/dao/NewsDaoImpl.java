/**
 * 	    Control Work 			17.02.2015
 *
 * 	    NewsDaoImpl		(CLASS implements from GeneralDao and NewsDao)
 * 	    Implementation functions from interface NewsDao
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pojos.News;
import util.DBConnection;
import util.DBConnectionManager;
import util.Options;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class NewsDaoImpl implements NewsDao {
    private static final Logger myLog = LogManager.getLogger(NewsDaoImpl.class);
	private static String curDir = null;
	//private static String queryFile = null;		//File where SQL QUERY
	private static NewsDaoImpl newsDI = null;	//for Design Pattern - SINGLETON
	private String nameSQLConfig = null;		//Name File SQL Config (query.properties)
	
	private static DBConnectionManager dbcm = DBConnectionManager.getDBConnectionManager(5);
	public static DBConnection dbc = null;		
	public static Connection connection = null;		//Connection
	
	/** 
	 * For Design Pattern - SINGLETON Constructor must be private
	 */
	private NewsDaoImpl() {
		//nameSQLConfig = Options.getNameFileConfig();
		//myLog.error("SQL File - " + nameSQLConfig);
	}

	/**
	 * Create static function that return address on own (this.) object for DP SINGLETON
	 */	
	public static synchronized NewsDaoImpl getNewsDaoImpl() {
		if (newsDI == null) {
			newsDI = new NewsDaoImpl();
			myLog.error("Create object DAO Singleton");
		}
		return newsDI;
	}
	
	@Override
	public News getId(int id) {
		News news = null;		
		try {
			// Get Connection from poolConnnection
			dbc = dbcm.getConnection();	if (dbc == null) myLog.error("DBConnection is false");
			connection = dbc.getConnection();	if (connection == null) myLog.error("Connection is false");
            if (connection != null) {
                Statement statement = (Statement) connection.createStatement();
                String query = Options.getSQL("SQL_NEWS_ID") + id;
                myLog.error(query);
                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    //Filling Object News
                    news = new News();
                    news.setId(Integer.parseInt(rs.getString("id")));// get ID News
                    news.setCategory(rs.getString("category"));         // Category News POLITIC, ECONOMIC, SPORT, ...
                    news.setTitle(rs.getString("title"));             // Title of the News
                    news.setAnnotation(rs.getString("annotation"));     // Short description of the News
                    news.setAuthor(rs.getString("author"));             // Name,Surname Author of the News
                    news.setAgency(rs.getString("agency"));             // Agency that publish News
                    news.setDrelease(rs.getString("drelease"));         // Date of publish News
                    news.setDocument(rs.getString("document"));         // Text of News
                    myLog.error("Object: " + news.toString());
                }
                // Necessarily return Connection in poolConnnection
                dbcm.returnConnection(dbc);
                dbc = null;
                connection = null;
            }
		} catch (SQLException e) {
			myLog.error("Error SQL " + e.toString());
		}
		return news;
	}

	@Override
	public News getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getList() {
		myLog.error("Start procedure: getList()");
		List<News> array_news = new ArrayList<News>();
		try {
			// Get Connection from poolConnnection
			dbc = dbcm.getConnection();	if (dbc == null) myLog.error("DBConnection is false");
			connection = dbc.getConnection();	if (connection == null) myLog.error("Connection is false");
            if (connection != null) {
                Statement statement = (Statement) connection.createStatement();
                String query = Options.getSQL("SQL_NEWS_ALL"); // query="SELECT * FROM news"
                myLog.error(query);
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    //Filling Object News
                    News news = new News();
                    news.setId(Integer.parseInt(rs.getString("id")));// get ID News
                    news.setCategory(rs.getString("category"));        // Category News POLITIC, ECONOMIC, SPORT, ...
                    news.setTitle(rs.getString("title"));            // Title of the News
                    news.setAnnotation(rs.getString("annotation"));    // Short description of the News
                    news.setAuthor(rs.getString("author"));            // Name,Surname Author of the News
                    news.setAgency(rs.getString("agency"));            // Agency that publish News
                    news.setDrelease(rs.getString("drelease"));        // Date of publish News
                    news.setDocument(rs.getString("document"));        // Text of News
                    //Add Object News to List
                    array_news.add(news);
                }
                // Necessarily return Connection in poolConnnection
                dbcm.returnConnection(dbc);
                dbc = null;
                connection = null;
            }
		} catch (SQLException e) {
			myLog.error("ERROR SQL " + e.toString());
        }
        return array_news;
	}

	@Override
	public int add(News item) {
        int ret=0;
        String query=Options.getSQL("SQL_NEWS_ADD")+"("+item.getId()+", \""+item.getCategory()+"\", \""+item.getTitle()+"\", \""+
                item.getAnnotation()+"\", \""+item.getAuthor()+"\", \""+item.getAgency()+"\", \""+item.getDrelease()+"\", \""+item.getDocument()+"\")";
        myLog.error(query);
        try {
            Statement statement = (Statement) connection.createStatement();
            ret = statement.executeUpdate(query);
            if (ret > 0) myLog.error("Object add: " + item.toString());
        } catch (SQLException e) {
            myLog.error("File with SQL not exist: " + e.toString());
        }
        return ret;
	}

	@Override
	public int delete(News item) {

		return 0;
	}
}