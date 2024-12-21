package com.edutecno.servlets;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.dao.UsuarioDAOImp;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;


@WebServlet("/registerServlet")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setUsername(request.getParameter("username"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setFechaNacimiento(Date.valueOf(request.getParameter("fechaNacimiento")));
        usuario.setPassword(request.getParameter("password"));
        usuario.setAnimal("");

        if (usuarioDAO.registrarUsuario(usuario)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Error al registrar usuario");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

}