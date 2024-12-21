<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%     com.edutecno.modelo.Usuario usuario = (com.edutecno.modelo.Usuario) request.getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Usuario</title>
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
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-body">
                    <h2 class="text-center mb-4">Modificar Usuario</h2>
                    <form action="actualizarUsuario" method="post" onSubmit="validarPass(event)">

                            <input type="hidden" id="id" name="id" value=<%= usuario.getId() %> />

                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value=<%= usuario.getNombre()  %> required>
                        </div>


                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username" value= <%= usuario.getUsername() %> required>
                        </div>


                        <div class="mb-3">
                            <label for="email" class="form-label">Correo Electrónico</label>
                            <input type="email" class="form-control" id="email" name="email" value=<%= usuario.getEmail() %> required>
                        </div>


                        <div class="mb-3">
                            <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value=<%= usuario.getFechaNacimiento() %> required>
                        </div>


                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" value="" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Repetir Contraseña</label>
                            <input type="password" class="form-control" id="rpassword" name="rpassword" value="" required>
                        </div>


                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Actualizar Usuario</button>
                        </div>
                    </form>
                    <%
                        String error = (String) request.getAttribute("error");
                        if (error != null) {
                    %>
                        <div class="alert alert-danger mt-3">
                            <%= error %>
                        </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
   <script>
       function validarPass(event) {
           const password = document.getElementById("password").value;
           const rpassword = document.getElementById("rpassword").value;

           if (password !== rpassword) {
               event.preventDefault();
               alert("Las contraseñas no coinciden");
           }
       }
   </script>

</body>
</html>
