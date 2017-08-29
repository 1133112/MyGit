package com.qin;

public class Fibo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(fibonacci(5));

	}
	public static int fibonacci(int n) {
        // write your code here
        if(n==1)
        {
            return 0;
        }else if(n==2)
        {
            return 1;
        }else
        {
           int sum=fibonacci(n-1)+fibonacci(n-2); 
           return sum;
        }
        
    }
}
