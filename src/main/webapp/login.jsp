<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        </><%@include file="WEB-INF/vista/bootStrap.jspf"%> 
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
        </><%@include file="WEB-INF/vista/menu.jspf" %>
    </head>
    <body background="imgs\TareasFondo.jpg" style="background-repeat: no-repeat; background-position: center center; background-size: cover">
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Iniciar sesión</h1>
                </div>
            </div>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email"
                           id="email" placeholder="Introduce  email">
                </div>
                <div class="form-group">
                    <label for="pwd">Contraseña</label>
                    <input type="password" class="form-control" name="pwd"
                           id="pwd" placeholder="Introduce contraseña">
                    <div class="col">${ requestScope.msgErrorPwd }</div>
                </div>
                <div class="container">
                    <a href="formulario-alta-usuario.jsp" class="btn btn-primary">Registrarse </a>                
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <!-- mensaje error login -->
            <c:if test="${not empty requestScope.msgErrorLogin }" >
                <div class="alert alert-success" role="alert">
                    ${requestScope.msgErrorLogin}
                </div>
            </c:if>
        </div>
    </body>
</html>