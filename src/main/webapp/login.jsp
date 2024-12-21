<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
<nav class="navbar bg-info navbar-expand-lg text-white">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="#">Horoscopo Chino</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          Tu horóscopo chino
        </li>
      </ul>
    </div>
  </div>
</nav>
</header>
<main class="container">
<h1>Inicia Sesión </h1>
<p>Es necesario que inicies sesión para revisar tu horóscopo chino. Si todavía no tienes cuenta haz click <a href="registro.jsp">aquí</a>
<form action="./loginServlet" method="POST"
    <label for="username" class="form-label">Username:</label>
    <input type="text" id="username" name="username" class="form-control" required>
    <br>
    <label for="password" class="form-label">Password:</label>
    <input type="password" id="password" name="password" class="form-control" required>
    <br>
    <button type="submit" class="btn btn-info text-white">Login</button>
    <%
        String mensaje = request.getParameter("mensaje");
        if (mensaje != null) {
    %>
            <div class="alert alert-success" role="alert">
                <%= mensaje %>
            </div>
    <%
        }
    %>

</form>
</main>
</body>
</html>
