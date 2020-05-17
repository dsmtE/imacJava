@FunctionalInterface
public interface VarArgsRunnable<T, R> {
    R apply(T... args);
}