package design.observer;

public class ObservableMap<T, U> extends AbstractObservableWithUpStream<T, U> {

    final private Function<T, U> function;

    protected ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        //核心逻辑
        source.subscribeObserver(new MapObserver<>(observer,function));
    }

    final static class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        private final Function<T, U> mapper;

        protected MapObserver(Observer<U> actual, Function<T, U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onNext(T t) {
            //处理过程留给调用者
            U apply = mapper.apply(t);//收到上游来的数据
            actual.onNext(apply);//数据发送到下游
        }
    }

}
