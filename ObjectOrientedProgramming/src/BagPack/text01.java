package BagPack;

public class text01 {
    //定义一个Person类：姓名，年龄，工作，初始化person对象数组，有三个person对象并按照年龄从大到小排序，使用冒泡
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("jack",30,"javaEE工程师");
        people[1] = new Person("tom",25,"大数据工程师");
        people[2] = new Person("marry",35,"PHP工程师");

        Person temp = null;
        for (int i = 0;i < people.length - 1;i++){
            for (int j = 0;j < people.length - 1 - i;j++){
                if (people[j].getAge() < people[j + 1].getAge()){
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }

        for (int i = 0;i < people.length;i++){
            System.out.println(people[i]); //默认调用对象的toString()
        }


    }
    static class Person{
        private String name;
        private int age;
        private String job;

        public Person(String name, int age, String job) {
            this.name = name;
            this.age = age;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        @Override
        public String toString() {  //toString方法将数字转化为字符串
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", job='" + job + '\'' +
                    '}';
        }
    }
}
