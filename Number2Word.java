package myutils;

public class Number2Word {
	
	public static void main(String args[]) {
		System.out.println(getInWords(258455));		
	}
  
	public static String getInWords(long n) {
		long r=Long.parseLong(new StringBuilder(Long.toString(n)).reverse().toString());
		int count=Long.toString(n).length(), t;
		String[] w= {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred", "Thousand", "Lakh", "Crore"};
		String word="";
		
		while(r>0) {
			int d=(count%2==0)?((count==2)?100:10):((count>4)?100:10);
			t=Integer.parseInt(new StringBuilder(Long.toString(r%d)).reverse().toString());
			if(t!=0) {
				t=(t<10 && d==100 && r%10!=0)?t*10:t;
				word+=(t>20)?w[20+(t-20)/10]+((t%10==0)?"":" "+w[t%10]):w[t];
				word+=(count>2)?((count==3)?" "+w[28]+" ":" "+w[29+(count-4)/2]+" "):"";
			}
			r/=d;
			count=(d==10)?count-1:count-2;
		}
		
		return word.trim();		
	}
}
