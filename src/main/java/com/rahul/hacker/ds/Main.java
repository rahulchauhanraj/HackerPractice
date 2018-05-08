package com.rahul.hacker.ds;

<<<<<<< Updated upstream
public class Main {

    public static void main(String args[]) {

=======
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class Main {

    private static DateFormat dateFormatSS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static DateFormat dateFormatMM = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");



    public static void main(String args[]) throws Exception {

        Employee e1 = new Employee("A", 1L, 0L);
        Employee e2 = new Employee("B", 2L, 1L);
        Employee e3 = new Employee("C", 3L, 1L);
        Employee e4 = new Employee("D", 4L, 2L);
        Employee e5 = new Employee("E", 5L, 2L);
        Employee e6 = new Employee("F", 6L, 5L);

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<Optional<Long>, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(e-> Optional.ofNullable(e.getManagerId())));

        System.out.println(result);
        /*String firstOccurance = "2018-03-14T14:12";
        DateFormat dateFormat = getDateFormat(firstOccurance);
        Date firstOccuranceDate = dateFormat.parse(firstOccurance);
        System.out.println(firstOccuranceDate);*/

        /*List list = new ArrayList<>(5);
        list.add(10);
        System.out.println(list.size());*/
    }

    private static DateFormat getDateFormat(String source) {
        int firstIndex = source.indexOf(':');
        int lastIndex = source.lastIndexOf(':');
        return ((firstIndex != lastIndex) && (lastIndex != (source.length()-1))) ? dateFormatSS : dateFormatMM;
    }

    /*
     * Complete the function below.
     */
    static int getUmbrellas(int n, int[] p) {
        if (n == 0 || p == null || p.length == 0) {
            return -1;
        }

        int lenP = p.length;

        int min = -1;

        for (int ind=0; ind < lenP; ind++) {
            int pVal = p[ind];
            if (pVal != 0) {
                int rem = n % pVal;

                if(rem == 0) {
                    int div = n / pVal;
                    if (min == -1 || div < min) {
                        min = div;
                    }

                }

            }
        }
        return min;
    }
}

class Employee{
    String name;
    Long id;
    Long managerId;

    public Employee(String name, Long id, Long managerId) {
        this.name = name;
        this.id = id;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", managerId=" + managerId +
            '}';
>>>>>>> Stashed changes
    }
}
