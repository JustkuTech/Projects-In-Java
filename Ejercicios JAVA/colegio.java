import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class colegio {

    class Estudiante {
        private int id;
        private String nombre;
        private Date fechaNacimiento;
        private String direccion;
        private List<Curso> cursosInscritos;

        public Estudiante(int id, String nombre, Date fechaNacimiento, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
            this.direccion = direccion;
            this.cursosInscritos = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public String getDireccion() {
            return direccion;
        }

        public List<Curso> getCursosInscritos() {
            return cursosInscritos;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void registrarCalificacion(Curso curso, double calificacion, Date fecha) {
            Calificacion calificacionObj = new Calificacion(this, curso, calificacion, fecha);
            curso.getCalificaciones().add(calificacionObj);
            this.cursosInscritos.add(curso);
        }
    }

    class Profesor {
        private int id;
        private String nombre;
        private String especialidad;

        public Profesor(int id, String nombre, String especialidad) {
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
    }

    class Curso {
        private String nombre;
        private String descripcion;
        private String horario;
        private Profesor profesorAsignado;
        private List<Calificacion> calificaciones;

        public Curso(String nombre, String descripcion, String horario, Profesor profesorAsignado) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.horario = horario;
            this.profesorAsignado = profesorAsignado;
            this.calificaciones = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getHorario() {
            return horario;
        }

        public Profesor getProfesorAsignado() {
            return profesorAsignado;
        }

        public List<Calificacion> getCalificaciones() {
            return calificaciones;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        public void setProfesorAsignado(Profesor profesorAsignado) {
            this.profesorAsignado = profesorAsignado;
        }
    }

    class Calificacion {
        private Estudiante estudiante;
        private Curso curso;
        private double nota;
        private Date fecha;

        public Calificacion(Estudiante estudiante, Curso curso, double nota, Date fecha) {
            this.estudiante = estudiante;
            this.curso = curso;
            this.nota = nota;
            this.fecha = fecha;
        }

        public Estudiante getEstudiante() {
            return estudiante;
        }

        public Curso getCurso() {
            return curso;
        }

        public double getNota() {
            return nota;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
        }

        public void setCurso(Curso curso) {
            this.curso = curso;
        }

        public void setNota(double nota) {
            this.nota = nota;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
    }

    public static void main(String[] args) {
        colegio colegio = new colegio();

        Profesor profesor1 = colegio.new Profesor(1, "Dr. Smith", "Matemáticas");

        Curso curso1 = colegio.new Curso("Álgebra", "Curso de álgebra básica", "Lunes y Miércoles 10-12", profesor1);

        Estudiante estudiante1 = colegio.new Estudiante(1, "Juan Perez", new Date(100, 0, 1), "Calle Falsa 123"); 

        estudiante1.registrarCalificacion(curso1, 95.5, new Date(124, 4, 15)); 

        System.out.println("Estudiante: " + estudiante1.getNombre() + ", Curso Inscrito: " + estudiante1.getCursosInscritos().get(0).getNombre() + ", Nota: " + curso1.getCalificaciones().get(0).getNota());
    }
}
