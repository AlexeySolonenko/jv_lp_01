package com.jv_lp_01;

/**
 *
 */
public class Utilities {

    /**
     * REturns a char array containing every nth chr. When
     * sourceArray.length < n, returns sourceArray
     *
     * @param sourceArray
     * @param n
     * @return
     */
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    /**
     * Removes pairs of the same character that re next to each other, by
     * by removeing on occurence of the character.
     * "ABBCDEEF" -> "ABCDEF"
     * "ABCDBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they are
     * not removed
     *
     * @param source
     * @return
     */
    public String removePairs(String source) {
        // if length < 2) there won't be anyt pairs
        if (source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length; i++) {
            if (i < (string.length - 1)) {
                if (string[i] != string[i
                        + 1]) {
                    sb.append(string[i]);
                }
            } else {
                sb.append(string[i]);
            }

        }

        return sb.toString();
    }

    /**
     * Perform a conversion basedon some internla business rule
     *
     * @param a
     * @param b
     * @return
     */
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }

        return null;
    }

}
