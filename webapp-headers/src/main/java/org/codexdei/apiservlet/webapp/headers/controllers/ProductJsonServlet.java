package org.codexdei.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codexdei.apiservlet.webapp.headers.models.Product;
import org.codexdei.apiservlet.webapp.headers.services.ProductService;
import org.codexdei.apiservlet.webapp.headers.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products.json")
public class ProductJsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(jsonStream,Product.class);
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("       <title>Details Product</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Details Product</h1>");
            out.println("       <ul>");
            out.println("          <li>Id: " + product.getId() + "</li>");
            out.println("          <li>Name: " + product.getName() + "</li>");
            out.println("          <li>Type: " + product.getType() + "</li>");
            out.println("          <li>Price: " + product.getPrice() + "</li>");
            out.println("       </ul>");
            out.println("   </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService service = new ProductServiceImpl();
        List<Product> productList = service.listProduct();
        ObjectMapper mapper = new ObjectMapper();
        //Convierte la lista en una cadena JSON
        String json = mapper.writeValueAsString(productList);
        //ajusta la cabecera para indicar que la respuesta sera un JSON
        //si se coloca como "/application/json" descarga un archivo JSON
        resp.setContentType("application/json");
        // Escribe la cadena JSON en el cuerpo de la respuesta HTTP
        resp.getWriter().write(json);
    }
}
