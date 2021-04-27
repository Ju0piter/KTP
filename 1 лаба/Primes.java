public class Primes
{
	public static void main(String[] args)
	{
			System.out.println("2");
			for(int i=3;i<101;i++)
			if(itsPrime(i)==true)	
		System.out.println(i);
	}
	public static boolean itsPrime(int n)
	{
		for(int i=2;i<n-1;i++)
			if(n%i==0)
				return false;
		return true;
	}
}