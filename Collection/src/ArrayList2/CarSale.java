package ArrayList2;

import java.util.ArrayList;
import java.util.Iterator;

public class CarSale {
    public static void main(String[] args) {
        CAR car1 = new CAR("宝马", 400000);
        CAR car2 = new CAR("宾利", 500000);

        /**
         * add:添加单个元素
         * remove:删除指定元素
         * contains:查找元素是否存在
         * size:获取元素个数
         * isEmpty:判断是否为空
         * clear:清空
         * addAll:添加多个元素
         * containsAll:查找多个元素是否都存在
         * removeAll:删除多个元素*/

        ArrayList arrayList = new ArrayList();  //添加元素
        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println(arrayList);

        arrayList.remove(car1);//删除元素
        System.out.println(arrayList);

        System.out.println(arrayList.contains(car1)); //判断是否存在

        System.out.println(arrayList.size());  //判断元素个数

        System.out.println(arrayList.isEmpty());  //判断是否为空

        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car1);
        arrayList.addAll(arrayList2);  //添加多个元素
        System.out.println(arrayList);

        arrayList.containsAll(arrayList2);  //检查是否包含

        arrayList.removeAll(arrayList2);  //删除多个元素

        Iterator iterator = arrayList.iterator();  //迭代器遍历
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        for (Object o :arrayList) {  //增强for循环遍历
            System.out.println(o);
        }

    }
}
