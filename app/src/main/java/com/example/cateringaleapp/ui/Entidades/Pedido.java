package com.example.cateringaleapp.ui.Entidades;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static Integer IdPedido;
    private static Integer IdUsuario;
    private static Integer IdZonaAtencion;
    private static String LugarEntrega;
    private static Date FechaRegistro;
    private static Date FechaEntrega;
    private static Float Subtotal;
    private static Float IGV;
    private static Float Total;
    private static String Estado;
    private static List<DetallePedido> ListaDeProductos;


    public static void IniciarDetallePedido() {
        ListaDeProductos =  new ArrayList<>();
    }

    public static Integer getIdPedido() {
        return IdPedido;
    }

    public static void setIdPedido(Integer idPedido) {
        IdPedido = idPedido;
    }

    public static Integer getIdUsuario() {
        return IdUsuario;
    }

    public static void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public static Integer getIdZonaAtencion() {
        return IdZonaAtencion;
    }

    public static void setIdZonaAtencion(Integer idZonaAtencion) {
        IdZonaAtencion = idZonaAtencion;
    }

    public static String getLugarEntrega() {
        return LugarEntrega;
    }

    public static void setLugarEntrega(String lugarEntrega) {
        LugarEntrega = lugarEntrega;
    }

    public static Date getFechaRegistro() {
        return FechaRegistro;
    }

    public static void setFechaRegistro(Date fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public static Date getFechaEntrega() {
        return FechaEntrega;
    }

    public static void setFechaEntrega(Date fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public static Float getSubtotal() {
        return Subtotal;
    }

    public static void setSubtotal(Float subtotal) {
        Subtotal = subtotal;
    }

    public static Float getIGV() {
        return IGV;
    }

    public static void setIGV(Float IGV) {
        Pedido.IGV = IGV;
    }

    public static Float getTotal() {
        return Total;
    }

    public static void setTotal(Float total) {
        Total = total;
    }

    public static String getEstado() {
        return Estado;
    }

    public static void setEstado(String estado) {
        Estado = estado;
    }


    public static void AñadirProductoAlPedido(DetallePedido detallePedido) {
        ListaDeProductos.add(detallePedido);
    }
/*
    public static Integer TotalProductosEnPedido() {
        return ListaDeProductos.size();
    }
*/

    public static List<DetallePedido> getListaDeProductos() {
        return ListaDeProductos;
    }

 /*
    public static void setListaDeProductos(List<DetallePedido> listaDeProductos) {
        ListaDeProductos = listaDeProductos;
    }*/

}
