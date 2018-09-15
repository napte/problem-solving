package com.naptex.study;

import java.util.Arrays;

public class NextPermutation
{
	public static void main(String[] args)
	{
		NextPermutation nextPermutation = new NextPermutation();
		int[] nums = new int[] { 2, 2, 7, 5, 4, 3, 2, 2, 1 };
		nextPermutation.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void nextPermutation(int[] nums)
	{
		if (nums.length == 1)
		{
			return;
		}

		if (nums[nums.length - 2] < nums[nums.length - 1])
		{
			swap(nums, nums.length - 2, nums.length - 1);
			return;
		}

		if (isReverseSorted(nums))
		{
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int i = nums.length - 1;
		while (nums[i] <= nums[i - 1])
		{
			i--;
		}

		int done = nums[i - 1];
		int j = nums.length - 1;
		while (j >= i && nums[j] <= done)
		{
			j--;
		}
		swap(nums, i - 1, j);
		reverse(nums, i, nums.length - 1);

	}

	private boolean isReverseSorted(int[] nums)
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			if (nums[i] < nums[i + 1])
			{
				return false;
			}
		}

		return true;
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int start, int end)
	{
		while (start < end)
		{
			swap(nums, start, end);
			start++;
			end--;
		}
	}
}
