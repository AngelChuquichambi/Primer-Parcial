<%@page import="com.emergentes.ges_productos.producto"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<producto> lista = (ArrayList<producto>) session.getAttribute("listaproducto");
%>
<%
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div>
            <p>PRIMER PARCIAL TEM - 742</p>
            <p>Nombre: Angel Chuquichambi</p>
            <p>CI: 13849530</p>
        </div>

        <h1>PRODUCTOS</h1>

        <a href="controlador?op=nuevo"><input type="submit" value="Nuevo Produto"></a><br><br>

        <table border="1" cellpadding="5" cellspacing="2">
            <tr>
                <th>Id</th><th>Descripción</th><th>Cantidad</th><th>Precio</th><th>Categoría</th><th>Op Editar</th><th>Op Eliminar</th>
            </tr>

            <%                
                if (lista != null) {
                    for (producto p : lista) {

            %>
            <tr>
                <td> <%= p.getId()%></td>
                <td> <%= p.getDescripcion()%></td>
                <td> <%= p.getCantidad()%></td>
                <td> <%= p.getPrecio()%></td>
                <td> <%= p.getCategoria()%></td>
                <td> <a href="controlador?op=editar&id=<%= p.getId()%>"><input type="submit" value="Editar"></a></td>
                <td> <a href="controlador?op=eliminar&id=<%= p.getId()%>" onclick="return confirm('Esta seguro de eliminar el registro ? ');"><input type="submit" value="Eliminar"></a></td>
            </tr>
            <%
                    }
                }
            %>

        </table>

    </table>

</body>
</html>
