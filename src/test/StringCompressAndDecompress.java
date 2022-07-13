package test;

public class StringCompressAndDecompress {
    public static String compress(String s) {
        if (s == null) return null;
        int len = s.length();
        if (len == 0) return s;
        int count = 1;
        char c = s.charAt(0);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < len; ++i) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                result.append(c);
                result.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        result.append(c);
        result.append(count);
        return result.length() >= len ? s : result.toString();
    }


    public static String decompress(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        StringBuilder result = new StringBuilder();

        char c = s.charAt(0);
        result.append(c);
        for (int i = 1; i < len; i++) {
            int count = 0;
            if (i % 2 == 0) {
                c = s.charAt(i);
                result.append(c);
            } else {
                char num = s.charAt(i);
                if(num > '1' && num <= '9'){
                    count =  Integer.parseInt(String.valueOf(num));
                    for (int j = 0; j < count - 1; j++) {
                        result.append(c);
                    }
                }else{
                    return s;
                }

            }
        }


        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aabbbccc";
        String result = compress(s);
        System.out.println("compress result："+result);
        System.out.println("decompress result："+decompress(result));
    }
}
