
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class drogueria {

    public static class Producto {
        private String codigoBarras;
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;
        private int cantidadStock;

        public Producto(String codigoBarras, String nombre, String descripcion, double precio, String categoria, int cantidadStock) {
            this.codigoBarras = codigoBarras;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
            this.cantidadStock = cantidadStock;
        }

        public String getCodigoBarras() {
            return codigoBarras;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public double getPrecio() {
            return precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public int getCantidadStock() {
            return cantidadStock;
        }

        public void setCodigoBarras(String codigoBarras) {
            this.codigoBarras = codigoBarras;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setCantidadStock(int cantidadStock) {
            this.cantidadStock = cantidadStock;
        }
    }

    public static class Cliente {
        private int id;
        private String nombre;
        private String direccion;
        private List<Venta> historialCompras;

        public Cliente(int id, String nombre, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.historialCompras = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public List<Venta> getHistorialCompras() {
            return historialCompras;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void addCompra(Venta venta) {
            this.historialCompras.add(venta);
        }

        public Venta realizarCompra(List<Producto> productos, Empleado cajero, double montoTotal) {
            Venta venta = new Venta(this, productos, new Date(), cajero, montoTotal);
            this.addCompra(venta);
            return venta;
        }
    }

    public static class Empleado {
        private int id;
        private String nombre;
        private String cargo;

        public Empleado(int id, String nombre, String cargo) {
            this.id = id;
            this.nombre = nombre;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCargo() {
            return cargo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }
    }

    public static class Venta {
        private Cliente cliente;
        private List<Producto> productos;
        private Date fechaHora;
        private Empleado cajero;
        private double montoTotal;

        public Venta(Cliente cliente, List<Producto> productos, Date fechaHora, Empleado cajero, double montoTotal) {
            this.cliente = cliente;
            this.productos = productos;
            this.fechaHora = fechaHora;
            this.cajero = cajero;
            this.montoTotal = montoTotal;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public List<Producto> getProductos() {
            return productos;
        }

        public Date getFechaHora() {
            return fechaHora;
        }

        public Empleado getCajero() {
            return cajero;
        }

        public double getMontoTotal() {
            return montoTotal;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public void setProductos(List<Producto> productos) {
            this.productos = productos;
        }

        public void setFechaHora(Date fechaHora) {
            this.fechaHora = fechaHora;
        }

        public void setCajero(Empleado cajero) {
            this.cajero = cajero;
        }

        public void setMontoTotal(double montoTotal) {
            this.montoTotal = montoTotal;
        }
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("123456789", "Shampoo", "Shampoo para cabello seco", 5.99, "Cuidado Personal", 100);
        Cliente cliente1 = new Cliente(1, "Juan Perez", "Calle Falsa 123");
        Empleado empleado1 = new Empleado(101, "Ana López", "Cajero");

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);

        Venta venta1 = cliente1.realizarCompra(productos, empleado1, producto1.getPrecio());

        System.out.println("Cliente: " + venta1.getCliente().getNombre());
        System.out.println("Producto: " + venta1.getProductos().get(0).getNombre());
        System.out.println("Precio: $" + venta1.getProductos().get(0).getPrecio());
        System.out.println("Cajero: " + venta1.getCajero().getNombre());
    }
}
