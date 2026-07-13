public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String processData(String query) {
        String data = externalApi.fetchData(query);
        if (data == null) {
            return "No Data";
        }
        return "Processed: " + data;
    }
}
