package corejava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFilters {

    public static class Employee {
        String location;
        String name;
        int age;

        public Employee(String name, int age, String location) {
            this.location = location;
            this.name = name;
            this.age = age;
        }

        public String getLocation() {
            return location;
        }

        @Override
        public String toString() {
            return "{ " + name + ", " + age + ", " + location + " }";
        }
    }

    public static void main(String[] args) {
        List<List<Employee>> employees = new ArrayList<>(Arrays.asList(Arrays.asList(new Employee("Alice", 30, "New York"), new Employee("Bob", 25, "New York")), Arrays.asList(new Employee("Charlie", 35, "London"), new Employee("David", 40, "London")), Arrays.asList(new Employee("Eva", 28, "Tokyo"))));

        System.out.println(employees);
        List<Employee> flatList = employees.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);

//        Map<String, Long> collect = flatList.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting()));
        Map<String, List<Employee>> collect = flatList.stream().collect(Collectors.groupingBy(Employee::getLocation));
        System.out.println(collect);
    }
}
