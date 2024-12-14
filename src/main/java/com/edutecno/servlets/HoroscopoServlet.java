package com.edutecno.servlets;


import com.edutecno.dao.HoroscopoDAO;
import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Horoscopo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/horoscopoServlet")
public class HoroscopoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HoroscopoDAO horoscopoDAO = new HoroscopoDAO();
        HoroscopoDAOImp hDAOImp = new HoroscopoDAOImp();
        try {
            List<Horoscopo> listaHoroscopos = horoscopoDAO.listarHoroscopo();
            request.setAttribute("listaHoroscopos", listaHoroscopos);
            request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        } finally {
            hDAOImp.cerrarConexion();
        }
    }
}
