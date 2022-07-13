package design.observer;

public class Sample {


    public static void main(String[] args) {
        Observable<String> observable = Observable.<String>create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("hello world!");
            }
        });
        observable.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "111";
            }
        });
        observable.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "222";
            }
        });
        observable.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + "333";
            }
        });

        observable.subscribeObserver(new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onSubscribe() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
