package com.example.cateringaleapp.ui.Entidades;

public class Producto {

    private String Nombre;
    private Float Precio;
    private String EnPromocion;
    private String Descripcion;
    private String RutaImagen;

    public String getRutaImagen() {
        return RutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        RutaImagen = rutaImagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float precio) {
        Precio = precio;
    }

    public String getEnPromocion() {
        return EnPromocion;
    }

    public void setEnPromocion(String enPromocion) {
        EnPromocion = enPromocion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }




}
