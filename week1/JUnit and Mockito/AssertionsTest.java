import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testBasicAssertions() {
        String str1 = "JUnit";
        String str2 = "JUnit";
        String str3 = null;

        assertEquals(str1, str2);
        assertTrue(5 > 3);
        assertFalse(3 > 5);
        assertNull(str3);
        assertNotNull(str1);
    }
}
