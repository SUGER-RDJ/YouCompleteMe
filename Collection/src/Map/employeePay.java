package Map;
import java.util.Iterator;
import java.util.Map;

import java.util.HashMap;
import java.util.Set;

public class employeePay {
    public static void main(String[] args) {

        Map hashmap = new HashMap();
        hashmap.put("jack" , 650); //int->Integer
        hashmap.put("tom" , 1200);
        hashmap.put("smith" , 2500);
        System.out.println(hashmap);

        hashmap.put("jack" , 2600); //相当于替换更新
        System.out.println(hashmap);

        Set keySet = hashmap.keySet();
        for (Object key : keySet) {
            hashmap.put(key , (Integer)hashmap.get(key) + 100); //得到的是一个Object类型数据，需要进行向下转型
        }
        System.out.println(hashmap);

        //EntrySet遍历
        Set entrySet = hashmap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry )iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
