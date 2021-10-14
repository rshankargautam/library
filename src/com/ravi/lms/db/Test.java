package com.ravi.lms.db;

public class Test {

	public Test() {
		
	}
	public static void main(String[] args) {
		DBUtility du = DBUtility.getDBUtilityObject();
		if(du.testCon()) {
			System.out.println("Successful connection");
		}else
			System.out.println("failed connection");
	}

}
