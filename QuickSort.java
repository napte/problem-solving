package com.naptex.study;

import java.util.Arrays;

public class QuickSort
{
	public static void main(String[] args)
	{
		QuickSort quickSort = new QuickSort();
		int[] nums = new int[] { 7, 3, 1, 8, 0, 12, 43, 34, 10, 5, 6, 9 };
		quickSort.sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private void sort(int[] nums, int low, int high)
	{
		if (low >= high)
		{
			return;
		}

		int pivot = nums[low];
		int pivotIndex = low;

		for (int i = low + 1; i <= high; i++)
		{
			if (nums[i] < pivot)
			{
				pivotIndex++;
				swap(nums, pivotIndex, i);
			}
		}

		swap(nums, low, pivotIndex);
		sort(nums, low, pivotIndex - 1);
		sort(nums, pivotIndex + 1, high);
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
