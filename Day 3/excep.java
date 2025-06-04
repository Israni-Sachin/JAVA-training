import java.util.Scanner;

public class excep extends Thread{
//    static void checkAge(int age) {
//        if (age < 18) {
//            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
//        }
//        else {
//            System.out.println("Access granted - You are old enough!");
//        }
//    }
//    public static void main(String[ ] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter age: ");
//        int age=sc.nextInt();
//        checkAge(age);
//        try {
//            int[] myNumbers = {1, 2, 3};
//            System.out.println(myNumbers[10]);
//        } catch (Exception e) {
//            System.out.println("Something went wrong.");
//        }finally {
//            System.out.println("The 'try catch' is finished.");
//        }
//    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                System.out.println("T1: " + i);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                System.out.println("T2: " + i);
        });

        t1.start();
        t2.start();
        excep thread = new excep();
        thread.start();
        System.out.println("This code is outside of the thread");
    }
        public void run() {
            System.out.println("This code is running in a thread");
        }


}