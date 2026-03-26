import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class restaurante {

    public static class Mesa {
        private int id;
        private String estado;
        private List<Pedido> pedidos;

        public Mesa(int id, String estado) {
            this.id = id;
            this.estado = estado;
            this.pedidos = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getEstado() {
            return estado;
        }

        public List<Pedido> getPedidos() {
            return pedidos;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void registrarPedido(Pedido pedido) {
            this.pedidos.add(pedido);
        }
    }

    public static class Cliente {
        private String nombre;
        private String telefono;
        private int numComensales;

        public Cliente(String nombre, String telefono, int numComensales) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.numComensales = numComensales;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public int getNumComensales() {
            return numComensales;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setNumComensales(int numComensales) {
            this.numComensales = numComensales;
        }
    }

    public static class Plato {
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;

        public Plato(String nombre, String descripcion, double precio, String categoria) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
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
    }

    public static class Pedido {
        private Mesa mesa;
        private List<Plato> platos;
        private LocalDateTime fechaHora;
        private Camarero camarero;
        private List<Chef> chefs;

        public Pedido(Mesa mesa, List<Plato> platos, LocalDateTime fechaHora, Camarero camarero) {
            this.mesa = mesa;
            this.platos = platos;
            this.fechaHora = fechaHora;
            this.camarero = camarero;
            this.chefs = new ArrayList<>();
        }

        public Mesa getMesa() {
            return mesa;
        }

        public List<Plato> getPlatos() {
            return platos;
        }

        public LocalDateTime getFechaHora() {
            return fechaHora;
        }

        public Camarero getCamarero() {
            return camarero;
        }

        public List<Chef> getChefs() {
            return chefs;
        }

        public void setMesa(Mesa mesa) {
            this.mesa = mesa;
        }

        public void setPlatos(List<Plato> platos) {
            this.platos = platos;
        }

        public void setFechaHora(LocalDateTime fechaHora) {
            this.fechaHora = fechaHora;
        }

        public void setCamarero(Camarero camarero) {
            this.camarero = camarero;
        }

        public void addChef(Chef chef) {
            this.chefs.add(chef);
        }
    }

    public static class Chef {
        private String nombre;
        private String especialidad;

        public Chef(String nombre, String especialidad) {
            this.nombre = nombre;
            this.especialidad = especialidad;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }
    }

    public static class Camarero {
        private String nombre;
        private int numEmpleado;

        public Camarero(String nombre, int numEmpleado) {
            this.nombre = nombre;
            this.numEmpleado = numEmpleado;
        }

        public String getNombre() {
            return nombre;
        }

        public int getNumEmpleado() {
            return numEmpleado;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setNumEmpleado(int numEmpleado) {
            this.numEmpleado = numEmpleado;
        }
    }

    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1, "Disponible");

        Cliente cliente1 = new Cliente("Ana Lopez", "555-1234", 4);

        Plato plato1 = new Plato("Spaghetti", "Spaghetti con salsa de tomate", 12.5, "Principal");
        Plato plato2 = new Plato("Tiramisu", "Postre italiano de café", 6.5, "Postre");

        Camarero camarero1 = new Camarero("Luis Perez", 101);

        Pedido pedido1 = new Pedido(mesa1, List.of(plato1, plato2), LocalDateTime.now(), camarero1);

        mesa1.registrarPedido(pedido1);

        Chef chef1 = new Chef("Gordon Ramsay", "Gourmet");
        pedido1.addChef(chef1);

        System.out.println("Mesa ID: " + mesa1.getId() + ", Estado: " + mesa1.getEstado());
        System.out.println("Cliente: " + cliente1.getNombre() + ", Teléfono: " + cliente1.getTelefono() + ", Número de comensales: " + cliente1.getNumComensales());
        System.out.println("Pedido realizado el: " + pedido1.getFechaHora() + ", Camarero: " + pedido1.getCamarero().getNombre());
        for (Plato plato : pedido1.getPlatos()) {
            System.out.println("Plato: " + plato.getNombre() + ", Descripción: " + plato.getDescripcion() + ", Precio: $" + plato.getPrecio() + ", Categoría: " + plato.getCategoria());
        }
        for (Chef chef : pedido1.getChefs()) {
            System.out.println("Chef: " + chef.getNombre() + ", Especialidad: " + chef.getEspecialidad());
        }
    }
}

