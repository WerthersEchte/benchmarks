package de.fh_kiel;

import java.util.ArrayList;
import java.util.List;

public class StopwatchBenchmark {

    private static final int BENCHMARKRUNS = 25;
    private static final int ARGUMENT = 25;

    public static void main(String[] args) {

        System.out.println("Warmup starts");

        long vTimeStart = System.nanoTime(), vTimeStop, vCounter = 0;
        List<Long> vExcecutionTime = new ArrayList<>(BENCHMARKRUNS);

        do{
            TestCases.fib(ARGUMENT);
            ++vCounter;
            vTimeStop = System.nanoTime();
        }while((vTimeStop - vTimeStart) < 1e10);

        System.out.println("Warmup finished with " + vCounter + " runs.");
        System.out.println("Timing starts");

        for(vCounter = 0; vCounter < BENCHMARKRUNS; ++vCounter) {
            vTimeStart = System.nanoTime();
            // this is the code under test!
            TestCases.fib(ARGUMENT);

            vTimeStop = System.nanoTime();
            System.out.println("Finished run " + vCounter + " of " + BENCHMARKRUNS + ". Time(ns): " + (double)(vTimeStop - vTimeStart));
            vExcecutionTime.add((vTimeStop - vTimeStart));
        }
        System.out.println("Timing finished with " + BENCHMARKRUNS + " runs.");
        final long vAverage = vExcecutionTime.stream().mapToLong(a->a).sum()/BENCHMARKRUNS;
        System.out.println("Benchmark results ( max, average, min, stddev) in ns : \n("
                + vExcecutionTime.stream().mapToLong(a->a).max().getAsLong() + ", "
                + vAverage + ", "
                + vExcecutionTime.stream().mapToLong(a->a).min().getAsLong() + ", "
                + Math.sqrt(vExcecutionTime.stream().mapToDouble(a->Math.pow(a-vAverage,2)).sum()/BENCHMARKRUNS) + ")");

    }

}
