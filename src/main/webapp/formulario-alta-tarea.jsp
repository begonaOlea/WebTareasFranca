<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        </><%@include file="WEB-INF/vista/bootStrap.jspf"%> 
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
    </head>
    <body background="imgs\TareasFondo.jpg" style="background-repeat: no-repeat; background-position: center center; background-size: cover">        
        <div class="container">
            <div class="row">
                <div class="col">
                    <h2>Agregar Tarea</h2>

                    <!-- mensaje error alta -->
                    <c:if test="${ not empty requestScope.msgErrorAlta }">
                        <div class="alert alert-success" role="alert">
                            ${ requestScope.msgErrorAlta }
                        </div>
                    </c:if>

                    <!--Formulario-->

                    <form action="alta-tarea" method="post">
                        <label for="desc">Descripción</label>
                        <input type="text" class="form-control" id="descripcion"  name="descripcion">
                        <div>
                            <div class="col"> ${requestScope.msgErrorDescripcion}</div>
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Agregar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

