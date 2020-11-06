package ru.geekbrains.lesson_5;

public class Main {

    public static void main(String[] args) {
        ThreadsTest t = new ThreadsTest();

        t.fillArray();
        try {
            t.fillArrayByTwoThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
