package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import com.naver.Pear;
import com.naver.Test1;

public class MainEx {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.me1(0);
		
		t1.me2(new Pear());
		
		List<Integer> list = new ArrayList<Integer>();
		t1.me3(list);
		
		t1.me4();
		
		
	}

}
