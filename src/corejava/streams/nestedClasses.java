package corejava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class nestedClasses {
    static class Employee {
        String name;
        int age;
        List<Employee> reportees;

        public Employee(String name, int age, List<Employee> reportees) {
            this.name = name;
            this.age = age;
            this.reportees = reportees;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<Employee> getReportees() {
            return reportees;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    name + age +
                    '}';
        }
    }

    static final class Department {
        List<Employee> employees;
        String name;

        public Department(List<Employee> employees, String name) {
            this.employees = employees;
            this.name = name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "employees=" + employees +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee rohanEmp = new Employee("Rohan", 26, null);
        Employee yashEmp = new Employee("Yash", 27, null);
        Employee sachinEmp = new Employee("Sachin", 29, new ArrayList<>(Arrays.asList(yashEmp, rohanEmp)));

        Employee jyotiEmp = new Employee("Jyoti", 39, null);

        Employee vishalEmp = new Employee("Vishal", 38, new ArrayList<>(Arrays.asList(sachinEmp, yashEmp, rohanEmp)));
        Employee rajeshEmp = new Employee("Rajesh", 45, new ArrayList<>(Arrays.asList(vishalEmp, jyotiEmp)));

        Department devArr = new Department(new ArrayList(Arrays.asList(vishalEmp, sachinEmp, yashEmp, rohanEmp)), "Technology");
        Department qaArr = new Department(new ArrayList(Arrays.asList(jyotiEmp)), "QA");
        Department mngArr = new Department(new ArrayList(Arrays.asList(rajeshEmp)), "Management");

        System.out.println(getLessThan30(new ArrayList<>(Arrays.asList(devArr, mngArr))));
    }

    static List<Employee> getLessThan30(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getAge() < 30)
                .collect(Collectors.toList()); // Collect into an immutable list
    }

}
