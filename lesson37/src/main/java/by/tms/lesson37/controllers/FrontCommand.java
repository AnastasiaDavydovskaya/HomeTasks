package by.tms.lesson37.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(
            ServletContext servletContext,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        this.context = servletContext;
        this.request = httpServletRequest;
        this.response = httpServletResponse;
    }


    public void process() {
        System.out.println("Front command is processed");
    }

    public void target(String target) {
        request.getRequestDispatcher(target + ".jsp");
    }
}
