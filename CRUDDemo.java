import java.util.*;

class Employee {
    private int empno;
    private String name;
    private int salary;

    Employee(int empno, String name, int salary) {
        this.empno = empno;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return empno + "  " + name + "  " + salary;
    }
}

class CRUDDemo {
    public static void main(String[] args) {
        List<Employee> c = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Update");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter empno: ");
                    int empno = sc.nextInt();
                    sc.nextLine(); // Consume newline left-over
                    System.out.print("Enter name: ");
                    String name = s1.nextLine();
                    System.out.print("Enter salary: ");
                    int salary = sc.nextInt();

                    c.add(new Employee(empno, name, salary));
                    break;

                case 2:
                    System.out.println("-----------------------------");
                    Iterator<Employee> i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("-----------------------------");
                    break;

                case 3:
                    System.out.print("Enter empno to search: ");
                    int empno1 = sc.nextInt();
                    boolean found = false; // Declare found here
                    System.out.println("-----------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmpno() == empno1) {
                            System.out.println(e);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found");
                    }
                    System.out.println("-----------------------------");
                    break;

                case 4:
                    System.out.print("Enter empno to delete: ");
                    empno1 = sc.nextInt();
                    found = false; // Declare found here
                    System.out.println("-----------------------------");
                    ListIterator<Employee> liRemove = c.listIterator();
                    while (liRemove.hasNext()) {
                        Employee e = liRemove.next();
                        if (e.getEmpno() == empno1) {
                            liRemove.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found");
                    } else {
                        System.out.println("Employee record is deleted");
                    }
                    System.out.println("-----------------------------");
                    break;

                case 5:
                    System.out.print("Enter empno to update: ");
                    empno1 = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    found = false; // Declare found here
                    System.out.println("-----------------------------");
                    ListIterator<Employee> li = c.listIterator();
                    while (li.hasNext()) {
                        Employee e = li.next();
                        if (e.getEmpno() == empno1) {
                            System.out.print("Enter new name: ");
                            String newName = s1.nextLine(); // Use newName to avoid conflict

                            System.out.print("Enter the new salary: ");
                            int newSalary = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            // Update the Employee details
                            li.set(new Employee(empno1, newName, newSalary));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found");
                    } else {
                        System.out.println("Employee record is updated successfully");
                    }
                    System.out.println("-----------------------------");
                    break;
            }
        } while (ch != 0);

        sc.close();
        s1.close();
    }
}
