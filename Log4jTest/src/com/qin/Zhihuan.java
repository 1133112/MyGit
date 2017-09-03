package com.qin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Zhihuan
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(Permutation1("abc", "cba"));
		System.out.println(Permutation1("aabc", "bcad")); 

	}

	public static boolean Permutation1(String A, String B)
	{
		// write your code here
		byte[] A_byte = A.getBytes();
		byte[] B_byte = B.getBytes();
		Map<Byte, Integer> map = new HashMap<Byte, Integer>();
		for (byte b : A_byte)
		{
			map.put(b, map.get(b) == null ? 1 : map.get(b) + 1);
		}
		for (byte b : B_byte)
		{
			if (map.get(b) == null)
			{
				return false;
			}
			int num = map.get(b) - 1;
			if (num == 0)
			{
				map.remove(b);
			} else
			{
				map.put(b, num);
			}
		}
		if (map.size() != 0)
		{
			return false;
		}
		return true;

	}

	public boolean stringPermutation(String A, String B)
	{
		// Write your code here
		if (A.length() != B.length())
		{
			return (false);
		}
		byte[] A_byte = A.getBytes();
		byte[] B_byte = B.getBytes();
		sort(A_byte);
		sort(B_byte);
		for (int i = 0; i < A_byte.length; i++)
		{
			if (A_byte[i] != B_byte[i])
			{
				return (false);
			}
		}
		return (true);
	}

	private void sort(byte[] ints)
	{
		for (int i = 0; i < ints.length - 1; i++)
		{
			for (int j = i + 1; j < ints.length; j++)
			{
				if (ints[i] > ints[j])
				{
					transposition(ints, i, j);
				}
			}
		}
	}

	private void transposition(byte[] ints, int i, int j)
	{
		byte s;
		s = ints[i];
		ints[i] = ints[j];
		ints[j] = s;

	}
}
