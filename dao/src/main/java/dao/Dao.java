/**
 * 	    Control Work 			17.02.2015
 *
 * 	    Dao Interface
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package dao;


import pojos.News;
import pojos.User;

import java.util.List;

public interface Dao {
	User getUser(String email);	// Get User for e-mail
	List<User> getUsers();	    // Get list all Users
	
	News getNews(int num);		// Get News for ID
	List<News> getNews();	    // Get list all News
	
	int addUser(User user);		// Add User
	int delUser(User user);		// Delete User
	
	int addNews(News news);		// Add News
	int delNews(News news);		// Delete News
}