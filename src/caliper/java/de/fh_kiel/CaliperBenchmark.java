package de.fh_kiel;

import com.google.caliper.AfterExperiment;
import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.caliper.api.VmOptions;
import com.google.caliper.runner.CaliperMain;

@VmOptions("-XX:-TieredCompilation")
public class CaliperBenchmark {

    CaliperBenchmark() {
    }

    @Param({"10", "20", "30"})
    int mNumbers;

    @BeforeExperiment
    void setUp() throws Exception {
    }

    @Benchmark
    void benchmarkFibonacci() {
        TestCases.fib(mNumbers);
    }

    @AfterExperiment
    void tearDown() throws Exception {
    }

    public static void main(String[] args) {
        args = new String[]{"--time-limit", "0"};
        CaliperMain.main(CaliperBenchmark.class, args);
    }
}
