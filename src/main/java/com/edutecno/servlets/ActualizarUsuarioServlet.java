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

@WebServlet("/actualizarUsuario")
public class ActualizarUsuarioServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("actualizar.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setUsername(request.getParameter("username"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setFechaNacimiento(Date.valueOf(request.getParameter("fechaNacimiento")));
        usuario.setPassword(request.getParameter("password"));
        System.out.println(usuario.getNombre());

        if (usuarioDAO.actualizarUsuario(usuario)) {
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Error al modificar usuario");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }
    }

}
