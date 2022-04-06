<%@page import="com.emergentes.ges_productos.producto"%>
<%
    producto item = (producto) request.getAttribute("miproducto");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1><%= (item.getId() == 0) ? "Nuevo registro" : "Editar registro"%></h1>

        <form action="controlador" method="post">

            <input type="hidden" name="id"  value="<%= item.getId()%>"><br><br>

            <table border="0">
                <tr>
                    <td>Descripción</td>
                    <td><input type="text" name="descripcion" value="<%= item.getDescripcion()%>"></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" min="0" name="cantidad" d value="<%= item.getCantidad()%>"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="number" name="precio" step="any" value="<%= item.getPrecio()%>"></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><select name="categoria" value="<%= item.getCategoria()%>">
                <option>Seleccione una opción</option>
                <option>Bebidas</option>
                <option>Galletas</option>
                <option>Frutas</option>
                <option>Verduras</option>
                <option>Carnes</option>
                <option>Lacteos</option>
            </select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Registrar"></td>
                </tr>
               
            </table>


        </form>

    </body>
</html>
