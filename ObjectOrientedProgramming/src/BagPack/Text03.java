package BagPack;

public class Text03 {
    //通过继承实现员工工资核算打印功能
    //父类：员工类，子类：部门经理类，普通员工类
    //部门经理工资=奖金+单日工资*天数*等级（1.2）  普通员工工资=单日工资*天数*等级（1.0）
    //员工属性：姓名，单日工资，工作天数 员工方法：打印工资 子类需重写
    public static void main(String[] args) {
        Manager manager = new Manager("李经理", 200, 20, 1.2);
        manager.setBonus(3000);
        manager.Printing();
    }
}
