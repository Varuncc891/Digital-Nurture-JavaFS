class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

public class EmployeeManager {
    private Employee[] list = new Employee[100];
    private int size = 0;

    public void add(Employee e) {
        if (size < list.length) {
            list[size++] = e;
        }
    }

    public Employee search(String id) {
        for (int i = 0; i < size; i++) {
            if (list[i].getId().equals(id)) {
                return list[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(list[i].getName());
        }
    }

    public void delete(String id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            list[size - 1] = null;
            size--;
        }
    }

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        em.add(new Employee("1", "Alice", "Manager", 80000));
        em.traverse();
        em.delete("1");
    }
}