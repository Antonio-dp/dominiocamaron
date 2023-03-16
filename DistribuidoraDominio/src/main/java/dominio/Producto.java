/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.List;
/**
 *
 * @author tonyd
 */
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "precio")
    private double precio;    

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.PERSIST, CascadeType.DETACH}, mappedBy="idProducto")
    private List<RemisionProducto> pedidos;

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.PERSIST, CascadeType.DETACH}, mappedBy="id")
    private List<PedidoProducto> pedidosProductos;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, Integer cantidad, double precio, List<RemisionProducto> pedidos, List<PedidoProducto> pedidosProductos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedidos = pedidos;
        this.pedidosProductos = pedidosProductos;
    }

    public Producto(String nombre, Integer cantidad, double precio, List<RemisionProducto> pedidos, List<PedidoProducto> pedidosProductos) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedidos = pedidos;
        this.pedidosProductos = pedidosProductos;
    }

    public Producto(String nombre, Integer cantidad, double precio, List<PedidoProducto> pedidosProductos) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedidosProductos = pedidosProductos;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<RemisionProducto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<RemisionProducto> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoProducto> getPedidosProductos() {
        return pedidosProductos;
    }

    public void setPedidosProductos(List<PedidoProducto> pedidosProductos) {
        this.pedidosProductos = pedidosProductos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", pedidos=" + pedidos + ", pedidosProductos=" + pedidosProductos + '}';
    }
}
