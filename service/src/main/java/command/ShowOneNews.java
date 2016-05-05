/**
 * 	    Control WebNews 			17.02.2015
 *
 * 	    ShowOneNews Class realization DP Command
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MyDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojos.News;

public class ShowOneNews extends Command {
    //Creatae object of Logger log4j
    private static final Logger myLog = LogManager.getLogger(ShowAllNews.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dao myDao = MyDao.getDao();
		String id = request.getParameter("id");
		News news = myDao.getNews(Integer.parseInt(id));

		RequestDispatcher dispatcher  = request.getRequestDispatcher("/OneNews.jsp");
		request.setAttribute("mynews", news);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e1) {
			myLog.error("Error: "+e1.toString());
		} catch (IOException e1) {
			myLog.error("Error: "+e1.toString());
		}
	}
}