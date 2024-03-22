package BagPack;

public class Father {
    String name = "Rose";
    Father(){  //父类无参构造器
        System.out.println("Test");
    }
    Father(String name){  //父类有参构造器
        this.name = name;
    }
}
