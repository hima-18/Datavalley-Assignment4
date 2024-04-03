import java.util.Comparator;

public class EmployeeList {

    public static void main(String[] args) {
        // Create some employee objects
        Employee emp1 = new Employee(1, "Alice", "Manager", 80000);
        Employee emp2 = new Employee(2, "Bob", "Engineer", 60000);
        Employee emp3 = new Employee(3, "Charlie", "Developer", 70000);
        Employee emp4 = new Employee(4, "Alice", "Sales", 50000);

        // Create a linked list and add employees
        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        System.out.println("Employees before sorting:");
        printList(employeeList);

        // Sort the list using a custom comparator
        employeeList.sort(new EmployeeComparator());

        System.out.println("\nEmployees after sorting by name and salary:");
        printList(employeeList);
    }

    public static void printList(LinkedList<Employee> list) {
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }
}

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        int nameComparison = emp1.name.compareTo(emp2.name);
        return nameComparison == 0 ? Double.compare(emp1.salary, emp2.salary) : nameComparison;
    }
}
