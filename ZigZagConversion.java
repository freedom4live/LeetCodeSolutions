/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string s, int numRows);*/

import java.util.*;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] array = s.toCharArray();
        Map<Integer, Map<Integer, String>> result = new HashMap<>();
        int pointerY = 0;
        int pointerX = 0;
        boolean isGoingDown = true;

        for (int i = 0; i < array.length; i++) {
            putIn(result, pointerX, pointerY, String.valueOf(array[i]));
            if (isGoingDown) {
                if (pointerY == numRows - 1) {
                    isGoingDown = false;
                    pointerY--;
                    pointerX++;
                } else {
                    pointerY++;
                }
            } else {
                if (pointerY == 0) {
                    isGoingDown = true;
                    pointerY++;
                } else {
                    pointerY--;
                    pointerX++;
                }
            }
        }

        StringBuilder resultString = new StringBuilder();
        for (int y = 0; y < array.length; y++) {
            Map<Integer, String> xMap = result.get(y);
            if (null == xMap) continue;
            for (int x = 0; x < array.length; x++) {
                String buffResult = xMap.get(x);
                if (null == buffResult) continue;
                resultString.append(buffResult);
            }
        }

        return resultString.toString();
    }

    private static void putIn(Map<Integer, Map<Integer, String>> yMap, int x, int y, String value) {
        Map<Integer, String> xMap = yMap.get(y);
        if (null == xMap) xMap = new HashMap<>();

        xMap.put(x, value);
        yMap.put(y, xMap);
    }

}
