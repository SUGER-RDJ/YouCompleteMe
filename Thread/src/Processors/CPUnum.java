package Processors;

public class CPUnum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑可用cpu数量
        int num = runtime.availableProcessors();
        System.out.println("当前电脑cpu数量：" + num);

    }
}
