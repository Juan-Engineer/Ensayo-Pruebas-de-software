import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    
    @Test
    public void testAgregarTarea() {
        Usuario usuario = new Usuario("TestUser");
        usuario.agregarTarea("Tarea de prueba");
        
        assertEquals(1, usuario.getTareas().size());
        assertEquals("Tarea de prueba", usuario.getTareas().get(0).getDescripcion());
    }

    @Test
    public void testCompletarTarea() {
        Usuario usuario = new Usuario("TestUser");
        usuario.agregarTarea("Tarea para completar");
        
        assertFalse(usuario.getTareas().get(0).isCompletada());
        usuario.completarTarea(0);
        assertTrue(usuario.getTareas().get(0).isCompletada());
    }

    @Test
    public void testCompletarTareaInvalida() {
        Usuario usuario = new Usuario("TestUser");
        usuario.agregarTarea("Tarea 1");
        
        // Índice negativo
        usuario.completarTarea(-1);
        assertFalse(usuario.getTareas().get(0).isCompletada());
        
        // Índice fuera de rango
        usuario.completarTarea(1);
        assertFalse(usuario.getTareas().get(0).isCompletada());
    }
}