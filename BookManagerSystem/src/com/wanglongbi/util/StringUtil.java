package com.haoqianji.util;

public class StringUtil {
	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	public static String chartoString(char[] args){
		String string = "";
		for(int i=0;i<args.length;i++)
			string = string + args[i];
		return string;
	}
	
	public static boolean isNumeric(String str){
		boolean SDR = true;
		for(int i=0; i < str.length(); i++){
			char str2 = str.charAt(i);
			if (!(Character.isDigit(str2)||str2=='.')){
				SDR = false;
			}
		}
		return SDR;
	}
}
