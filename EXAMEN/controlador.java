package com.emergentes.controlador;

import com.emergentes.ges_productos.producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        if (sesion.getAttribute("listaproducto") == null) {
            ArrayList<producto> liaux = new ArrayList<producto>();
            sesion.setAttribute("listaproducto", liaux);
        }

        ArrayList<producto> lista = (ArrayList<producto>) sesion.getAttribute("listaproducto");

        String op = request.getParameter("op");
        String opcion = (op != null) ? op : "VISTA";

        producto p = new producto();
        int id, pos;

        switch (opcion) {
            case "nuevo":
                request.setAttribute("miproducto", p);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = BuscarInd(request, id);
                p = lista.get(pos);
                request.setAttribute("miproducto", p);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = BuscarInd(request, id);
                lista.remove(pos);
                sesion.setAttribute("listaproducto", lista);
                response.sendRedirect("index.jsp");
                break;

            case "VISTA":
                response.sendRedirect("index.jsp");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        ArrayList<producto> lista = (ArrayList<producto>) sesion.getAttribute("listaproducto");

        producto p = new producto();

        p.setId(Integer.parseInt(request.getParameter("id")));
        p.setDescripcion(request.getParameter("descripcion"));
        p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        p.setPrecio(Double.parseDouble(request.getParameter("precio")));
        p.setCategoria(request.getParameter("categoria"));

        int i = p.getId();

        if (i == 0) {
            int ultimo;
            ultimo = ultimoId(request);
            p.setId(ultimo);
            lista.add(p);
        } else {

            lista.set(BuscarInd(request, i), p);
        }

        sesion.setAttribute("listaproducto", lista);
        response.sendRedirect("index.jsp");

    }

    private int BuscarInd(HttpServletRequest request, int id) {

        HttpSession sesion = request.getSession();
        ArrayList<producto> lista = (ArrayList<producto>) sesion.getAttribute("listaproducto");

        int i = 0;

        if (lista.size() > 0) {
            while (i < lista.size()) {
                if (lista.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    private int ultimoId(HttpServletRequest request) {

        HttpSession sesion = request.getSession();
        ArrayList<producto> lista = (ArrayList<producto>) sesion.getAttribute("listaproducto");

        int id = 0;

        for (producto p : lista) {
            id = p.getId();
        }
        return id;
    }

}
