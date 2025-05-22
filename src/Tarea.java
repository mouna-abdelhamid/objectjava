import java.util.ArrayList;
import java.util.List;
public class Tarea {
    private String titulo;
    private String descripcion;
    private boolean completada; //

    public Tarea() {    }

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    // Método toString para mostrar información de la tarea
    @Override
    public String toString() {
        return "Título: " + titulo + ", Descripción: " + descripcion +
                ", Estado: " + (completada ? "Completada" : "Pendiente");
    }
    public void calling(){
        List<Tarea> listaTareas = new ArrayList<>();
        listaTareas.add(new Tarea("Comprar pan", "Ir a la panadería a comprar pan"));
        listaTareas.add(new Tarea("Estudiar Java", "Repasar conceptos de POO"));
        listaTareas.add(new Tarea("Hacer ejercicio", "Salir a correr 30 minutos"));
        System.out.println("Todas las tareas:");
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea);
        }
        listaTareas.get(1).marcarComoCompletada();

        System.out.println("\nDespués de marcar tarea 2 como completada:");
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea);
        }
        int contadorCompletadas = 0;
        for (Tarea tarea : listaTareas) {
            if (tarea.isCompletada()) {
                contadorCompletadas++;
            }
        }
        System.out.println("\nNúmero de tareas completadas: " + contadorCompletadas);
        System.out.println("\nTareas pendientes:");
        for (Tarea tarea : listaTareas) {
            if (!tarea.isCompletada()) {
                System.out.println(tarea);
            }
        }
    }

}

