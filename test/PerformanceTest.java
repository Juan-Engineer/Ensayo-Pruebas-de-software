import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testAgregar1000TareasRapido() {
        Usuario usuario = new Usuario("PerfTest");
        for (int i = 0; i < 1000; i++) {
            usuario.agregarTarea("Tarea " + i);
        }
    }
}
