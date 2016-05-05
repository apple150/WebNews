/**
 * 	    Control Work 			17.02.2015
 *
 * 	    Options CLASS
 * 	    Main function this class is save full path to necessary files (config, aql)
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Options {
    private static final Logger myLog = LogManager.getLogger(Options.class);
	private static Options options = null;
	private static String curDir = null;
	private static final String nameFileConfig = "config.properties";
	private static final String nameFileSQL = "query.properties";
	//private static String nameFileLogger = null;

    private Options() {}

	private Options(String currentDirectory) {
		setCurDir(currentDirectory);
	}
		
	/**
	 * Create static method that return Object on this (own) class
	 * If this Object will be used in other Treads, you should declare method like this:
	 * 		public static synchronized Options getOptions()
	 * but it declare makes slow work this application
	 */
	public static synchronized Options getOptions(String currentDirectory) {
		if (options == null) {
			options = new Options(currentDirectory);
			myLog.error("Create Object - Options Singleton with Current Directory");
		} else {
			myLog.error("Object - Options was created");
		}
		return options;
	}

	public static synchronized Options getOptions() {
		if (options == null) {
			options = new Options(); 
			//myLog.AddStrToLogFile("Create Object - Options Singleton");
		} else {
			myLog.error("Object - Options was created");
		}
		return options;
	}

	public static String getCurDir() {
		return curDir;
	}

	public static void setCurDir(String curDir) {
		Options.curDir = curDir;
	}

	public static String getNameFileSQL() {
		return nameFileSQL;
	}

	/**
	 * Get SQL for name from file - /query.properties/ 
	 */	
	public static String getSQL(String param) {
        /*
        String ret="";
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(nameFileSQL));
        } catch (IOException e) {
            myLog.error("Error: ");
        }
        return ret;
        */

		String ret="";
		FileInputStream fis;
	    Properties property = new Properties();
		try {
	        fis = new FileInputStream(nameFileSQL);
	        property.load(fis);
	        ret = property.getProperty(param);
		} catch (IOException e) {
	    	myLog.error("File: " + nameFileSQL + " is not exist" + e.toString());
	    }
		return ret;
	}

	/**
	 * Get Config Param for name from file - /config.properties/ 
	 */	
	public static String getConfig(String param) {
        /*
        String ret="";
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(getNameFileConfig()));
        } catch (IOException e) {
            myLog.error("Error: ");
        }
        return ret;
        */

		String ret="";
		FileInputStream fis;
	    Properties property = new Properties();
		try {
	        fis = new FileInputStream(nameFileConfig);
	        property.load(fis);
	        ret = property.getProperty(param);
		} catch (IOException e) {
	    	myLog.error("File: " + nameFileConfig + " is not exist" + e.toString());
	    }
		return ret;
	}	
}