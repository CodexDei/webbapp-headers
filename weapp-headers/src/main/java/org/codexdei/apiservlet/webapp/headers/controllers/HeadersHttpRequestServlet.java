package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers-request")
public class HeadersHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        //Variables
        //Devuelve el nombre del metodo que se esta usando, en este caso deberia devolver doGet
        String methodHttp = req.getMethod();
        //Devuelve un recurso sin su ubicacion exacta
        String requestUri = req.getRequestURI();
        //Devuelve la url completa
        String requestUrl = req.getRequestURL().toString();
        //Devuelve el nombre del proyecto
        String contextPath = req.getContextPath();
        //Devuelve el nombre del servlet
        String servletPath = req.getServletPath();
        //Datos de la URL
        String ipServer = req.getLocalAddr();
        String ipClient = req.getRemoteAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        //Construyendo la Url
        String url = scheme + "://" + host + contextPath + servletPath;
        String urlIp = scheme + "://" + ipServer + contextPath + servletPath;


        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("       <title>Headers Http Request</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Headers Http Request!</h1>");
            out.println("           <ul>");
            out.println("              <li>Method Http:" + methodHttp  + "</li>");
            out.println("              <li>Request URI:" + requestUri  + "</li>");
            out.println("              <li>Request URL:" + requestUrl  + "</li>");
            out.println("              <li>Context Path:" + contextPath  + "</li>");
            out.println("              <li>Servlet Path:" + servletPath  + "</li>");
            out.println("              <li>Ip Local:" + ipServer  + "</li>");
            out.println("              <li>Ip Client:" + ipClient  + "</li>");
            out.println("              <li>Port:" + port  + "</li>");
            out.println("              <li>Scheme:" + scheme  + "</li>");
            out.println("              <li>Host:" + host  + "</li>");
            out.println("              <li>Url:" + url  + "</li>");
            out.println("              <li>Url Ip:" + urlIp  + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String header = headerNames.nextElement();
            out.println("              <li>" + req.getHeader(header) + "</li>");
            }
            out.println("           </ul>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
}
