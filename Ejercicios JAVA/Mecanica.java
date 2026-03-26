import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mecanica {

    public static class Vehiculo {
        private int id;
        private String marca;
        private String modelo;
        private int añoFabricacion;
        private String numeroPlaca;
        private String propietario;
        private List<OrdenTrabajo> ordenesTrabajo;

        public Vehiculo(int id, String marca, String modelo, int añoFabricacion, String numeroPlaca, String propietario) {
            this.id = id;
            this.marca = marca;
            this.modelo = modelo;
            this.añoFabricacion = añoFabricacion;
            this.numeroPlaca = numeroPlaca;
            this.propietario = propietario;
            this.ordenesTrabajo = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public int getAñoFabricacion() {
            return añoFabricacion;
        }

        public String getNumeroPlaca() {
            return numeroPlaca;
        }

        public String getPropietario() {
            return propietario;
        }

        public List<OrdenTrabajo> getOrdenesTrabajo() {
            return ordenesTrabajo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setAñoFabricacion(int añoFabricacion) {
            this.añoFabricacion = añoFabricacion;
        }

        public void setNumeroPlaca(String numeroPlaca) {
            this.numeroPlaca = numeroPlaca;
        }

        public void setPropietario(String propietario) {
            this.propietario = propietario;
        }

        public void registrarOrdenTrabajo(OrdenTrabajo orden) {
            this.ordenesTrabajo.add(orden);
        }
    }

    public static class OrdenTrabajo {
        private Vehiculo vehiculo;
        private String servicios;
        private Mecanico mecanicoAsignado;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private List<PiezaRepuesto> piezasRepuesto;

        public OrdenTrabajo(Vehiculo vehiculo, String servicios, Mecanico mecanicoAsignado, LocalDate fechaInicio, LocalDate fechaFin) {
            this.vehiculo = vehiculo;
            this.servicios = servicios;
            this.mecanicoAsignado = mecanicoAsignado;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.piezasRepuesto = new ArrayList<>();
        }

        public Vehiculo getVehiculo() {
            return vehiculo;
        }

        public String getServicios() {
            return servicios;
        }

        public Mecanico getMecanicoAsignado() {
            return mecanicoAsignado;
        }

        public LocalDate getFechaInicio() {
            return fechaInicio;
        }

        public LocalDate getFechaFin() {
            return fechaFin;
        }

        public List<PiezaRepuesto> getPiezasRepuesto() {
            return piezasRepuesto;
        }

        public void setVehiculo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
        }

        public void setServicios(String servicios) {
            this.servicios = servicios;
        }

        public void setMecanicoAsignado(Mecanico mecanicoAsignado) {
            this.mecanicoAsignado = mecanicoAsignado;
        }

        public void setFechaInicio(LocalDate fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public void setFechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
        }

        public void addPiezaRepuesto(PiezaRepuesto pieza) {
            this.piezasRepuesto.add(pieza);
        }
    }

    public static class Mecanico {
        private int id;
        private String nombre;
        private String especializacion;

        public Mecanico(int id, String nombre, String especializacion) {
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

    public static class PiezaRepuesto {
        private int id;
        private String nombre;
        private String descripcion;
        private double precio;
        private int cantidadStock;

        public PiezaRepuesto(int id, String nombre, String descripcion, double precio, int cantidadStock) {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.cantidadStock = cantidadStock;
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

        public int getCantidadStock() {
            return cantidadStock;
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

        public void setCantidadStock(int cantidadStock) {
            this.cantidadStock = cantidadStock;
        }
    }

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo(1, "Toyota", "Corolla", 2015, "ABC123", "Juan Perez");
        Mecanico mecanico1 = new Mecanico(1, "Carlos Gomez", "Motores");
        
        PiezaRepuesto pieza1 = new PiezaRepuesto(1, "Filtro de aceite", "Filtro para motor", 15.99, 50);
        PiezaRepuesto pieza2 = new PiezaRepuesto(2, "Bujía", "Bujía para motor", 9.99, 100);

        OrdenTrabajo orden1 = new OrdenTrabajo(vehiculo1, "Cambio de aceite y bujías", mecanico1, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 5, 12));
        orden1.addPiezaRepuesto(pieza1);
        orden1.addPiezaRepuesto(pieza2);

        vehiculo1.registrarOrdenTrabajo(orden1);

        System.out.println("Vehiculo ID: " + vehiculo1.getId() + ", Marca: " + vehiculo1.getMarca() + ", Modelo: " + vehiculo1.getModelo() + ", Año: " + vehiculo1.getAñoFabricacion() + ", Placa: " + vehiculo1.getNumeroPlaca() + ", Propietario: " + vehiculo1.getPropietario());
        System.out.println("Orden de Trabajo - Servicios: " + orden1.getServicios() + ", Fecha Inicio: " + orden1.getFechaInicio() + ", Fecha Fin: " + orden1.getFechaFin() + ", Mecanico: " + orden1.getMecanicoAsignado().getNombre());
        for (PiezaRepuesto pieza : orden1.getPiezasRepuesto()) {
            System.out.println("Pieza Repuesto - Nombre: " + pieza.getNombre() + ", Descripción: " + pieza.getDescripcion() + ", Precio: $" + pieza.getPrecio() + ", Stock: " + pieza.getCantidadStock());
        }
    }
}
