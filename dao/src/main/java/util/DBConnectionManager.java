/**
 * 	    Control Work 			17.02.2015
 *
 * 	    DBConnectionManager create pool Connection
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnectionManager {
	private static DBConnectionManager dbcm = null;
	
	private static String curDir = null;
	private static int countConnection=0;
	private static String driver = null; 	//"com.mysql.jdbc.Driver"; 
	private static String host = null; 		//"jdbc:mysql://localhost:3306/webnews";
	private static String login = null; 	//"root";
	private static String password = null; 	//"";
	private static String nameConfigFile = null; 	//Full name to config file
	private List<DBConnection> arrayList = null;

    private static final Logger myLog = LogManager.getLogger(DBConnectionManager.class);
	
	/**
	 * DP SINGLETON  private
	 */
	private DBConnectionManager(int countConnection) {
		if (this.countConnection==0) {
			this.countConnection = countConnection;
			//curDir = new File("").getAbsolutePath();
			//setCurDir(CurDir);
			arrayList = new ArrayList<DBConnection>();
			getConfigProperties();
			downloadConnection(this.countConnection);
			
			//nameConfigFile = Options.getNameFileConfig();
		}
	}
	
	/**
	 * For DP Singleton
	 *   public static synchronized MyDao getDao()
	 */
	public static synchronized DBConnectionManager getDBConnectionManager(int countConnection) {
		if (dbcm == null) {
			dbcm = new DBConnectionManager(countConnection); 
			myLog.error("The object DBConnectionManager created");
		}
		return dbcm;
	}
		
	public void getConfigProperties() {
		nameConfigFile = Options.getNameFileConfig();
		if (nameConfigFile != null) {			
			//nameConfigFile = getCurDir()+"//src//utils//resources//config.properties";
			myLog.error("Config file adress: " + nameConfigFile);
			FileInputStream fis=null;
			Properties property = new Properties();
			try {
				fis = new FileInputStream(nameConfigFile);
				property.load(fis);
				
	            driver = property.getProperty("driver");
	            host = property.getProperty("host");
	            login = property.getProperty("login");
	            password = property.getProperty("password");
	            
	            myLog.error("driver: 	" + driver);
	            myLog.error("host: 	" + host);
	            myLog.error("login: 	" + login);
	            myLog.error("password: " + password);
			} catch (IOException e) {
	        	myLog.error("Config file not exist !!!");
	        }				
		}
	}
	
	/**
	 * Get Busy of Manager in % (Percent) 
	 * @return
	 */
	public int getBusyPercent() {
		int percent=0;
		int count = arrayList.size();
		int busy=0;
		for (int i=0; i < count; i++) {
			if (arrayList.get(i).getFreeConnection()==false) busy++;  
		}
		percent=(busy/count)*100;
		return percent;
	}
	
	/**
	 * Pack ArrayList with Connection
	 */
	public void downloadConnection(int count) {
		//arrayList = new ArrayList<DBConnection>();
		int i = arrayList.size();
		
		for (int y=i; y < (i+count); y++) {
			DBConnection dbcon = getNewDBConnection(y);
			if (dbcon != null) {
				arrayList.add(dbcon);
				myLog.error("Connection is true - "+i);
			} else {
				myLog.error("Connection is null");
			}			
		}		
	}

	/**
	 * Get All Connection in Manager
	 * @return
	 */
	public int getAllConnection() {
		int ret=arrayList.size();
		return ret;
	}
	
	/**
	 * Remove additional Connections
	 */
	public void removeSomeConnections() {
		int countConn =  getAllConnection();
		if (countConn > countConnection) {
			for (int i=countConn; i>countConnection; i--) {
				arrayList.remove(i-1);
			}
		}
	}
	
	/**
	 * Print All Connections
	 */
	public void printAllConnection() {
		for (int i=0; i < arrayList.size(); i++) {
			myLog.error("Conn: "+arrayList.get(i).getNumConnection()+"\tBysy: "+arrayList.get(i).getFreeConnection());
		}
	}
	
	public DBConnection getNewDBConnection(int count) {
		DBConnection dbcon = null;	
		dbcon = null; 	dbcon = new DBConnection(driver, host, login, password, count);
		Connection connection = dbcon.getConnection();
		if (connection == null) dbcon = null;
		return dbcon;
	}
	
	/**
	 * Get Coonection from Stack (arrayList<DBConnection>)
	 * @return DBConnection
	 */
	public DBConnection getConnection() {
		DBConnection dbc = null;
		for (int i=0; i<arrayList.size(); i++) {
			if (arrayList.get(i).getFreeConnection()==true) {
				arrayList.get(i).setFreeConnection(false);
				dbc=arrayList.get(i);
				break;
			}
		}
		return dbc;
	}
	
	/**
	 * Return Connection in Stack
	 * @param dbc
	 */
	public void returnConnection(DBConnection dbc) {
		int i=dbc.getNumConnection();
		if (arrayList.get(i)!=null) {
			arrayList.get(i).setFreeConnection(true);
		}
	}

	public static String getCurDir() {
		return curDir;
	}

	public static void setCurDir(String curDir) {
		DBConnectionManager.curDir = curDir;
	}
}
