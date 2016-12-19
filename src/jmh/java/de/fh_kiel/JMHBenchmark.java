package de.fh_kiel;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class JMHBenchmark {

    @Param({"10", "20", "30"})
    int mNumber;

    @Benchmark
    public void benchmarkFibonacci() {
        TestCases.fib(mNumber);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHBenchmark.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(25)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .forks(1)
                .addProfiler(StackProfiler.class)
                .build();

        new Runner(opt).run();
    }

}
