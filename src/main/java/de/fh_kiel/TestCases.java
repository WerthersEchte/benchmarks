package de.fh_kiel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCases {

    public static long fib( int i ){
        if( i == 1 || i == 0){
            return i;
        }
        return fib(i-1) + fib(i-2);
    }

    public static void assholeToBenchmark( int i ){
        try {
            TimeUnit.MILLISECONDS.sleep((int)(Math.random() * i * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
