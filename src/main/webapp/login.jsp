<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        </><%@include file="WEB-INF/vista/bootStrap.jspf"%> 
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
        </><%@include file="WEB-INF/vista/menu.jspf" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Introduce los datos de Acceso</h1>
                </div>
            </div>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" name="email"
                           id="email" placeholder="Introduce  email">
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" name="pwd"
                           id="pwd" placeholder="Password">
                    <div class="col">${ requestScope.msgErrorPwd }</div>
                </div>
                <div class="container">
                    <a href="formulario-alta-usuario.jsp" class="btn btn-primary">Registrarse </a>                
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>

        </div>
    </body>
</html>
