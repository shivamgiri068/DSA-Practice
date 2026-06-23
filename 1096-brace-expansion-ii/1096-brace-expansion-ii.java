import java.util.*;

class Solution {

    private int idx = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> ans = parse(expression);

        List<String> res = new ArrayList<>(ans);

        Collections.sort(res);

        return res;
    }

    private Set<String> parse(String exp) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add("");

        while (idx < exp.length()) {

            char ch = exp.charAt(idx);

            if (Character.isLetter(ch)) {

                Set<String> temp = new HashSet<>();
                temp.add(String.valueOf(ch));

                current = combine(current, temp);

                idx++;
            }

            else if (ch == '{') {

                idx++;

                Set<String> inner = parse(exp);

                current = combine(current, inner);
            }

            else if (ch == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                idx++;
            }

            else if (ch == '}') {

                idx++;

                break;
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> combine(
            Set<String> a,
            Set<String> b) {

        Set<String> res = new HashSet<>();

        for (String s1 : a) {
            for (String s2 : b) {
                res.add(s1 + s2);
            }
        }

        return res;
    }
}