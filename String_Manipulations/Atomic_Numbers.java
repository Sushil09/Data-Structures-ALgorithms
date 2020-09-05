package Questions.String_Manipulations;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Atomic_Numbers {
    public static void main(String[] args) {
        String s = "K4(ON(SO3)2)2";
        System.out.println(extractAtoms(s));
    }

    static String extractAtoms(String s) {
        int N = s.length();
        Stack<TreeMap<String, Integer>> st = new Stack<>();
        for (int i = 0; i < N; ) {
            if (s.charAt(i) == '(') {
                st.push(new TreeMap<>());
                i++;
            } else if (s.charAt(i) == ')') {
                int stratI = ++i;
                while (Character.isDigit(s.charAt(i))) i++;
                int multiplication = Integer.parseInt(s.substring(stratI, i));
                Map<String, Integer> tempMap = st.pop();
                for (String x : tempMap.keySet()) {
//                    tempMap.put(x);
                }
            }
        }
        return "";
    }
}
