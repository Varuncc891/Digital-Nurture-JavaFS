import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testProcessDataWithStubbingAndVerification() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.fetchData("valid_query")).thenReturn("valid_data");

        MyService service = new MyService(mockApi);
        String result = service.processData("valid_query");

        assertEquals("Processed: valid_data", result);
        verify(mockApi, times(1)).fetchData("valid_query");
    }

    @Test
    public void testProcessDataWithNullResponse() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.fetchData("invalid_query")).thenReturn(null);

        MyService service = new MyService(mockApi);
        String result = service.processData("invalid_query");

        assertEquals("No Data", result);
        verify(mockApi, times(1)).fetchData("invalid_query");
    }
}
