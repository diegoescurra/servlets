package com.edutecno.servlets;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.dao.UsuarioDAOImp;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarUsuarios")
public class BuscarUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        String username = request.getParameter("username");

        if (username == null || username.isEmpty()) {
            List<Usuario> usuarios = usuarioDAO.listarUsuarios();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("buscar.jsp").forward(request, response);
        } else {
            Usuario usuario = usuarioDAO.obtenerUsuarioPorUsername(username);
            if (usuario != null) {

                request.setAttribute("usuarios", List.of(usuario));
            } else {

                request.setAttribute("error", "No se encontró ningún usuario con ese nombre.");
            }
            request.getRequestDispatcher("buscar.jsp").forward(request, response);
        }
    }
}