import org.example.Pacient;
import org.example.VectorHeap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Pacient> vectorHeap;

    @Before
    public void setUp() {
        vectorHeap = new VectorHeap<>();
    }

    @Test
    public void testAddAndPeek() {
        Pacient pacient1 = new Pacient("Paciente A", "Condición A", 'A');
        Pacient pacient2 = new Pacient("Paciente B", "Condición B", 'B');
        vectorHeap.add(pacient1);
        vectorHeap.add(pacient2);

        Assert.assertEquals("El paciente con mayor prioridad debe ser el primero", pacient1, vectorHeap.peeck());
    }

    @Test
    public void testRemove() {
        Pacient pacient1 = new Pacient("Paciente A", "Condición A", 'A');
        Pacient pacient2 = new Pacient("Paciente B", "Condición B", 'B');
        vectorHeap.add(pacient1);
        vectorHeap.add(pacient2);

        Assert.assertEquals("Al remover, se debe retornar el paciente con mayor prioridad", pacient1, vectorHeap.remove());
        Assert.assertFalse("El heap no debe estar vacío después de remover un elemento", vectorHeap.isEmpty());
        Assert.assertEquals("El siguiente paciente debe ser el de la siguiente mayor prioridad", pacient2, vectorHeap.peeck());
    }

}
