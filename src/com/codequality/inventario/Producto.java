package com.codequality.inventario;

/**
 * Representa un producto dentro del sistema de gestión de inventario.
 * Almacena el nombre, la cantidad en stock y el precio unitario.
 * 
 * @author Adrian
 * @version 1.0
 */
public class Producto {

    private String nombre;
    private int cantidad;
    private double precio;

    /**
     * Constructor que crea un nuevo producto con los datos indicados.
     * 
     * @param nombre   nombre del producto
     * @param cantidad cantidad en stock, debe ser mayor o igual a cero
     * @param precio   precio unitario, debe ser mayor o igual a cero
     * @throws IllegalArgumentException si la cantidad o el precio son negativos
     */
    public Producto(String nombre, int cantidad, double precio) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @return nombre del producto
     */
    public String getNombre() { return nombre; }

    /**
     * Devuelve la cantidad en stock del producto.
     * 
     * @return cantidad en stock
     */
    public int getCantidad() { return cantidad; }

    /**
     * Devuelve el precio unitario del producto.
     * 
     * @return precio unitario
     */
    public double getPrecio() { return precio; }

    /**
     * Establece una nueva cantidad en stock para el producto.
     * 
     * @param cantidad nueva cantidad, debe ser mayor o igual a cero
     * @throws IllegalArgumentException si la cantidad es negativa
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    /**
     * Calcula el valor total del producto multiplicando cantidad por precio.
     * 
     * @return valor total del producto en euros
     */
    public double getValorTotal() {
        return cantidad * precio;
    }
}