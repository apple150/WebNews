/**
 * 	    Control Work 			17.02.2015
 *
 * 	    NewsDao		(INTERFACE implements from GeneralDao)
 * 	    Description of the functions that need to be implement
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package dao;

import java.util.List;

import pojos.News;

public interface NewsDao extends GeneralDao<News> {
	News getId(int id);			//get 1 item for News Id
	News getName(String name);	//get 1 item for News Name
	List<News> getList();			//get List News 
	int add(News item);			//add 1 News item
	int delete(News item);		//remove 1 News item
}
