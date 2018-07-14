package removeDuplicates;

public class Solution_reDup {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums.length == 0) {
            return len;
        }
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[len + 1] = temp;
                len++;
            }
        }
        len += 1;
        return len;
    }
}
