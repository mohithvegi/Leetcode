// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3697/

class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        int localInv = 0;
        int pre = A[0];
        for (int i = 1; i < A.length; i++) {
            if (pre > A[i]) {
                localInv++;
            }
            pre = A[i];
        }
        int globalInv = mergeSort(A, 0, A.length - 1);
        return globalInv == localInv;
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int index = 0, count = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                helper[index++] = nums[p1++];
            } else {
                count += mid - p1 + 1;
                helper[index++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            helper[index++] = nums[p1++];
        }
        while (p2 <= right) {
            helper[index++] = nums[p2++];
        }
        System.arraycopy(helper, 0, nums, left, helper.length);

        return count;
    }
}
