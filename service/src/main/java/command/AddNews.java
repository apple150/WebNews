/**
 * 	    Control WebNews 			17.02.2015
 *
 * 	    AddNews Class
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MyDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddNews extends Command {
    //Creatae object of Logger log4j
    private static final Logger myLog = LogManager.getLogger(AddNews.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dao myDao = MyDao.getDao();
		String category = request.getParameter("category");
		myLog.error("category= " + category);
        RequestDispatcher dispatcher  = null;
		if (category==null) {
			dispatcher  = request.getRequestDispatcher("/AddNews.html");
		} else {
			
		}
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e1) {
			myLog.error("Error: " + e1.toString());
        } catch (IOException e1) {
			myLog.error("Error: " + e1.toString());
        }
	}
}