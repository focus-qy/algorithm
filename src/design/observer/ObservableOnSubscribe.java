package design.observer;

/**
 * 用来绑定发射器
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter);
}
