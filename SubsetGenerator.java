package com.naptex.study;

import java.util.HashSet;
import java.util.Set;

public class SubsetGenerator
{
	public static void main(String[] args)
	{
		Character[] str = new Character[] { 'a', 'b', 'c', 'd' };
		Set<Character> partialSolution = new HashSet<Character>();

		SubsetGenerator generator = new SubsetGenerator();
		generator.generateSubsets(partialSolution, str, 0, str.length);

		Integer[] ints = new Integer[] { 1, 2, 3, 4, 5 };
		Set<Integer> partialSolutionInt = new HashSet<Integer>();
		generator.generateSubsets(partialSolutionInt, ints, 0, ints.length);
	}

	private <E> void generateSubsets(Set<E> partialSolution, E[] arr, int index, int n)
	{
		System.out.println(partialSolution);

		for (int i = index; i < n; i++)
		{
			Set<E> newPartialSolution = new HashSet<E>(partialSolution);
			newPartialSolution.add(arr[i]);

			generateSubsets(newPartialSolution, arr, i + 1, n);
		}
	}
}
