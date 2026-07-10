interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer Details for ID " + id;
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository r) {
        this.repository = r;
    }

    public String getCustomerInfo(String id) {
        return repository.findCustomerById(id);
    }
}

public class DIDemo {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        System.out.println(service.getCustomerInfo("CUST123"));
    }
}