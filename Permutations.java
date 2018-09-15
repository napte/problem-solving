package com.naptex.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Permutations
{
	public static void main(String[] args)
	{
		Permutations permutations = new Permutations();
		permutations.printPermutations("nikhil");
	}

	public void printPermutations(String str)
	{
		printPerm(str.toCharArray(), new char[str.length()], 0);
	}

	private void printPerm(char[] charArray, char[] solutionArr, int i)
	{
		Bag<Character> candidates = getCandidates(charArray, solutionArr, i);
		for (Character c : candidates)
		{
			solutionArr[i] = c;
			printPerm(charArray, solutionArr, i + 1);
		}

		if (i == solutionArr.length - 1)
		{
			System.out.println(Arrays.toString(solutionArr));
		}
	}

	private Bag<Character> getCandidates(char[] charArray, char[] solutionArr, int index)
	{
		Bag<Character> candidates = new Bag<Character>();
		for (int i = 0; i < charArray.length; i++)
		{
			candidates.add(charArray[i]);
		}

		for (int i = 0; i < index; i++)
		{
			candidates.remove(solutionArr[i]);
		}

		return candidates;
	}
}

class Bag<T> implements Iterable<T>
{
	private Map<T, Integer> bag = new HashMap<T, Integer>();

	public void add(T el)
	{
		if (bag.containsKey(el))
		{
			int count = bag.get(el);
			bag.put(el, count + 1);
		}
		else
		{
			bag.put(el, 1);
		}
	}

	public void remove(T el)
	{
		if (bag.containsKey(el))
		{
			int count = bag.get(el);
			if (count > 1)
			{
				bag.put(el, count - 1);
			}
			else
			{
				bag.remove(el);
			}
		}
	}

	public Set<T> getUniqueElements()
	{
		return bag.keySet();
	}

	@Override
	public Iterator<T> iterator()
	{
		return bag.keySet().iterator();
	}
}
