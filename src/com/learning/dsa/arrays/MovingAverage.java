package com.learning.dsa.arrays;

class MovingAverage {
    private final double[] window;
    private int size = 0;
    private int counter = 0;

    /*
     * Always invoked with windowSize > 0
     */
    public MovingAverage(final int windowSize) {
        window = new double[windowSize];
    }

    /*
     * Adds a new number to window by appending to the window or if window is full
     * then replacing the oldest number added to the window
     */
    public void add(final double number) {
        if (counter == 4) {
            counter = 0;
        }
        window[counter++] = number;
        size++;
    }

    /*
     * Return the average of the numbers in the window
     */
    public double getAverage() {
        double sum = 0, avg = 0;
        if (size > 4) size = 4;
        for (int i = 0; i < size; i++) {
            sum = sum + window[i];
        }
        return sum / size;
    }

    public static void main(String[] args) {
        final MovingAverage movingAverage = new MovingAverage(4);
        movingAverage.add(1.5d);
        movingAverage.add(2.5d);
        System.out.println(movingAverage.getAverage()); // prints 2.0
        movingAverage.add(3.0d);
        movingAverage.add(5.0d);
        System.out.println(movingAverage.getAverage()); // prints 3.0
        movingAverage.add(5.5d);
        System.out.println(movingAverage.getAverage()); // prints 4.0
        movingAverage.add(6.5d);
        System.out.println(movingAverage.getAverage()); // prints 5.0
        movingAverage.add(7d);
        System.out.println(movingAverage.getAverage()); // prints 6.0
    }
}
