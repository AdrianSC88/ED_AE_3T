package com.codequality.inventario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {

    private static final String NOMBRE_PRODUCTO = "Teclado";
	private Inventario inventario;
    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    void setUp() {
        inventario = new Inventario();
        producto1 = new Producto(NOMBRE_PRODUCTO, 10, 25.99);
        producto2 = new Producto("Ratón", 5, 15.50);
    }

    // ---- TEST 1: agregarProducto ----

    @Test
    void agregarProducto_valido_aumentaContador() {
        inventario.agregarProducto(producto1);
        assertEquals(1, inventario.contarProductos());
    }

    @Test
    void agregarProducto_nulo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto(null);
        });
    }

    // ---- TEST 2: calcularValorTotal ----

    @Test
    void calcularValorTotal_inventarioVacio_devuelveCero() {
        assertEquals(0.0, inventario.calcularValorTotal());
    }

    @Test
    void calcularValorTotal_variosProductos_devuelvesumaCorrecta() {
        inventario.agregarProducto(producto1); // 10 * 25.99 = 259.90
        inventario.agregarProducto(producto2); // 5  * 15.50 =  77.50
        assertEquals(337.40, inventario.calcularValorTotal(), 0.01);
    }

    // ---- TEST 3: buscarProducto ----

    @Test
    void buscarProducto_existente_devuelveProducto() {
        inventario.agregarProducto(producto1);
        Producto resultado = inventario.buscarProducto(NOMBRE_PRODUCTO);
        assertNotNull(resultado);
        assertEquals(NOMBRE_PRODUCTO, resultado.getNombre());
    }

    @Test
    void buscarProducto_noExistente_devuelveNull() {
        inventario.agregarProducto(producto1);
        Producto resultado = inventario.buscarProducto("Monitor");
        assertNull(resultado);
    }

    // ---- TEST 4: cantidad negativa en Producto ----

    @Test
    void crearProducto_cantidadNegativa_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Producto("Altavoz", -5, 30.00);
        });
    }
}