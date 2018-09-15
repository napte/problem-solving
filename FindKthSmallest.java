package com.naptex.study;

import java.util.Arrays;

public class FindKthSmallest
{
	public static void main(String[] args)
	{
		FindKthSmallest findKthLargest = new FindKthSmallest();
		int[] nums = new int[] { 2, 7, 5, 4, 3, 9, 1, 11 };
		int k = 7;
		System.out.println(findKthLargest.findKthSmallest(nums, 0, nums.length - 1, k));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public int findKthSmallest(int[] nums, int low, int high, int k)
	{
		if (low == high)
		{
			if (k == 0)
			{
				return nums[low];
			}
			else
			{
				return -1;
			}
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
		pivotIndex = pivotIndex - low;

		if (pivotIndex == k)
		{
			return nums[low + pivotIndex];
		}
		else if (pivotIndex < k)
		{
			return findKthSmallest(nums, low + pivotIndex + 1, high, k - pivotIndex - 1);
		}
		else
		{
			return findKthSmallest(nums, low, low + pivotIndex - 1, k);
		}
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
