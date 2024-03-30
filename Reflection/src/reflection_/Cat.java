package reflection_;

public class Cat {

    private String name = "招财";
    public int age = 10;
    public void hi(){
        System.out.println("hi" + name);
    }

    public Cat() {//无参构造器
    }

    public Cat(String name){//有参构造器
        this.name = name;
    }
}
