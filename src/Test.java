public class Test {

    public static void main(String[] args) {
//        String s = "abc";
//        String s1 =  new String("abc");
//        List<String> list = Arrays.asList(new String[]{});
//        String s2 = list.remove(0);
        System.out.println("-------------");
        test();
    }

    volatile int aa = 6;
    private static void test(){
         int a = 6;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
            }
        }).start();
    }

}
