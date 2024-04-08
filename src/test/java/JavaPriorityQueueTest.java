import org.example.JavaPriorityQueue;
import org.example.Pacient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavaPriorityQueueTest {

    private JavaPriorityQueue<Pacient> javaPriorityQueue;

    @Before
    public void setUp() {
        javaPriorityQueue = new JavaPriorityQueue<>();
    }

    @Test
    public void testAddAndPeek() {
        Pacient pacient1 = new Pacient("Paciente A", "Condición A", 'A');
        Pacient pacient2 = new Pacient("Paciente B", "Condición B", 'B');
        javaPriorityQueue.add(pacient1);
        javaPriorityQueue.add(pacient2);

        Assert.assertEquals("El paciente con mayor prioridad debe ser el primero", pacient1, javaPriorityQueue.peeck());
    }

    @Test
    public void testRemove() {
        Pacient pacient1 = new Pacient("Paciente A", "Condición A", 'A');
        Pacient pacient2 = new Pacient("Paciente B", "Condición B", 'B');
        javaPriorityQueue.add(pacient1);
        javaPriorityQueue.add(pacient2);

        Assert.assertEquals("Al remover, se debe retornar el paciente con mayor prioridad", pacient1, javaPriorityQueue.remove());
        Assert.assertFalse("La cola no debe estar vacía después de remover un elemento", javaPriorityQueue.isEmpty());
        Assert.assertEquals("El siguiente paciente debe ser el de la siguiente mayor prioridad", pacient2, javaPriorityQueue.peeck());
    }

    // Más tests según sea necesario para cubrir el comportamiento esperado y casos de esquina
}
