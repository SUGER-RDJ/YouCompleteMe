package ArrayList;

import java.util.ArrayList;

public class NewsSport {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新闻1","内容1"));
        arrayList.add(new News("新闻2","内容2"));

        int size = arrayList.size();
        for (int i = 0;i < size;i++){
            System.out.println(arrayList.get(i));
        }
    }
}
