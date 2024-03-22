package JUnit;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public T get(String id){ //获取id相应对象
        return map.get(id);
    }

    public void update(String id,T entity){  //替换map中的key为id内容，改为entity对象
        map.put(id, entity);
    }

    public List<T> list(){  //返回map中存放的所有T对象
        //遍历map的[key-value]将所有的value（entity）封装到ArrayList返回
        ArrayList<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String  key : keySet) {
            list.add(get(key));
        }
        return list;
    }

    public void delete(String id){  //删除指定的id对象
        map.remove(id);
    }

    public void save(String id,T entity){  //保存
        map.put(id ,entity);
    }
}
