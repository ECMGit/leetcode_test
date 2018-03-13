package findMedianSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_findMedianSortedArrays {

    public int lengthOfLongestSubstring(String s) {
        char[] abc = s.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();
        for (int m = 0; m < abc.length; m++) {
            char p = abc[m];
            if (temp.indexOf(p) != -1) {
                int i = temp.indexOf(p);
                temp.subList(0, i).clear();
                temp.add(p);
            } else {
                temp.add(p);
            }
        }
        return temp.size();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            temp[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            temp[nums1.length + i] = nums2[i];
        }
        int m = temp.length;
        Arrays.sort(temp);
        double median = ((m != 0) && (m % 2 == 0)) ? (float) (temp[m / 2] + temp[temp.length / 2 - 1]) / 2 : temp[m / 2];
        return median;
    }
}
