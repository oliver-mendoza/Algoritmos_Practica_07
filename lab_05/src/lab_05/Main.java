package lab_05;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        gestor.agregarTarea(new Tarea("Escribir informe", 2));
        gestor.agregarTarea(new Tarea("Estudiar para examen", 3));
        gestor.agregarTarea(new Tarea("Revisar código", 1));
        gestor.eliminarTarea(new Tarea("Revisar código", 1));
        gestor.imprimirTareas();
        boolean existe = gestor.contieneTarea(new Tarea("Estudiar para examen", 3));
        System.out.println("¿Existe la tarea 'Estudiar para examen'? " + existe);
        gestor.invertirTareas();
        System.out.println("Lista invertida:");
        gestor.imprimirTareas();
        gestor.transferirATareasCompletadas(new Tarea("Estudiar para examen", 3));
        System.out.println("Lista de tareas pendientes:");
        gestor.imprimirTareas();
        System.out.println("Lista de tareas completadas:");
        gestor.imprimirTareasCompletadas();
        Tarea masPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("Tarea más prioritaria: " + masPrioritaria);
    }
}