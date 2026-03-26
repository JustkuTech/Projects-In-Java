import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class gym {

    public static class Socio {
        private int id;
        private String nombre;
        private String direccion;
        private LocalDate fechaInicioMembresia;
        private String estadoMembresia;
        private List<Reserva> reservas;

        public Socio(int id, String nombre, String direccion, LocalDate fechaInicioMembresia, String estadoMembresia) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.fechaInicioMembresia = fechaInicioMembresia;
            this.estadoMembresia = estadoMembresia;
            this.reservas = new ArrayList<>();
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

        public LocalDate getFechaInicioMembresia() {
            return fechaInicioMembresia;
        }

        public String getEstadoMembresia() {
            return estadoMembresia;
        }

        public List<Reserva> getReservas() {
            return reservas;
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

        public void setFechaInicioMembresia(LocalDate fechaInicioMembresia) {
            this.fechaInicioMembresia = fechaInicioMembresia;
        }

        public void setEstadoMembresia(String estadoMembresia) {
            this.estadoMembresia = estadoMembresia;
        }

        public void inscribirseClase(Clase clase) {
            Reserva reserva = new Reserva(LocalDateTime.now());
            reserva.asociarSocio(this);
            reserva.asociarClase(clase);
            this.reservas.add(reserva);
            clase.añadirReserva(reserva);
        }

        public void reservarEquipo(Equipo equipo) {
            Reserva reserva = new Reserva(LocalDateTime.now());
            reserva.asociarSocio(this);
            reserva.asociarEquipo(equipo);
            this.reservas.add(reserva);
            equipo.reservar(reserva.getFechaHoraReserva().toLocalTime());
        }
    }

    public static class Entrenador {
        private int id;
        private String nombre;
        private String especialidad;

        public Entrenador(int id, String nombre, String especialidad) {
            this.id = id;
            this.nombre = nombre;
            this.especialidad = especialidad;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public void dirigirClase(Clase clase) {
            clase.setEntrenador(this);
        }
    }

    public static class Clase {
        private String nombre;
        private String descripcion;
        private int capacidadMaxima;
        private LocalTime horaInicio;
        private List<Reserva> reservas;
        private Entrenador entrenador;

        public Clase(String nombre, String descripcion, int capacidadMaxima, LocalTime horaInicio) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.capacidadMaxima = capacidadMaxima;
            this.horaInicio = horaInicio;
            this.reservas = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getCapacidadMaxima() {
            return capacidadMaxima;
        }

        public LocalTime getHoraInicio() {
            return horaInicio;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }

        public Entrenador getEntrenador() {
            return entrenador;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setCapacidadMaxima(int capacidadMaxima) {
            this.capacidadMaxima = capacidadMaxima;
        }

        public void setHoraInicio(LocalTime horaInicio) {
            this.horaInicio = horaInicio;
        }

        public void setEntrenador(Entrenador entrenador) {
            this.entrenador = entrenador;
        }

        public void añadirReserva(Reserva reserva) {
            this.reservas.add(reserva);
        }
    }

    public static class Equipo {
        private int id;
        private String nombre;
        private String estado;
        private LocalTime tiempoReserva;
        private List<Reserva> reservas;

        public Equipo(int id, String nombre, String estado, LocalTime tiempoReserva) {
            this.id = id;
            this.nombre = nombre;
            this.estado = estado;
            this.tiempoReserva = tiempoReserva;
            this.reservas = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEstado() {
            return estado;
        }

        public LocalTime getTiempoReserva() {
            return tiempoReserva;
        }

        public List<Reserva> getReservas() {
            return reservas;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setTiempoReserva(LocalTime tiempoReserva) {
            this.tiempoReserva = tiempoReserva;
        }

        public void reservar(LocalTime tiempo) {
            this.tiempoReserva = tiempo;
            Reserva reserva = new Reserva(LocalDateTime.now());
            reserva.asociarEquipo(this);
            this.reservas.add(reserva);
        }
    }

    public static class Reserva {
        private LocalDateTime fechaHoraReserva;
        private Socio socio;
        private Clase clase;
        private Equipo equipo;

        public Reserva(LocalDateTime fechaHoraReserva) {
            this.fechaHoraReserva = fechaHoraReserva;
        }

        public LocalDateTime getFechaHoraReserva() {
            return fechaHoraReserva;
        }

        public Socio getSocio() {
            return socio;
        }

        public Clase getClase() {
            return clase;
        }

        public Equipo getEquipo() {
            return equipo;
        }

        public void setFechaHoraReserva(LocalDateTime fechaHoraReserva) {
            this.fechaHoraReserva = fechaHoraReserva;
        }

        public void asociarSocio(Socio socio) {
            this.socio = socio;
        }

        public void asociarClase(Clase clase) {
            this.clase = clase;
        }

        public void asociarEquipo(Equipo equipo) {
            this.equipo = equipo;
        }
    }

    public static void main(String[] args) {
        Socio socio1 = new Socio(1, "Carlos Ruiz", "Calle Principal 123", LocalDate.of(2023, 1, 15), "Activo");
        Entrenador entrenador1 = new Entrenador(1, "Laura García", "Yoga");
        Clase clase1 = new Clase("Yoga Matutino", "Clase de yoga para principiantes", 20, LocalTime.of(9, 0));
        Equipo equipo1 = new Equipo(1, "Bicicleta Estática", "Disponible", null);

        socio1.inscribirseClase(clase1);
        entrenador1.dirigirClase(clase1);
        socio1.reservarEquipo(equipo1);

        System.out.println("Socio: " + socio1.getNombre() + ", Dirección: " + socio1.getDireccion() + ", Fecha Inicio Membresía: " + socio1.getFechaInicioMembresia() + ", Estado Membresía: " + socio1.getEstadoMembresia());
        System.out.println("Entrenador: " + entrenador1.getNombre() + ", Especialidad: " + entrenador1.getEspecialidad());
        System.out.println("Clase: " + clase1.getNombre() + ", Descripción: " + clase1.getDescripcion() + ", Capacidad Máxima: " + clase1.getCapacidadMaxima() + ", Hora Inicio: " + clase1.getHoraInicio());
        System.out.println("Equipo: " + equipo1.getNombre() + ", Estado: " + equipo1.getEstado() + ", Tiempo Reserva: " + equipo1.getTiempoReserva());
        System.out.println("Reservas del Socio: " + socio1.getReservas().size());
        for (Reserva reserva : socio1.getReservas()) {
            System.out.println("Reserva Fecha y Hora: " + reserva.getFechaHoraReserva() + ", Clase: " + (reserva.getClase() != null ? reserva.getClase().getNombre() : "N/A") + ", Equipo: " + (reserva.getEquipo() != null ? reserva.getEquipo().getNombre() : "N/A"));
        }
    }
}
