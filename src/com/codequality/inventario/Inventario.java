package com.codequality.inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getValorTotal();
        }
        return total;
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public int contarProductos() {
        return productos.size();
    }

    public boolean eliminarProducto(String nombre) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}