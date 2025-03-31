import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testAgregarTarea() {
        Usuario usuario = new Usuario("Juan");
        usuario.agregarTarea("Comprar plástico reciclado");
        
        assertEquals(1, usuario.getTareas().size(), "Debe haber exactamente 1 tarea en la lista.");
        assertEquals("Comprar plástico reciclado", usuario.getTareas().get(0).getDescripcion(), "La tarea agregada no coincide.");
    }
}
