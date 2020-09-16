package com.xl.study.lc;

public class Lccup2020_1calculate {

	public static void main(String[] args) {
		int ret = calculate("AB");
		System.out.println(ret);
		ret = calculate(null);
		System.out.println(ret);
		ret = calculate("CABC");
		System.out.println(ret);
		ret = calculate("BA");
		System.out.println(ret);
		ret = calculate("");
		System.out.println(ret);
	}
    public static int calculate(String s) {
        int x = 1;
        int y = 0;
        
        if(s == null || s.equals("")){
            return x+y;
        }
        
        int len = s.length();
        for( int i=0; i<len; i++) {
        	char c = s.charAt(i);
        	if( c == 'A') {
        		x = 2*x + y;
        	} else if( c == 'B'){
        		y = 2*y + x;
        	}
        }
        
        return x+y;
    }
}
