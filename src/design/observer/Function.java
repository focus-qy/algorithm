package design.observer;

/**
 * Map变换的核心API
 */
public interface Function<T,R> {
    //T 上游来的数据
    //R 传递到下游的数据
    R apply(T t);
}
