package leetcode_longeststring;


import java.io.IOException;
import java.util.HashSet;
import java.util.*;


public class Solution_longestSubstring {


    /**
     * Longest Palindromic Substring
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     */

    /**
     * Approach #1 (Longest Common Substring) [Accepted]
     * Algorithm
     * <p>
     * We could see that the longest common substring method fails
     * when there exists a reversed copy of a non-palindromic substring in some other part of SS.
     * To rectify this, each time we find a longest common substring candidate,
     * we check if the substring’s indices are the same as the reversed substring’s original indices.
     * If it is, then we attempt to update the longest palindrome found so far;
     * if not, we skip this and find the next candidate.
     */
    public String longestPalindrome_1(String s) {
        Set<String> substring_set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuffer buf = new StringBuffer();
            buf.append(s.charAt(i));
            if (i + 1 == s.length() || i == 0) {
                String sub = buf.toString();
                if (!substring_set.contains(sub))
                    substring_set.add(sub);
            }
            for (int j = i + 1; j < s.length(); j++) {
                buf.append(s.charAt(j));
                String sub = buf.toString();
                if (isPalindrome(sub))
                    substring_set.add(sub);
            }
        }
        String reverse = new StringBuffer(s).reverse().toString();
        String longestsubstring = String.valueOf(s.charAt(0));
        Iterator<String> it = substring_set.iterator();
        while (it.hasNext()) {
            if (reverse.contains(it.next()) && it.next().length() > longestsubstring.length())
                longestsubstring = it.next();
        }
        return longestsubstring;
    }

    /**
     * Approach #2 (Brute Force) [Time Limit Exceeded], written by myself;
     * The obvious brute force solution is to pick all possible starting and ending positions for a substring,
     * and verify if it is a palindrome.
     *
     * @param s it is a string
     * @return substring
     */
    public String longestPalindrome_2(String s) {
        int n = s.length();
        String substring = null;
        for (int i = 0; i < n; i++) {
            StringBuffer buf = new StringBuffer();
            buf.append(s.charAt(i));
            for (int j = i + 1; j < n; j++) {
                buf.append(s.charAt(j));
                String sub = buf.toString();
                if (isPalindrome(sub)) {
                    if (substring == null || substring.length() < sub.length())
                        substring = sub;
                }
            }
        }
        return substring;
    }

    public boolean isPalindrome(String sub) {
        char[] substring2 = sub.toCharArray();
        for (int i = 0, j = sub.length() - 1; i <= j; i++, j--) {
            if (substring2[i] != (substring2[j])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach #4 (Expand Around Center) [Accepted]
     * In fact, we could solve it in O(n^2) time using only constant space.
     * We observe that a palindrome mirrors around its center.
     * Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.
     *
     * @param s
     * @return
     */
    public String longestPalindrome_4(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}




