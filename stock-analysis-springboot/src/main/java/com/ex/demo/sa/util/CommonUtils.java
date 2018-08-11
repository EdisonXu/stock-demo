package com.ex.demo.sa.util;

import java.text.DecimalFormat;

/**
 * @author edison
 * On 2018/8/9 10:11
 */
public class CommonUtils {

	private static DecimalFormat format = new DecimalFormat("#.##");

	public static double formatDouble(double input){
		return Double.parseDouble(format.format(input));
	}

	public static void main(String[] args) {
		System.out.println(Math.random()%10);
	}
}
