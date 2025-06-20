package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/current-time")
public class CurrentTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //actualiza la pagina cada cierto tiempo, en este caso 1 segundo
        resp.setHeader("refresh","1");
        LocalTime time = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("       <title>Current Time</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Current Time!</h1>");
            out.println("       <h3>" + time.format(df) + "</h3>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
}
