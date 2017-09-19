import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.andersenlab.graph.*;

public class GraphTest {
    @Test
    public void hasStartPoint() throws Exception {
        Graph graph = new Graph.Builder()
            .edge(1, 3, 1)
            .edge(2, 3, 1)
            .edge(4, 5, 1)
            .edge(3, 4, 2)
            .edge(2, 1, 1)
            .build();
        assertEquals(true, graph.hasStartPoint(2));
    }

    @Test
    public void testHasEndPoint() throws Exception {
        Graph graph = new Graph.Builder()
                .edge(1, 3, 1)
                .edge(2, 3, 1)
                .edge(4, 5, 1)
                .edge(3, 4, 2)
                .edge(2, 1, 1)
                .build();
        assertFalse(graph.hasEndPoint(2));
    }
}