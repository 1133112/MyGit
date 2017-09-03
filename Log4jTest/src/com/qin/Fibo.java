package com.qin;

public class Fibo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(fibonacci(7));
		System.out.println("第一个参数是："+args[0]);
		System.out.println("第二个参数是："+args[1]);
		System.out.println("第三个参数是："+args[2]);

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
