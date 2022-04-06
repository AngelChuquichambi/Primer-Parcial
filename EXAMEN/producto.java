package com.emergentes.ges_productos;

public class producto {

    private int id;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String categoria;

    public producto() {
        this.id = 0;
        this.descripcion = "";
        this.cantidad = 0;
        this.precio = 0;
        this.categoria = "";
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
