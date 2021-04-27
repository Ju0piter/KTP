public class Palindrome 
{
	public static void main(String[] args) 
 	{
 		for (int i = 0; i < args.length; i++) 
		{
 		String s = args[i];
 			System.out.println(s+isPalindrome(s));
 		}
 		
	}
	public static String reverseString(String s)
	{	
		String a="";
		for(int i=(s.length())-1;i>=0;i--)
			a=a+s.charAt(i);
		return a;
	}
	public static boolean isPalindrome(String s)
	{
		String k=reverseString(s);
		return s.equals(k);
		

	}
}