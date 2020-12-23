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
        </><%@include file="WEB-INF/vista/menu.jspf" %>
        <h1>Lista Tareas</h1>

        <% Collection<Tarea> lista = DB.getAllTareas();
            request.setAttribute("listaTareas", lista);
        %>

        <div>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Descripción</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="tarea" items="${ requestScope.listaTareas}" >
                        <tr>
                            <th scope="row">${tarea.descripcion}</th>
                            <td>${tarea.estado}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
