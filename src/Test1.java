import java.util.Scanner;
/*
*                   volatile关键字
*
*作用: 保持内存的可见性,禁止编译器进行错误的优化
*
* */
public class Test1 {
    public static class Count{
        public volatile int count = 0;
    }


    //一个线程循环读取值 一个线程改值 修改之后可能对于读的线程没生效
    // 此时就需要在对应的变量前面加上volatile关键字

    public static void main(String[] args) {
        Count c = new Count();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while (c.count == 0){

                }
                System.out.println("循环结束了");
            }
        };
        thread1.start();


        Thread thread2 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入一个整数: ");
                c.count = scanner.nextInt();
            }
        };
        thread2.start();
    }
}
