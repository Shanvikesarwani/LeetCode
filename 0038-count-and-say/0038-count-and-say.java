class Solution {
    public String countAndSay(int n) {
        String ans = "1";

        for(int k = 1; k<n; k++){
            StringBuilder next = new StringBuilder();

            int i =0;
            while(i<ans.length()){
                int count = 1;

                while(i+1<ans.length() && ans.charAt(i)==ans.charAt(i+1)){
                    count++;
                    i++;
                }
                next.append(count);
                next.append(ans.charAt(i));
                i++;
            } 
            ans = next.toString();
        }
        return ans;
    }
}