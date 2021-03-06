package kr.co.ca;

import java.util.UUID;

import com.naver.Dog;
import com.naver.Test;


public class MainEx {

	public static void main(String[] args) {
		Dog d1 = new Dog("d001", "happy", "hong");
		Dog d2 = new Dog("d002", "happy", "hong");
		Dog d3 = new Dog("d002","world", "kim");
		
		
		// equals()에서 id가 같으면 같은것으로 재정의 해놓음...
		System.out.println(d1.equals(d2));	// false
		System.out.println(d2.equals(d3));	//true
		
		
		System.out.println("-------------------------");
		
		
		
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		Test t4 = new Test();

		t1.me1();		// false
//		Test t = new Test();
		
		// 반환형이 있는 메소드는 받는 값이 있어야한다.
		boolean b= t2.me2();	
		System.out.println(b);		// true
		 
		t3.me3();			// false
		t4.me4();			// false, true
		t4.me5();			// true, false
		t4.me6();
		t4.me61();
		t4.me62(8);
		//t4.me7();
		char c2 =t4.me8();
		System.out.println(c2);
		
		t4.me81("hello!!!",5);
		t4.me9();
		t4.me10();
		t4.me11();
		t4.me112();
		t4.me12();
		t4.me13();
		t4.me14();
		
		
		
		// 유일무이한 파일명을 만들기위해 임의값을 받음. 
		// 중복을 방지하기 위해 
		UUID uid = UUID.randomUUID();
		String org = "hello.png";
		
		String filename = uid.toString()+ "_"+org;
		System.out.println(filename);
		
		String name = t2.me142(filename);
		System.out.println(name);
		
		t4.me143();
		t4.me15();
		System.out.println();
		t4.me16(53);
		
		System.out.println();
		t4.me17(30, 40);
		
		t4.me00();
		
		
		t4.me18();
		System.out.println();
		t4.me182();
		
		System.out.println();
		t4.me183();
		
		
		
		
		
		
		

	}

}
