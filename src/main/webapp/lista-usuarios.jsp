<%@page import="com.tareas.services.DB"%>
<%@page import="com.tareas.model.Usuario"%>
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
    <body background="imgs\TareasFondo.jpg" style="background-repeat: no-repeat; background-position: center center; background-size: cover">
        </><%@include file="WEB-INF/vista/cabecera.jspf" %>
        </><%@include file="WEB-INF/vista/menu.jspf" %>
        <h1>Lista Usuarios</h1>

        <%            Collection<Usuario> lista = DB.getAllUsuarios();
            request.setAttribute("listaUsuarios", lista);

        %>

        <div>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Email</th>
                        <th>Usuario</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="usr" items="${requestScope.listaUsuarios}" >
                        <tr>
                            <th scope="row">${usr.email}</th>
                            <td>${usr.nombreApellidos}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>

