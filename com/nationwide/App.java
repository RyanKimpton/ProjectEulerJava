package com.nationwide;

public class App {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();

        ProblemOne problemOne = new ProblemOne();
        ProblemTwo problemTwo = new ProblemTwo();
        ProblemThree problemThree = new ProblemThree();
        ProblemFour problemFour = new ProblemFour();
        ProblemFive problemFive = new ProblemFive();
        ProblemSix problemSix = new ProblemSix();
        ProblemSeven problemSeven = new ProblemSeven();
        ProblemEight problemEight = new ProblemEight();
        ProblemNine problemNine = new ProblemNine();
        ProblemTen problemTen = new ProblemTen();
        ProblemEleven problemEleven = new ProblemEleven();
        ProblemTwelve problemTwelve = new ProblemTwelve();
        ProblemThirteen problemThirteen = new ProblemThirteen();
        ProblemFourteen problemFourteen = new ProblemFourteen();
        ProblemFifteen problemFifteen = new ProblemFifteen();




        Thread thread = new Thread(problemOne);
        Thread thread1 = new Thread(problemTwo);
        Thread thread2 = new Thread(problemThree);
        Thread thread3 = new Thread(problemFour);
        Thread thread4 = new Thread(problemFive);
        Thread thread5 = new Thread(problemSix);
        Thread thread6 = new Thread(problemSeven);
        Thread thread7 = new Thread(problemEight);
        Thread thread8 = new Thread(problemNine);
        Thread thread9 = new Thread(problemTen);
        Thread thread10 = new Thread(problemEleven);
        Thread thread11 = new Thread(problemTwelve);
        Thread thread12 = new Thread(problemThirteen);
        Thread thread13 = new Thread(problemFourteen);
        Thread thread14 = new Thread(problemFifteen);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();


        long endTime = System.nanoTime();

        thread.join();
        System.out.println("Problem 1: " + problemOne.getValue());
        thread1.join();
        System.out.println("Problem 2: " + problemTwo.getValue());
        thread2.join();
        System.out.println("Problem 3: " + problemThree.getValue());
        thread3.join();
        System.out.println("Problem 4: " + problemFour.getValue());
        thread4.join();
        System.out.println("Problem 5: " + problemFive.getValue());
        thread5.join();
        System.out.println("Problem 6: " + problemSix.getValue());
        thread6.join();
        System.out.println("Problem 7: " + problemSeven.getValue());
        thread7.join();
        System.out.println("Problem 8: " + problemEight.getValue());
        thread8.join();
        System.out.println("Problem 9: " + problemNine.getValue());
        thread9.join();
        System.out.println("Problem 10: " + problemTen.getValue());
        thread10.join();
        System.out.println("Problem 11: " + problemEleven.getValue());
        thread11.join();
        System.out.println("Problem 12: " + problemTwelve.getValue());
        thread12.join();
        System.out.println("Problem 13: " + problemThirteen.getValue());
        thread13.join();
        System.out.println("Problem 14: " + problemFourteen.getValue());


        double totalTime = (double) (endTime - startTime) / 1000000000;
        System.out.println("Time to run is: " + totalTime + " seconds");
    }
}