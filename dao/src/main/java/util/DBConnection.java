/**
 * 	    Control Work 			17.02.2015
 *
 * 	    DBConnection create one Connection
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private Connection connection=null;
	private int numConnection=0;
	private boolean freeConnection=true;

    private static final Logger myLog = LogManager.getLogger(DBConnection.class);
	
	public DBConnection(String driver, String host, String login, String password, int num) {
        if (driver!=null) {        	
			try {
				Class.forName(driver); //com.mysql.jdbc.Driver
				myLog.error("Driver is download");
			} catch (ClassNotFoundException cnfe) {
				//myLog.error("Error to driver");
				System.out.println("Error loading driver: " +cnfe.toString());
			}
			
			try {
				setConnection((Connection) DriverManager.getConnection(host, login, password)); 
				setNumConnection(num);
				setFreeConnection(true);
				myLog.error("Connection is true");
			} catch (SQLException e) {
				//myLog.error("Error SQL");
				System.out.println("Error loading driver: " +e.toString());
			}		
        }		
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

	public int getNumConnection() {
		return numConnection;
	}

	public void setNumConnection(int numConnection) {
		this.numConnection = numConnection;
	}

	public boolean getFreeConnection() {
		return freeConnection;
	}

	public void setFreeConnection(boolean freeConnection) {
		this.freeConnection = freeConnection;
	}

}
