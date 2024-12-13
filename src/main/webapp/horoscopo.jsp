<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.edutecno.modelo.Horoscopo"%>
<%
    List<Horoscopo> listaHoroscopos = (List<Horoscopo>) request.getAttribute("listaHoroscopos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Horóscopos</title>
</head>
<body>
    <h1>Lista de Horóscopos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Animal</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (listaHoroscopos != null && !listaHoroscopos.isEmpty()) {
                    for (Horoscopo horoscopo : listaHoroscopos) {
            %>
                        <tr>
                            <td><%= horoscopo.getAnimal() %></td>
                            <td><%= horoscopo.getFechaInicio() %></td>
                            <td><%= horoscopo.getFechaFin() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="3">No hay datos disponibles.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
