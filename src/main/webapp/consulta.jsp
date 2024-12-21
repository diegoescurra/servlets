<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<%
   String animal = (String) request.getAttribute("signo");

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Horóscopo Chino</title>

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
        <div class="text-center">
            <h1 class="mb-4">Conoce tu animal en el Horóscopo Chino</h1>
            <h2>Tu animal es: <strong><%= animal %></strong></h2>
        </div>
    </div>


</body>
</html>
