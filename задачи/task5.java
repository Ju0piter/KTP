import static java.lang.System.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.*;
import java.util.*;
import java.lang.Long;
import java.util.regex.*;

public class task5
{
	public static void main(String[] args) 
	{
		//System.out.println(sameLetterPattern("qwqqqe", "wewwwq"));
		//System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
		//System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s"));
		//System.out.println(maxPossible(123, 654));
		timeDifference("New York", "December 31, 1970 13:40", "Beijing");


	}
	/* **1.Создайте функцию, которая возвращает true, если две строки имеют один и тот же
	буквенный шаблон, и false в противном случае.** */
	public static boolean sameLetterPattern(String a, String b)
	{
		if(a.length()==b.length())
		{
			String[] arr= a.chars().mapToObj(s->String.valueOf((char) s)).distinct().toArray(String[]::new);
			String[] arr2= b.chars().mapToObj(s->String.valueOf((char) s)).distinct().toArray(String[]::new);
			if(arr.length != arr2.length)
				return false;
			HashMap<String, Integer> code=new HashMap<String, Integer>();
			HashMap<String, Integer> code2=new HashMap<String, Integer>();
			for (int i=0; i<arr.length; i++) 
			{
				code.put(arr[i], i);
				code2.put(arr2[i], i);
			}
			int f=0, s=0;
			for (int i=0; i<a.length(); i++) 
			{
				f=f+ code.get(Character.toString(a.charAt(i)))* (int) Math.pow(10, i);
				s=s+code2.get(Character.toString(b.charAt(i)))* (int) Math.pow(10, i);

			}
			return f==s;
		}
		else
			return false;
	}
	/* *************************************************************************** */

	/* **2.Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и
	радиалами, помеченными по часовой стрелке сверху как A-H** */
	public static String spiderVsFly(String start, String finish)
	{
		return "";
	}
	/* *************************************************************************** */

	/* **3. Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
	числа. Преобразование числа в строку не допускается, поэтому подход является
	рекурсивным** */
	public static int digitsCount(int a)
	{
		int b=0;
		if(a>0)
		{
			a=a/10;
			b=digitsCount(a);
			b=b+1;
		}
		return b;
	}
	/* *************************************************************************** */

	/* **4. В игроки пытаются набрать очки, формируя слова, используя буквы из 6-
	буквенного скремблированного слова. Они выигрывают раунд, если им удается
	успешно расшифровать слово из 6 букв.
	Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
	буквенное слово и возвращает общее количество очков, набранных игроком в
	определенном раунде, используя следующую рубрику:
	3-буквенные слова-это 1 очко
	4-буквенные слова-это 2 очка
	5-буквенные слова-это 3 очка
	6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
	Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
	буквенных расшифрованных слов) считаются 0 очками.** */
	public static int totalPoints(String[] a, String str)
	{
		int rez=0;
		Map<String, Long> clovo=str.chars().mapToObj(s->String.valueOf((char) s)).collect(Collectors.groupingBy(x->x, Collectors.counting()));
		for (String vars : a) 
		{
			Map<String, Long> l=vars.chars().mapToObj(s->String.valueOf((char) s)).collect(Collectors.groupingBy(x->x, Collectors.counting()));
			long col=l.entrySet().stream().filter(x->clovo.containsKey(x.getKey()) && clovo.get(x.getKey())>=x.getValue()).count();
			if(col==vars.length())
			{
				rez=rez+((int) col-2);
				if(col==str.length()) {	rez=rez+50;	}
			}	
		}
		return rez;
	}
	/* *************************************************************************** */

