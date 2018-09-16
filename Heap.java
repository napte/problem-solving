package com.naptex.study;

import java.util.Arrays;

public class Heap
{
	private final int MAX_SIZE = 100;

	private final int[] heap = new int[MAX_SIZE];
	private int size = 0;

	public void print()
	{
		int[] filledHeap = new int[size];
		System.arraycopy(heap, 0, filledHeap, 0, size);
		System.out.println(Arrays.toString(filledHeap));
	}

	public void add(int num)
	{
		heap[size] = num;

		int index = size;
		int parentIndex = (index - 1) / 2;
		while (parentIndex >= 0 && heap[parentIndex] > heap[index])
		{
			swap(heap, index, parentIndex);
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}

		size++;
	}

	public int delete()
	{
		int returnVal = heap[0];

		int last = heap[size - 1];
		heap[0] = last;

		int index = 0;
		while (index < ((size - 1) / 2))
		{
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;

			if (rightChildIndex < size)
			{
				if (heap[leftChildIndex] < heap[rightChildIndex])
				{
					swap(heap, index, leftChildIndex);
					index = leftChildIndex;
				}
				else
				{
					swap(heap, index, rightChildIndex);
					index = rightChildIndex;
				}
			}
			else if (leftChildIndex < size)
			{
				swap(heap, index, leftChildIndex);
				index = leftChildIndex;
			}
		}

		size--;
		return returnVal;
	}

	private void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
