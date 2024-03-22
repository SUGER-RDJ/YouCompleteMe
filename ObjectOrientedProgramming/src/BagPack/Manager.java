package BagPack;

public class Manager extends Staff{
    //特有属性
    private double bonus;

    //创建manager对象时，奖金金额不确定，因此在构造器中不给bouns，后续通过setget方法获取
    public Manager(String name, int salary, int day, double grade) {
        super(name, salary, day, grade);
    }

    @Override
    public void Printing() {
        System.out.println("经理：" + getName() + "salary:" + bonus + getSalary() * getDay() * getGrade());
        //super.Printing();  经历计算方法不一样，不用super
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
