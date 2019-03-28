package com.akhilesh.learning;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(String.format("Time is: %d, Host is: %s, Addr is: %s, Port is: %d",
                new Date().getTime(), request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort()));
    }
}
