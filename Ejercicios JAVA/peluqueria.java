import java.util.ArrayList;
import java.util.List;

public class peluqueria {

    public static class Cliente {
        private int id;
        private String nombre;
        private String telefono;
        private String direccion;
        private List<Servicio> serviciosRealizados;
        private List<ProductoBelleza> productosComprados;

        public Cliente(int id, String nombre, String telefono, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
            this.direccion = direccion;
            this.serviciosRealizados = new ArrayList<>();
            this.productosComprados = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getDireccion() {
            return direccion;
        }

        public List<Servicio> getServiciosRealizados() {
            return serviciosRealizados;
        }

        public List<ProductoBelleza> getProductosComprados() {
            return productosComprados;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void comprarProducto(ProductoBelleza producto) {
            this.productosComprados.add(producto);
        }
    }

    public static class Servicio {
        private String nombre;
        private String descripcion;
        private int duracion;
        private double precio;

        public Servicio(String nombre, String descripcion, int duracion, double precio) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.duracion = duracion;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getDuracion() {
            return duracion;
        }

        public double getPrecio() {
            return precio;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setDuracion(int duracion) {
            this.duracion = duracion;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
    }

    public static class Peluquero {
        private int id;
        private String nombre;
        private String especializacion;

        public Peluquero(int id, String nombre, String especializacion) {
            this.id = id;
            this.nombre = nombre;
            this.especializacion = especializacion;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEspecializacion() {
            return especializacion;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEspecializacion(String especializacion) {
            this.especializacion = especializacion;
        }
    }

    public static class ProductoBelleza {
        private int id;
        private String nombre;
        private String descripcion;
        private double precio;

        public ProductoBelleza(int id, String nombre, String descripcion, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
        }

        public int getId() {
            return id;
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

        public void setId(int id) {
            this.id = id;
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
    }

    public static void main(String[] args) {
        Peluquero peluquero1 = new Peluquero(1, "Carlos Perez", "Cortes de cabello");

        Servicio servicio1 = new Servicio("Corte de Cabello", "Corte de cabello estilo moderno", 30, 15.0);

        ProductoBelleza producto1 = new ProductoBelleza(1, "Champú", "Champú para cabello seco", 8.99);

        Cliente cliente1 = new Cliente(1, "Laura Gomez", "555-1234", "Av. Principal 123");

        cliente1.comprarProducto(producto1);

        cliente1.getServiciosRealizados().add(servicio1);

        System.out.println("Cliente: " + cliente1.getNombre());
        System.out.println("Teléfono: " + cliente1.getTelefono());
        System.out.println("Dirección: " + cliente1.getDireccion());
        System.out.println("Producto comprado: " + cliente1.getProductosComprados().get(0).getNombre() + ", Precio: $" + cliente1.getProductosComprados().get(0).getPrecio());
        System.out.println("Servicio realizado: " + cliente1.getServiciosRealizados().get(0).getNombre() + ", Precio: $" + cliente1.getServiciosRealizados().get(0).getPrecio());
    }
}
