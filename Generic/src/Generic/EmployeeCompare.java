package Generic;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeCompare {
    public static void main(String[] args) {
        ArrayList<employee> employee = new ArrayList<>();
        employee.add(new employee("tom" , 2000 ,new MyDate(2002,10,17)));
        employee.add(new employee("jack" , 3000 ,new MyDate(2003,11,17)));
        employee.add(new employee("tracy" , 4000 ,new MyDate(2002,10,17)));
        employee.add(new employee("tom" , 2000 ,new MyDate(2003,10,17)));

        System.out.println(employee);

        //排序：先按照name排序，name相同按生日排序
        employee.sort(new Comparator<employee>() {
            @Override
            public int compare(employee emp1, employee emp2) {
                if (!(emp1 instanceof employee && emp2 instanceof employee)){
                    System.out.println("类型不匹配");
                    return 0;
                }
                int i = emp1.getName().compareTo(emp2.getName());
                if (i != 0){
                    return i;
                }
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        System.out.println(employee);
    }
}
