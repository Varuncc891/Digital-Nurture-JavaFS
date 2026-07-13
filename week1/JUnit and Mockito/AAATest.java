import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AAATest {
    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @AfterEach
    public void tearDown() {
        list.clear();
        list = null;
    }

    @Test
    public void testAddElement() {
        // Arrange
        String element = "element";

        // Act
        list.add(element);

        // Assert
        assertEquals(1, list.size());
        assertEquals("element", list.get(0));
    }
}
