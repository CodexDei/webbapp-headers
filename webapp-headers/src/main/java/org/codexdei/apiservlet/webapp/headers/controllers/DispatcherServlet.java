package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //No crea un nuevo request, sino que usa el mismo request y los une, es la diferencia con Location
    //Es decir que no cambia la ruta url, mantiene la misma: ".../dispatcher"
        getServletContext().getRequestDispatcher("/products.html").forward(req,resp);
    }
}
