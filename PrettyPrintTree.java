package com.naptex.study;

public class PrettyPrintTree
{
	public static void main(String[] args)
	{
		PrettyPrintTree prettyPrintTree = new PrettyPrintTree();
		int levels = 10;
		prettyPrintTree.print(levels);
	}

	private void print(int levels)
	{
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 0; i < levels; i++)
		{
			int levelCount = (int) Math.pow(2, i);
			int startTabs = ((int) (Math.pow(2, levels - i - 1)));
			addTabs(sb, startTabs);
			for (int j = 0; j < levelCount; j++)
			{
				sb.append(num);

				int gapTabs = ((int) (Math.pow(2, levels - i)));
				addTabs(sb, gapTabs);

				num++;
			}
			sb.append("\n\n");
		}

		System.out.println(sb);
	}

	private void addTabs(StringBuilder sb, int tabsCount)
	{
		for (int t = 0; t < tabsCount; t++)
		{
			sb.append("\t");
		}
	}
}
