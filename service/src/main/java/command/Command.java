/**
 * 	    Control WebNews 			17.02.2015
 *
 * 	    Command - Abstract class for DP Command
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru
 */

package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create abstract class for DP Command
 */
public abstract class Command {
	abstract public void execute(HttpServletRequest request,HttpServletResponse response);
}