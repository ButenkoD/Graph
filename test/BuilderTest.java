import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.andersenlab.graph.*;

public class BuilderTest {
    @Test
    public void testBuilder() {
        try {
            Graph graph = new Graph.Builder()
                .edge(1, 3, 1)
                .build();
            assertEquals("Graph", graph.getClass().getSimpleName());
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }
    @Test
    public void testBuilderException() {
        try {
            Graph graph = new Graph.Builder()
                .edge(1, 1, 1)
                .build();
            assertEquals("Graph", graph.getClass().getSimpleName());
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }
}