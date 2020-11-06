package ru.geekbrains.lesson_5;

public class Threads implements Runnable {
    private float[] arr;

    public Threads(float[] arr) {
        this.arr = arr;
    }

    private float[] fillArray (){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
        System.out.println("Time to fill array by (" + Thread.currentThread().getName() + ") is " + (System.currentTimeMillis() - a) + " ms");
        return arr;
    }

    @Override
    public void run() {
        fillArray();
    }
}
