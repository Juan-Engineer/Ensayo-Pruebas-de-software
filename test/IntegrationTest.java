import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    public void testFlujoCompletoTareas() {
        // 1. Configuración
        Usuario usuario = new Usuario("UsuarioIntegracion");
        GestorTareas gestor = new GestorTareas();
        
        // 2. Ejecución
        gestor.agregarTarea("Tarea 1"); // Método REAL del GestorTareas
        gestor.agregarTarea("Tarea 2");
        
        usuario.agregarTarea("Tarea personal"); // Método REAL del Usuario
        gestor.completarTarea(0); // Completa la primera tarea del gestor
        
        // 3. Verificaciones
        // Verifica el Gestor
        assertEquals(2, gestor.obtenerTareas().size());
        assertTrue(gestor.obtenerTareas().get(0).isCompletada());
        
        // Verifica el Usuario
        assertEquals(1, usuario.getTareas().size());
        assertFalse(usuario.getTareas().get(0).isCompletada());
    }
}
