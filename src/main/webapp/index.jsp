<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    com.edutecno.modelo.Usuario usuario = (com.edutecno.modelo.Usuario) session.getAttribute("usuario");
    int id = usuario.getId();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

.menu {
display: flex;
justify-content: center;
align-items; center;
gap: 1rem;
}

h1 {
text-align: center;
margin-bottom: 2rem;
}
</style>
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
<main>
<h1> ¿Que deseas hacer admin? </h1>
<div class="menu">
<a href="/consulta" class="btn btn-info text-white">Consulta animal </a>
<a href="/listarUsuarios" class="btn btn-info text-white">Buscar usuarios </a>
<a href="/actualizarUsuario?id=<%=id %>" class="btn btn-info text-white">Modificar datos </a>
<a href="/eliminar?id=<%=id %>" class="btn btn-info text-white">Eliminar cuenta </a>
</div>
</main>
</body>
</html>
