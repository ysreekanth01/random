package com.pratice.practice;

public class StringRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strRev="";
		String str="i am there";
		String[] sp=str.split(" ");
		for(int i=sp.length-1;i>=0;i--) {
			strRev=strRev+sp[i];
		}
		
//		for(int i=0;i<sp.length;i++) {
//		
//
//	
//		System.out.print(sp[i]);
//		}
		System.out.println(strRev);
}}
