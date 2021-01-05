<%@page import="java.util.Map"%>
<%@page import="com.tareas.model.Usuario"%>
<%@page import="com.tareas.services.DB"%>
<%@page import="com.tareas.model.Tarea"%>
<%@page import="java.util.Collection"%>
<%@page import="javafx.beans.property.adapter.JavaBeanIntegerProperty"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </><%@include file="WEB-INF/vista/bootStrap.jspf" %>
    </head>
    <body>
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
        <h2 class="text-center">Lista Tareas ${ sessionScope.usuario.nombreApellidos }</h2>           


        <%

            HttpSession sesion = request.getSession();
            Usuario usr = (Usuario) sesion.getAttribute("usuario");
            
            Collection<Tarea> listaToDo = DB.getTareasToDo(usr);
            request.setAttribute("listaTareasToDo", listaToDo);
            
            Collection<Tarea> listaInProgress = DB.getTareasInProgress(usr);
            request.setAttribute("listaTareasInProgress", listaInProgress);
            
            Collection<Tarea> listaDone = DB.getTareasDone(usr);
            request.setAttribute("listaTareasDone", listaDone);


        %>
        <div class="row">
        <div class="table-responsive col-md-4">
            <div class="container">
                <table class="table table-bordered">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>TO DO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tarea" items="${ requestScope.listaTareasToDo}" >
                            <tr>
                                <th scope="row">${tarea.descripcion}</th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="table-responsive col-md-4">
            <div class="container">
                <table class="table table-bordered">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>IN PROGRESS</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tarea" items="${ requestScope.listaTareasInProgress}" >
                            <tr>
                                <th scope="row">${tarea.descripcion}</th>
                            </tr>
                        </c:forEach>
        
                    </tbody>
                </table>
            </div>
        </div>

        <div class="table-responsive col-md-4">
            <div class="container">
                <table class="table table-bordered">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>DONE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tarea" items="${ requestScope.listaTareasDone}" >
                            <tr>
                                <th scope="row">${tarea.descripcion}</th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        </div>
        <hr>
                <li class="nav-item">
            <a class="nav-link" href="formulario-alta-tarea.jsp">Agregar Tarea</a>
        </li>

    </body>
</html>
