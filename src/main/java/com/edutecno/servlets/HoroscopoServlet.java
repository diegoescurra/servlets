package com.edutecno.servlets;


import com.edutecno.dao.HoroscopoDAO;
import com.edutecno.modelo.Horoscopo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/horoscopoServlet")
public class HoroscopoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear instancia del DAO
        HoroscopoDAO horoscopoDAO = new HoroscopoDAO();

        try {
            // Obtener la lista de horóscopos
            List<Horoscopo> listaHoroscopos = horoscopoDAO.listarTodos();

            // Guardar la lista como atributo en el request
            request.setAttribute("listaHoroscopos", listaHoroscopos);

            // Redirigir a una JSP para mostrar los datos
            request.getRequestDispatcher("horoscopo.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        } finally {
            // Cerrar la conexión del DAO
            horoscopoDAO.cerrarConexion();
        }
    }
}
