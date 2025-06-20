package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Redirige a una nueva ruta, crea un nuevo request
//        resp.setHeader("Location", req.getContextPath() + "/products.html");
//        resp.setStatus(HttpServletResponse.SC_FOUND);
        //Forma optimizada
        resp.sendRedirect(req.getContextPath() + "/products.html");
    }
}
