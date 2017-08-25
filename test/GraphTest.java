import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.andersenlab.graph.*;

public class GraphTest {
    @Test
    public void hasStartPoint() {
        try {
            Graph graph = new Graph.Builder()
                .edge(1, 3, 1)
                .edge(2, 3, 1)
                .edge(4, 5, 1)
                .edge(3, 4, 2)
                .edge(2, 1, 1)
                .build();
            assertEquals(true, graph.hasStartPoint(2));
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }
    @Test
    public void testHasEndPoint() {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 3, 1)
                    .edge(2, 3, 1)
                    .edge(4, 5, 1)
                    .edge(3, 4, 2)
                    .edge(2, 1, 1)
                    .build();
            assertEquals(false, graph.hasEndPoint(2));
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }
}