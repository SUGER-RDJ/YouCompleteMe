package JUnit;

import java.util.List;

/**
 * JUnit单元测试框架：
 * JUnit是一个Java语言单元测试框架
 * 多数Java语言开发环境已经集成了JUnit作为单元测试工具
 * 使用方式： @Test + option + enter(需联网)*/
public class USER {
    public static void main(String[] args) {
        System.out.println("JUnit单元集成测试");
    }
}

class Test{
    //@Test
    public void test (){
        DAO<Users> dao = new DAO<>();
        dao.save("001",new Users(1,10,"jack"));
        dao.save("002",new Users(2,11,"tom"));
        dao.save("003",new Users(3,12,"milan"));

        List<Users> list = dao.list();
        System.out.println(list);

        dao.update("003",new Users(3,38,"smith"));

        list = dao.list();
    }
}