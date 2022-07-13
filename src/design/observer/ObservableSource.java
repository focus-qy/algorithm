package design.observer;

/**
 * 抽象的被观察者
 */
public interface ObservableSource<T> {
    //add(observer)
    void subscribeObserver(Observer<T> observer);
}
