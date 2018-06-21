/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int leftPointer = 0;
        int rightPointer = 0;
        String result = "";

        while (rightPointer < array.length) {
            int subLeftPointer = leftPointer;
            int subRightPointer = rightPointer;
            Deque<Character> buffer = new LinkedList<>();
            while (subLeftPointer >= 0 && subRightPointer < array.length) {
                if (array[subLeftPointer] == array[subRightPointer]) {
                    if (subLeftPointer == subRightPointer) {
                        buffer.addFirst(array[subLeftPointer]);
                    } else {
                        buffer.addFirst(array[subLeftPointer]);
                        buffer.addLast(array[subRightPointer]);
                    }
                    subLeftPointer--;
                    subRightPointer++;
                } else {
                    break;
                }
            }

            String buffString = buffer.stream().map(Object::toString).collect(Collectors.joining());
            if (result.length() < buffString.length()) result = buffString;
            if (leftPointer == rightPointer) {
                rightPointer++;
            } else {
                leftPointer++;
            }
        }

        return result;
    }

}
