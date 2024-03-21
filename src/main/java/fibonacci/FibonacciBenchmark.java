package fibonacci;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1, time = 5)
@Measurement(time = 5, iterations = 2)
public class FibonacciBenchmark {

    @Param({"5", "15", "30"})
    private static int n;

    @Benchmark
    public void benchmarkRecursive() {
        Fibonacci.fibonacciRecursive(n);
    }

    @Benchmark
    public void benchmarkIterative() {
        Fibonacci.fibonacciIterative(n);
    }

    @Benchmark
    public void benchmarkStream() {
        Fibonacci.fibonacciStream(n);
    }
    @Benchmark
    public void fibonacciParallelStream() {
        Fibonacci.fibonacciParallelStream(n);
    }

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
            .include(FibonacciBenchmark.class.getSimpleName())
            .result("fibonacci-jmh.json").resultFormat(ResultFormatType.JSON).build();
        new Runner(options).run();
    }
}

