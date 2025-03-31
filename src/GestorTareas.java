import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completar();
        }
    }
}
