class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> union = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            if (s.charAt(i) == ',') {
                union.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            }

            else if (s.charAt(i) == '{') {
                i++; // skip {

                Set<String> next = parse(s);

                i++; // skip }

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : next) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }

            else {
                char ch = s.charAt(i);
                i++;

                Set<String> temp = new HashSet<>();

                for (String str : current) {
                    temp.add(str + ch);
                }

                current = temp;
            }
        }

        union.addAll(current);
        return union;
    }
}