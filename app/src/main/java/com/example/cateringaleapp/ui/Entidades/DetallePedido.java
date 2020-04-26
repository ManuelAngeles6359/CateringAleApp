package com.example.cateringaleapp.ui.Entidades;




public class DetallePedido {

    private Integer IdProducto;
    private String Nombre;
    private Float Precio;
    private Integer Cantidad;
    private Float Subtotal;




    /*public DetallePedido(Integer IdProducto,String Nombre,Float Precio,Integer Cantidad) {
        setIdProducto(IdProducto);
        setNombre(Nombre);
        setPrecio(Precio);
        setCantidad(Cantidad);

    }*/

    public DetallePedido() {

    }

    public DetallePedido(Integer idProducto, String nombre, Float precio, Integer cantidad, Float subtotal) {
        IdProducto = idProducto;
        Nombre = nombre;
        Precio = precio;
        Cantidad = cantidad;
        Subtotal = subtotal;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
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

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Float subtotal) {
        Subtotal = subtotal;
    }
}
