import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private final long n;
    public FactorialTask(long n) {
        this.n = n;
    }
    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L;
        }
        FactorialTask result = new FactorialTask(n-1);
        result.fork();
        return n * result.join();
    }
}
