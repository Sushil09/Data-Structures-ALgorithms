package Questions.DP_15;

import java.util.HashMap;
import java.util.Map;

public class ScrambleStrings {
    static Map<String, Boolean> cache;

    public static void main(String[] args) {
        cache = new HashMap<>();
        String s1 = "coder";
        String s2 = "ocder";
        System.out.println(isScramble(s1, s2));
    }

    static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() <= 1) return false;
        String cacheKey = s1 + " " + s2;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        boolean flag = false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                flag = true;
                break;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i, n))
                    && isScramble(s1.substring(i, n), s2.substring(0, n - i))) {
                flag = true;
                break;
            }
        }
        cache.put(cacheKey, flag);
        return flag;
    }
}
