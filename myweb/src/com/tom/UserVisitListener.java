package com.tom;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserVisitListener
 *
 */
public class UserVisitListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserVisitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event) {
    	System.out.println("sessionCreated:"+event.getSession().getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event) {
    	System.out.println("sessionDestroyed:"+event.getSession().getId());
    }
	
}
