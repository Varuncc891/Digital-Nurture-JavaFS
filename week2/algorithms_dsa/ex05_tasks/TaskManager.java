class Task {
    private String id;
    private String name;
    private String status;

    public Task(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

public class TaskManager {
    private class Node {
        Task task;
        Node next;
        Node(Task t) { this.task = t; }
    }

    private Node head;

    public void add(Task t) {
        Node newNode = new Node(t);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task search(String id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getId().equals(id)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task.getName());
            temp = temp.next;
        }
    }

    public void delete(String id) {
        if (head == null) return;
        if (head.task.getId().equals(id)) {
            head = head.next;
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.task.getId().equals(id)) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.add(new Task("10", "Write Code", "Pending"));
        tm.traverse();
    }
}