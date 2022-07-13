package design;

/***
 * https://blog.csdn.net/qq_41863849/article/details/106299726
 * 1、懒汉式
 * 2、饿汉式
 * 3、双重锁
 * 4、枚举
 * 5、私有静态内部类
 */
public abstract class Singleton<T> {

    private volatile T mInstance;

    public Singleton(){}
    protected abstract T create();

    public final T get(){
        if(mInstance == null){
            synchronized (this){
                if(mInstance == null){
                    mInstance = create();
                }
            }
        }
        return mInstance;
    }

    public static void main(String[] args) {
        Singleton<Builder.Person> singleton = new Singleton<Builder.Person>() {
            @Override
            protected Builder.Person create() {
                return new Builder.PersonBuild().build();
            }
        };

       Builder.Person person =  singleton.get();
    }
}
