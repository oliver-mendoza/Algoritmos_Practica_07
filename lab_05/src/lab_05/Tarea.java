package lab_05;

public class Tarea {
    private String titulo;
    private int prioridad;
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getPrioridad() {
        return prioridad;
    }
    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tarea)) return false;
        Tarea otra = (Tarea) obj;
        return this.titulo.equals(otra.titulo) && this.prioridad == otra.prioridad;
    }
}