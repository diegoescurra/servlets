<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.edutecno.modelo.Usuario"%>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
    String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
<nav class="navbar bg-info navbar-expand-lg text-white">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="/index.jsp">Horoscopo Chino</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          Tu horóscopo chino
        </li>
      </ul>
      <a class="navbar-text text-white" href="LogoutServlet">
        Logout
      </a>
    </div>
  </div>
</nav>
</header>

<div class="container mt-5">
    <h1 class="text-center">Lista de Usuarios</h1>

    <%
        if (error != null) {
    %>
        <div class="alert alert-danger">
            <%= error %>
        </div>
    <%
        }
    %>

    <form action="listarUsuarios" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="username" class="form-control" placeholder="Buscar por nombre de usuario" value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">
            <button type="submit" class="btn btn-primary">Buscar</button>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Nombre de Usuario</th>
                <th>Email</th>
                <th>Fecha de Nacimiento</th>

            </tr>
        </thead>
        <tbody>
        <%
            if (usuarios != null && !usuarios.isEmpty()) {
                for (Usuario usuario : usuarios) {
        %>
            <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getUsername() %></td>
                <td><%= usuario.getEmail() %></td>
                <td><%= usuario.getFechaNacimiento() %></td>

            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6" class="text-center">No se encontraron usuarios.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
