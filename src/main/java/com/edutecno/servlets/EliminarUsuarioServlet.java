package com.edutecno.servlets;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.dao.UsuarioDAOImp;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/eliminar")
public class EliminarUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDao = new UsuarioDAOImp();

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        boolean eliminado = usuarioDao.eliminarUsuario(id);
        System.out.println(eliminado);
        HttpSession session = request.getSession();
        session.invalidate();
        if(eliminado) {
            response.sendRedirect("/login.jsp?mensaje=Cuenta eliminada exitosamente.");
        } else {
            response.sendRedirect("/ogin.jsp?mensaje=error al eliminar cuenta.");
        }
    }
}
