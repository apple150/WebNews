/**
 * 	    Control WebNews 			17.02.2015
 *
 * 	    ShowAllNews Class realization DP Command
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MyDao;

import pojos.News;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShowAllNews extends Command {
    //Creatae object of Logger log4j
    private static final Logger myLog = LogManager.getLogger(ShowAllNews.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dao myDao = MyDao.getDao();
		List<News> array_news = myDao.getNews();
		request.setAttribute("array_news", array_news);
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/AllNews.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e1) {
			myLog.error("Error: " + e1.toString());
		} catch (IOException e1) {
			myLog.error("Error: " + e1.toString());
		}
	}
}
