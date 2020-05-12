package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import com.naver.Test1;

public class MainEx {
	public static void main(String[] args) {
		// Generic : �ڹ� �÷��� �����ӿ�ũ ����(��ü)�� 
		// �����ִ� ���(��ü)�� �ڷ����� �����ϴ� ����.
		
		// ���׸�(Generic)�� Ŭ���� ���ο��� ����ϴ� �������� Ÿ��(Type)�� 
		// Ŭ������ �ν��Ͻ��� ������ �� �����ϴ� ���� �ǹ�
		List<StringBuffer> list =  new ArrayList<StringBuffer>();
		List<Apple> appleBox =  new ArrayList<Apple>();
		List<Pear> pearBox =  new ArrayList<Pear>();
		
		// Wrapper class�� �̿��ϸ� �⺻�ڷ����� �ڷ������� ���� �ִ�.
		// �⺻ �ڷ����� ù���ڰ� �빮�� -> Wrapper Class
		// �⺻�ڷ� ���� ��ü�� �� �� ������ Wrapper Ŭ������ �̿��ϸ� ��ü ���� ����
		GTest<Long> gt1 =  new GTest<Long>();
		GTest<Boolean> gt2 = new GTest<Boolean>();
		GTest<Byte> gt3 = new GTest<Byte>();
		GTest<Short> gt4 =  new GTest<Short>();
		GTest<Float> gt5 =  new GTest<Float>();
		GTest<Double> gt6 =  new GTest<Double>();
		GTest<Character> gt7 =  new GTest<Character>();
		GTest<Integer> gt8 = new GTest<Integer>();
		
		
		// Wrapper Class�� ���� ����.
		// autoboxing : �ڵ����� ��üȭ.
		// autounboxing : �ڵ����� �⺻ �ڷ���ȭ.
		int a = new Integer(4).intValue();	// ������ �̷��� �ߴ�.
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
		// String�� char�� �ٲ� ������ charAt()�޼ҵ带 ����Ѵ�.
		char d = str2.charAt(0);
		
		// ���ڿ��� �⺻ �ڷ������� ����� �ִ°�.
		// valueOf(): �⺻ Ÿ���� ���� ���ڿ��� ��ȯ�ϴ� ���
		s = Integer.valueOf(str);	// str�� ���� Integer�� ��ȯ...
		
		Test1 t1 = new Test1();
		t1.me6();
		t1.me5();
		t1.me4();
		
		// me3()�޼ҵ尡  �Ķ���ͷ� List<String>�� �ޱ� ������ 
		// ��ü�� �����Ͽ� �Ķ���� ������ �־��־�� �Ѵ�.
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
