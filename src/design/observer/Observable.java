package design.observer;

public abstract class Observable<T> implements ObservableSource{

    @Override
    public void subscribeObserver(Observer observer) {
        //把发消息的行  为预留给调用者
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer observer);

    //创建调用者使用的接口
    public static <T> Observable create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }

    //map操作
    public <U> Observable map(Function<T,U> function){
        return  new ObservableMap(this,function);
    }
}
