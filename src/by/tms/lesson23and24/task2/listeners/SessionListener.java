package by.tms.lesson23and24.task2.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        String id = sessionEvent.getSession().getId();
        long creationTime = sessionEvent.getSession().getCreationTime();

        System.out.printf("Session content: %s %s\n%n", id, creationTime);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("Session destroyed");
    }
}
