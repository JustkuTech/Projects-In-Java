import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class supermercado {

    public static class Producto {
        private String codigoBarras;
        private String nombre;
        private double precio;
        private String descripcion;
        private String categoria;
        private int cantidadStock;

        public Producto(String codigoBarras, String nombre, double precio, String descripcion, String categoria, int cantidadStock) {
            this.codigoBarras = codigoBarras;
            this.nombre = nombre;
            this.precio = precio;
            this.descripcion = descripcion;
            this.categoria = categoria;
            this.cantidadStock = cantidadStock;
        }

        public String getCodigoBarras() {
            return codigoBarras;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public String getDescripcion() {
            return descripcion;
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

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
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
        private List<TransaccionCompra> historialCompras;

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

        public List<TransaccionCompra> getHistorialCompras() {
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

        public TransaccionCompra realizarCompra(List<Producto> productos, Empleado cajero, double montoTotal) {
            TransaccionCompra compra = new TransaccionCompra(this, productos, LocalDateTime.now(), cajero, montoTotal);
            this.historialCompras.add(compra);
            return compra;
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

    public static class TransaccionCompra {
        private Cliente cliente;
        private List<Producto> productos;
        private LocalDateTime fechaHora;
        private Empleado cajero;
        private double montoTotal;

        public TransaccionCompra(Cliente cliente, List<Producto> productos, LocalDateTime fechaHora, Empleado cajero, double montoTotal) {
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

        public LocalDateTime getFechaHora() {
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

        public void setFechaHora(LocalDateTime fechaHora) {
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
        Producto producto1 = new Producto("123456789", "Shampoo", 5.99, "Shampoo para cabello seco", "Cuidado Personal", 100);
        Producto producto2 = new Producto("987654321", "Jabón", 2.99, "Jabón de glicerina", "Cuidado Personal", 150);

        Cliente cliente1 = new Cliente(1, "Juan Perez", "Calle Falsa 123");

        Empleado empleado1 = new Empleado(101, "Ana López", "Cajero");

        List<Producto> productosComprados = List.of(producto1, producto2);
        double montoTotal = productosComprados.stream().mapToDouble(Producto::getPrecio).sum();
        TransaccionCompra compra1 = cliente1.realizarCompra(productosComprados, empleado1, montoTotal);

        System.out.println("Cliente: " + compra1.getCliente().getNombre());
        System.out.println("Productos comprados: " + compra1.getProductos().stream().map(Producto::getNombre).toList());
        System.out.println("Monto Total: $" + compra1.getMontoTotal());
        System.out.println("Cajero: " + compra1.getCajero().getNombre());
        System.out.println("Fecha y Hora de la compra: " + compra1.getFechaHora());
    }
}
