package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int i = 0;
        int j = i + 1;
        int[] result = new int[2];
        while (i < nums.length) {
            if (j == nums.length - 1) {
                if (nums[j - 1] == nums[j]) {
                    return null;
                } else {
                    result[1] = j;
                    break;
                }
            }
            result[0] = i;
            if (result[0] == nums[j]) {
                i++;
                j = i + 1;
            } else {
                if (nums[j] == nums[j + 1]) {
                    i = j + 1;
                    j = i + 1;
                    continue;
                }
            }
            if (j - i + 1 < k) {
                j++;
            } else {
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}