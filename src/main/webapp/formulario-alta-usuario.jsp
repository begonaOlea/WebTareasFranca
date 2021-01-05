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
    <body>
        
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <h2>Registro de Usuario</h2>

                    <!-- mensaje error alta -->
                    <c:if test="${ not empty requestScope.msgErrorAlta }">
                        <div class="alert alert-success" role="alert">
                            ${ requestScope.msgErrorAlta }
                        </div>
                    </c:if>

                    <!--Formulario-->

                    <form action="alta-usuario" method="post">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email"  name="email">
                        <div>
                            <div class="col"> ${requestScope.msgErrorEmail}</div>
                        </div>
                        <label for="nombre">Nombre y Apellidos</label>
                        <input type="text" class="form-control" id="email" name="nombreApellidos">
                        <div>
                            <div class="col"> ${requestScope.msgErrorNombreApellidos}</div>
                        </div>
                        <label for="pwd">Contraseña</label>
                        <input type="password" class="form-control" id="email"  name="pwd">
                        <div>
                            <div class="col"> ${requestScope.msgErrorPwd}</div>
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

