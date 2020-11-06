package ru.geekbrains.lesson_5;

import java.util.Arrays;

public class ThreadsTest{
    private static final int size = 100000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];

    public void fillArray (){
        long a = System.currentTimeMillis();
        Arrays.fill(arr, 1f);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
        System.out.println("Method 1 total time: " + (System.currentTimeMillis() - a) + " ms");
    }

    public void fillArrayByTwoThreads () throws InterruptedException {
        long a = System.currentTimeMillis();
        long b;
        System.out.println("Method 2 started!");
        Arrays.fill(arr, 1f);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, 0, a2, 0, h);
        System.out.println("Time to split array: " + (System.currentTimeMillis() - b) + " ms");
        Thread t1 = new Thread(new Threads(a1));
        Thread t2 = new Thread(new Threads(a2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        b = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Time to join array: " + (System.currentTimeMillis() - b) + " ms");
        System.out.println("Method 2 total time: " + (System.currentTimeMillis() - a) + " ms");
    }
}
