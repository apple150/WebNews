/**
 * 	    Control Work 			17.02.2015
 *
 * 	    GeneralDao		(INTERFACE)
 * 	    Description of the functions that need to be implement
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package dao;

import java.util.List;

public interface GeneralDao<T> {
	T getId(int id);		//get 1 item for Id
	T getName(String name);	//get 1 item for Name
	List<T> getList();			//get List items
	int add(T item);		//add 1 item
	int delete(T item);		//remove 1 News item
}