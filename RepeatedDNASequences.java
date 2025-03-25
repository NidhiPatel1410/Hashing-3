// In this problem, generating the substring of length 10 one by one and checking if the set contains substring, adding that 
// substring to result set. 

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Base case
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        // Set for storing all substrings of length 10
        HashSet<String> set = new HashSet<>();
        // Set for storing the resultant substrings
        HashSet<String> result = new HashSet<>();
        // Loop from 0 to tength last char because last substring of length 10 will
        // start from there
        for (int i = 0; i <= s.length() - 10; i++) {
            // Take the substring of length 10 in variable
            String substring = s.substring(i, i + 10);
            // Check if set contains
            if (set.contains(substring)) {
                // Add it to result
                result.add(substring);
            }
            // Add to set anyway because set will not add duplicates by default
            set.add(substring);
        }
        // Return list of result substrings
        return new ArrayList<>(result);
    }
}