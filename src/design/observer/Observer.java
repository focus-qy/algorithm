package design.observer;

/**
 * 抽象观察者
 */
public interface Observer<T> {
    //接收消息 update()
    void onNext(T t);

    //订阅observable.add(server) onSuccess()
    void onSubscribe();

    //异常
    void onError(Throwable e);

    //接收消息完成
    void onComplete();

}
