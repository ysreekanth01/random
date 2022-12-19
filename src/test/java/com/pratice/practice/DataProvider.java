package com.pratice.practice;

import org.testng.annotations.Test;

public class DataProvider {
	
	@Test(dataProvider="")
	public void test() {

}}

@DataProvider
public void getData() {
	ExecelUtility execelUtility=new ExecelUtility();
	
	
}
