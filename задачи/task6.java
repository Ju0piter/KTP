import static java.lang.System.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.*;
import java.util.*;
import java.lang.Long;
public class task6
{
	public static void main(String[] args) 
	{
		//System.out.println(digitsCount(1234));
		//System.out.println("mubashirhassan");
		//System.out.println(nicoCipher("mubashirhassan", "crazy"));
		//System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
		int[][] rez=(sumsUp(new int[]{7,6,5,4,3,2,1}));
		System.out.println(Arrays.deepToString(rez));
		
	}
	



	
	//
	public static String[] collect(String str, int len)
	{
		if (str.length()>len) 
		{
			String[] a=Arrays.copyOf(collect(str.substring(len), len), collect(str.substring(len), len).length+1);
			//String[] rez=new String[a.length+1];
			a[a.length-1]=str.substring(0, len);
			return a;
		}
		else
			return new String[] {};
	}
	//








	public static String nicoCipher(String message, String key)
	{
		key=key.toLowerCase();
		char[] keys=key.toCharArray();
		Arrays.sort(keys);
		int[] intkey=new int[keys.length];
		for (int i=0; i<keys.length; i++) 
		{
			for (int j=0; j<keys.length; j++) 
			{
				if(key.charAt(j)==keys[i])
				{
					intkey[i]=j;
					break;
				}
			}
		}
		StringBuilder messages=new StringBuilder(message);
		while(messages.length()%keys.length !=0)
		{
			messages.append('_');
		}
		StringBuilder rez=new StringBuilder("");
		for (int i=0; i<messages.length(); i=i+keys.length) 
		{
			String a=messages.substring(i, i+(keys.length));
			for(int k=0; k<intkey.length;k++)
			{
				rez.append(a.charAt(intkey[k]));
			}
		}
		return new String(rez);
	}

	//
	public static int[][] sumsUp(int[] arr)
	{
		List<int[]> a=new ArrayList<int[]>();
		for (int i=0; i<arr.length-1; i++) 
		{
			for (int j=i+1; j<arr.length; j++) 
			{
				if (arr[i]+arr[j]==8) 
				{
					int[] a1={arr[i], arr[j]};
					Arrays.sort(a1);
					a.add(a1);				
				}
			}	
		}
		return a.toArray(new int[0][0]);
	}
	//
}