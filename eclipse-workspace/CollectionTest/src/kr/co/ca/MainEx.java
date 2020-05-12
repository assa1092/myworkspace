package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import com.naver.Test1;

public class MainEx {
	public static void main(String[] args) {
		// Generic : 자바 컬렉션 프레임워크 상자(객체)에 
		// 들어갈수있는 요소(객체)의 자료형을 규졍하는 문법.
		
		// 제네릭(Generic)은 클래스 내부에서 사용하는 데이터의 타입(Type)을 
		// 클래스의 인스턴스를 생성할 때 결정하는 것을 의미
		List<StringBuffer> list =  new ArrayList<StringBuffer>();
		List<Apple> appleBox =  new ArrayList<Apple>();
		List<Pear> pearBox =  new ArrayList<Pear>();
		
		// Wrapper class를 이용하면 기본자료형도 자료형으로 쓸수 있다.
		// 기본 자료형의 첫글자가 대문자 -> Wrapper Class
		// 기본자료 형은 객체가 될 수 없지만 Wrapper 클래스를 이용하면 객체 생성 가능
		GTest<Long> gt1 =  new GTest<Long>();
		GTest<Boolean> gt2 = new GTest<Boolean>();
		GTest<Byte> gt3 = new GTest<Byte>();
		GTest<Short> gt4 =  new GTest<Short>();
		GTest<Float> gt5 =  new GTest<Float>();
		GTest<Double> gt6 =  new GTest<Double>();
		GTest<Character> gt7 =  new GTest<Character>();
		GTest<Integer> gt8 = new GTest<Integer>();
		
		
		// Wrapper Class를 통해 가능.
		// autoboxing : 자동으로 객체화.
		// autounboxing : 자동으로 기본 자료형화.
		int a = new Integer(4).intValue();	// 원래는 이렇게 했다.
		int e = new Integer(4);		// autoUnBoxing...
		Integer b=5;				// autoBoxing...
		System.out.println(a);
		
		String str = "55";
		int c = 55;
		
		System.out.println(str);
		System.out.println(c);
		System.out.println(str+c);	// 5555
		
		int s = Integer.parseInt(str);
		System.out.println(s+c);	// 110...
		
		String str2="C";
		// String을 char로 바꿀 때에는 charAt()메소드를 사용한다.
		char d = str2.charAt(0);
		
		// 문자열을 기본 자료형으로 만들어 주는것.
		// valueOf(): 기본 타입의 값을 문자열로 변환하는 기능
		s = Integer.valueOf(str);	// str의 값을 Integer로 변환...
		
		Test1 t1 = new Test1();
		t1.me6();
		t1.me5();
		t1.me4();
		
		// me3()메소드가  파라미터로 List<String>을 받기 때문에 
		// 객체를 생성하여 파라미터 값으로 넣어주어야 한다.
		List<String> list3 = new ArrayList<String>();
		List<String> msg = t1.me3(list3);
		System.out.println(msg);
		
		t1.me2();
		
		t1.me7();
		t1.me8();
		
		t1.me9();
		t1.me10();
		
		t1.me11();
		
		
		
		
		
	}

}
