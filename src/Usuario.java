import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Tarea> tareas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completar();
        }
    }
}
