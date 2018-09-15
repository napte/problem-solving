package com.naptex.study;

import java.util.Arrays;

/**
 * 
 * <pre>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most
 * twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and
 * 3 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * 
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * 
 * Your function should return length = 7, with the first seven elements of nums being modified to
 * 0, 0, 1, 1, 2, 3 and 3 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * </pre>
 * 
 * @author napte
 *
 */
public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = new int[] { 0, 0, 0, 0, 0 };
		System.out.println(removeDuplicates.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	public int removeDuplicates(int[] nums)
	{
		int repeated = 0;

		if (nums.length == 0)
		{
			return 0;
		}

		int current = nums[0];
		boolean repeatedOnce = false;

		for (int i = 1; i < nums.length; i++)
		{
			if (current != nums[i])
			{
				repeatedOnce = false;
			}
			else if (repeatedOnce && current == nums[i])
			{
				int nextIndex = i;
				while (nextIndex < nums.length && current == nums[nextIndex])
				{
					repeated++;
					nextIndex++;
				}

				int diff = nextIndex - i;
				for (int j = nextIndex; j < nums.length; j++)
				{
					swap(nums, j, j - diff);
				}

				repeatedOnce = false;
			}
			else if (current == nums[i])
			{
				repeatedOnce = true;
			}

			if (i == nums.length - repeated)
			{
				break;
			}

			current = nums[i];
		}

		return nums.length - repeated;
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
