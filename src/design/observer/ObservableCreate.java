package design.observer;

public class ObservableCreate<T> extends Observable{

    private ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }


    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe();
        CreateEmitter createEmitter =  new CreateEmitter<>(observer);
        source.subscribe(createEmitter);
    }

    final static class CreateEmitter<T> implements Emitter<T>{

        private final Observer<T> observer;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }

}