	/* **5. Последовательный прогон-это список соседних последовательных целых чисел.
	Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
	функцию, которая принимает массив чисел и возвращает длину самого длинного
	последовательного запуска.** */
	public static int longestRun(int[] arr) {
        Arrays.sort(arr);
        int max = -1;
        int k=1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]-1){
                k=k+1;}
            else
            {
                k=1;
            }
            if (k>max)
                max=k;
        }
        return max;
    }
	/* *************************************************************************** */

	/* **6. Какой процент вы можете набрать на тесте, который в одиночку снижает средний
	балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
	функцию, которая возвращает ответ. Округлите до ближайшего процента.** */
	 public static int takeDownAverage(String[] arr) {
        int s=0;
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i].substring(0, arr[i].length() - 1);
            s=s+Integer.parseInt(arr[i]);
        }
        s=s/arr.length-5*(arr.length+1);
        return s;
    }
	/* *************************************************************************** */

	/* **7. Учитывая предложение с числами, представляющими расположение слова,
	встроенного в каждое слово, верните отсортированное предложение.** */
	public static String rearrange(String s)
	{
		List<String> rm=new ArrayList<String>();
		Collections.addAll(rm, s.split(" "));
		StringBuilder rez=new StringBuilder();
		for(int i=0; i<s.split(" ").length; i++)
		{
			for (ListIterator<String> j=rm.listIterator(); j.hasNext(); ) 
			{
				String a=j.next();
				if(i==a.chars().mapToObj(x->(char) x).filter(m->Character.isDigit(m)).mapToInt(l->l-'0').findFirst().getAsInt()-1)
				{
					rez.append(a.replaceAll("\\d","")+" ");
					j.remove();
					break;
				}
			}
		}
		return rez.toString();
	}
	/* *************************************************************************** */

	/* *8. Напишите функцию, которая делает первое число как можно больше, меняя его
	цифры на цифры во втором числе.* */
	public static int maxPossible(int a1, int b1) {
        
        List<Integer> mas=new ArrayList<Integer>();
        mas=IntStream.of(b1).mapToObj(x->String.valueOf(x)).map(v->v.chars().mapToObj(z->String.valueOf((char) z))
        	.toArray(String[]::new)).flatMap(q->Arrays.stream(q)).mapToInt(l->Integer.parseInt(l)).mapToObj(u->u)
        .collect(Collectors.toList());
        int[] a=IntStream.of(a1).flatMap(x->String.valueOf(x).chars()).map(z->z-'0').toArray();
        Collections.sort(mas, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
        for (int i=0; i<a.length; i++) 
        {
        	if(a[i]<mas.get(0).intValue())
        	{
        		a[i]=mas.get(0).intValue();
        		mas.remove(0);
        	}     	
        }
        int rez=Arrays.stream(a).reduce(0,(s,b)->s+b);
        return Arrays.stream(a).reduce(0,(s,b)->(s*10)+b);
    }
	/* *************************************************************************** */

	/* *9. В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух
	разных городах. * */
	public static void timeDifference(String contr1, String time, String contr2)
	{
		int day=0, year=0; 
		String mont="";
		Map<String, String> country=new HashMap<String, String>();
		String[] c={"Los Angeles", "New York",
		 "Caracas", "Buenos Aires", "London",
		  "Rome", "Moscow", "Tehran", 
		  "New Delhi", "Beijing", "Canberra"};
		  String[] tim={"-08:00", "-05:00",
		 "-04:30", "-03:00", "0:0",
		  "+01:00", "+03:00", "+03:30", 
		  "+05:30 ", "+08:00", "+10:00"};
		for(int i=0;i<11;i++)
		{
			country.put(c[i], tim[i]);
		}
		Map<String, Integer> mon=new HashMap<String, Integer>();
		String[] m={"January", "February", "March", "April", "May", "June",
		 "July", "August", "September", "October", "November", "December"};
		 for (int i=0; i<m.length; i++) 
		 {
		 	mon.put(m[i], i+1);
		 	//System.out.println(m[i]);
		 }
		 String[] t1=new String[2];
	
		//время
		Pattern sear=Pattern.compile("\\d\\d:\\d\\d");
		Matcher search=sear.matcher(time);
		if(search.find())
		{
			String t=search.group();
			t1=t.split(":");

		}
		//число
		sear=Pattern.compile("\\d\\d|\\d");
		search=sear.matcher(time);
		if(search.find())
		{
			day=Integer.parseInt(search.group());
			//System.out.println(search.group());
		}

		//год
		sear=Pattern.compile("\\d{4}");
		search=sear.matcher(time);
		if(search.find())
		{
			year=Integer.parseInt(search.group());
			//System.out.println(search.group());
		}

		//месяц
		sear=Pattern.compile("[a-zA-Z]+");
		search=sear.matcher(time);
		if(search.find())
		{
			mont=search.group();
			//System.out.println(search.group());
		}
		date alltime=new date(Integer.parseInt(t1[1]), Integer.parseInt(t1[0]), day, mon.get(mont), year);
		String[] t2=new String[2];
		String[] t3=new String[2];
		t2=country.get(contr1).split(":");
		t3=country.get(contr2).split(":");

		alltime.add(Integer.parseInt(t2[1])+Integer.parseInt(t3[1]), Math.abs(Integer.parseInt(t2[0])-Integer.parseInt(t3[0])));
		System.out.println(alltime.getToString());

	}

	public static class date
	{
		private int min;
		private int clock;
		private int year;
		private int day;
		private int month;
		public date(int min, int clock, int day, int month, int year)
		{
			this.min=min;
			this.clock=clock;
			this.year=year;
			this.day=day;
			this.month=month;
		}
		public void add(int min, int clock)
		{
			this.min=this.min+min;
			while(this.min>=60)
			{
				this.min=this.min-60;
				this.clock++;
			}
			this.clock=this.clock+clock;
			while(this.clock>=24)
			{
				this.clock=this.clock-24;
				day++;

			}
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
			{
				if(day>31)
				{
					day=day-31;
					month++;
				}
			}
			else if (month==4 || month==6 || month==11) 
			{
				if(day>30)
				{
					day=day-31;
					month++;
				}
			}
			else if (month==2) 
			{
				if(day>28)
				{
					day=day-31;
					month++;
				}
			}
			if(month>12)
			{
				year++;
				month=1;
			}
			
		}
		public String getToString()
		{
			StringBuilder datatime=new StringBuilder();
			datatime.append(year);
			datatime.append('-');
			datatime.append(month);
			datatime.append('-');
			datatime.append(day);
			datatime.append(' ');
			if(clock<9)
				datatime.append(0);
			datatime.append(clock);
			datatime.append(':');
			if(min<9)
				datatime.append(0);
			datatime.append(min);
			return datatime.toString();

		}

	}

	/* *************************************************************************** */

	/* *10. Новое число-это число, которое не является перестановкой любого меньшего
	числа. 869-это не новое число, потому что это просто перестановка меньших чисел,
	689 и 698. 509-это новое число, потому что оно не может быть образовано
	перестановкой любого меньшего числа (ведущие нули не допускаются).* */
	public static boolean isNew(int  b1) {
        int b=b1;
        int k1=0;
        while (b>0) {
            b = b / 10;
            k1 = k1 + 1;
        }
        int [] arr=new int [k1];
        while (b1>0) {
            arr[k1-1]=b1%10;
            b1 = b1 / 10;
            k1 = k1 - 1;
        }
        for (int i=1; i<arr.length-1;i++)
            if (arr[i]>arr[i+1]&arr[i+1]!=0)
                return false;
        return true;
    }




}