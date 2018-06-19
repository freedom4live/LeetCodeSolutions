/*
Given a string, find the length of the longest substring without repeating characters.

        Examples:

        Given "abcabcbb", the answer is "abc", which the length is 3.

        Given "bbbbb", the answer is "b", with the length of 1.

        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        String[] array = s.split("");
        Set<String> foundChars = new HashSet<>();
        int maxSize = 0;

        int starterPoint = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (foundChars.contains(array[i])) {
                if (counter > maxSize) maxSize = counter;
                foundChars.clear();
                counter = 0;
                i = starterPoint++;
            } else {
                foundChars.add(array[i]);
                counter++;
            }
        }

        if (counter > maxSize) return counter;
        return maxSize;
    }
}
