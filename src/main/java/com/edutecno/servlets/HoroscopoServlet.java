package com.edutecno.servlets;


import com.edutecno.dao.HoroscopoDAO;
import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/consulta")
public class HoroscopoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        HoroscopoDAO horoscopoDAO = new HoroscopoDAOImp();
        List<Horoscopo> listaHoroscopo = horoscopoDAO.obtenerHoroscopo();

        Horoscopo signo = null;
        for (Horoscopo h : listaHoroscopo) {
            if (usuario.getFechaNacimiento().after(h.getFechaInicio()) &&
                    usuario.getFechaNacimiento().before(h.getFechaFin())) {
                signo = h;
                break;
            }
        }

        usuario.setAnimal(signo != null ? signo.getAnimal() : "Desconocido");
        request.setAttribute("signo", usuario.getAnimal());


        System.out.println(signo);
        request.getRequestDispatcher("consulta.jsp").forward(request, response);
    }
}
