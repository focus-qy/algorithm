package design.observer;

public interface Emitter<T> {
    //接收消息 update()
    void onNext(T t);

    //异常
    void onError(Throwable e);

    //接收消息完成
    void onComplete();
}
