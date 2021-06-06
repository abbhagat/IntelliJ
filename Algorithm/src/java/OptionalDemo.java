package java;

import java.util.*;

public class OptionalDemo {

    private static List<Map<String, List<Employee>>> mapList = new ArrayList<>();

    static {
        Map<String, List<Employee>> map1 = new HashMap<>();
        map1.put("V705417", Arrays.asList(null, new Employee(1, "A"), new Employee(2, "B")));
        mapList.add(map1);

        Map<String, List<Employee>> map2 = new HashMap<>();
        map2.put("F638247", Arrays.asList(null, new Employee(3, "C"), new Employee(4, "D")));
        mapList.add(map2);

        Map<String, List<Employee>> map3 = new HashMap<>();
        map3.put("D987456", Arrays.asList(null, new Employee(5, "E"), new Employee(6, "F")));
        mapList.add(map3);

        mapList.add(null);
    }

    public static List<Map<String, List<Employee>>> getMapList() {
        return mapList;
    }

    public static void main(String[] args) {

        Optional<List<Map<String, List<Employee>>>> optionalMapList = Optional.ofNullable(getMapList());
        if (optionalMapList.isPresent()) {
            Optional<Map<String, List<Employee>>> optionalMap = Optional.ofNullable(optionalMapList.get().get(3));
            if (optionalMap.isPresent()) {
                Optional<List<Employee>> map = Optional.ofNullable(optionalMap.get().get("V705417"));
                List<Employee> employeeList = map.get();
                employeeList.forEach(System.out::println);
            }
        }
    }
}
