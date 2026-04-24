package com.codequality.inventario;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona el inventario de productos de la empresa.
 * Permite añadir, buscar, eliminar y calcular el valor total del stock.
 * 
 * @author Adrian
 * @version 1.0
 */
public class Inventario {

    private List<Producto> productos;

    /**
     * Constructor que inicializa el inventario vacío.
     */
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    /**
     * Añade un producto al inventario.
     * 
     * @param producto producto a añadir, no puede ser nulo
     * @throws IllegalArgumentException si el producto es nulo
     */
    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    /**
     * Calcula el valor total de todos los productos del inventario.
     * 
     * @return suma del valor total de cada producto
     */
    public double calcularValorTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getValorTotal();
        }
        return total;
    }

    /**
     * Busca un producto en el inventario por su nombre.
     * 
     * @param nombre nombre del producto a buscar
     * @return el producto encontrado, o null si no existe
     */
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve el número total de productos en el inventario.
     * 
     * @return número de productos
     */
    public int contarProductos() {
        return productos.size();
    }

    /**
     * Elimina un producto del inventario por su nombre.
     * 
     * @param nombre nombre del producto a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarProducto(String nombre) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}