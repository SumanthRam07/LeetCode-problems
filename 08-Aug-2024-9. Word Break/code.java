package 08-Aug-2024-9. Word Break;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; 
    
        for (int i = 1; i <= s.length(); i++) {
           
            for (int j = 0; j < i; j++) {
                
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
           
                }
            }
        }
        
        return dp[s.length()];
    }
}
