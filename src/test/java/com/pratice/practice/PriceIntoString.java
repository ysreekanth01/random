package com.pratice.practice;

public class PriceIntoString {

	public static void main(String[] args) {
		String[] str= {"$ 1,254", "$ 2,456", "$ 3,456"};
		
		int copy=Integer.MAX_VALUE;
		
		for(int j=0;j<str.length;j++) {
			String s=str[j];
			String num="";
			for(int i=0;i<s.length();i++) {
				if(Character.isDigit(s.charAt(i))) {
					num=num+s.charAt(i);
				}
			}
			if(copy>Integer.parseInt(num)) {
				copy=Integer.parseInt(num);
			}
		}
System.out.println(copy);
	}

}
