package com.nationwide;

public class App {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();

        ProblemOne t1 = new ProblemOne();
        ProblemTwo t2 = new ProblemTwo();
        ProblemThree t3 = new ProblemThree();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        Thread thread2 = new Thread(t3);
//        Thread thread3 = new Thread(new ProblemFour());
//        Thread thread4 = new Thread(new ProblemFive());
//        Thread thread5 = new Thread(new ProblemSix());
//        Thread thread6 = new Thread(new ProblemSeven());
//        Thread thread7 = new Thread(new ProblemEight());
//        Thread thread8 = new Thread(new ProblemNine());
//        Thread thread9 = new Thread(new ProblemTen());
//        Thread thread10 = new Thread(new ProblemEleven());
//        Thread thread11 = new Thread(new ProblemTwelve());
//        Thread thread12 = new Thread(new ProblemThirteen());

        thread.start();
        thread1.start();
        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
//        thread11.start();
//        thread12.start();


        long endTime = System.nanoTime();

        thread.join();
        System.out.println(t1.getValue());
        thread1.join();
        System.out.println(t2.getValue());
        thread2.join();
        System.out.println(t3.getValue());
        double totalTime = (double) (endTime - startTime) / 1000000000;
        System.out.println("Time to run is: " + totalTime + " seconds");
    }
}
