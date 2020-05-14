package com.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	
	// set 컬랙션(주머니)
	// 순서(index)가 없다. 중복이 없다...
	// 그래서 값을 가져올때 하나씩 꺼내오고 그 다음에 값이 있는지 없는지 확인해야한다.
		
	public void me1(int a) {
		System.out.println("=============me1()================");
		Set<Integer> set1 = new HashSet<Integer>();	// Integer - > Wrapper class
		
		set1.add(0);
		set1.add(0);
		set1.add(1);
		set1.add(1);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(5);
		
		System.out.println(set1.size());
		System.out.println(set1);	
		// set1을 하나씩 출력... set 컬랙션은 대괄호[]로 출력 map컬랙션은 중괄호{}
		
		// set컬랙션에는 인덱스가 없기때문에 반복자인 iterator()를 불러서 써야한다.
		Iterator<Integer> it = set1.iterator();
		while (it.hasNext()) {	// set1컬랙션의 반복자를 받은 it에 다음것이 있으면 true
			// 값이 있으면 들어와라. 그리고 그 값을 value로 받는다.
			Integer value = it.next();	
			System.out.println(value);
			
		}
	}
	
	public void me2(Pear p) {
		System.out.println("=============me1()================");
		Set<String> set2 = new HashSet<String>();
		
		// 참조 자료형이므로 동등성비교를 한다.
		set2.add("hello");
		set2.add("world");
		set2.add("hello");
		set2.add(new String ("world"));
		set2.add("good");
		set2.add("morning");
		set2.add(new String ("good"));
		
		System.out.println(set2.size());
		System.out.println(set2);
		System.out.println("-----------------");
		
		// set컬랙션에는 인덱스가 없기때문에 
		// 반복자인 iterator()를 불러서 써야한다.
		Iterator<String> it = set2.iterator();
		while (it.hasNext()) {
			// set1컬랙션의 반복자를 받은 it에 다음것이 있으면 true
			// 값이 있으면 들어와라. 그리고 그 값을 value로 받는다.
			String value = it.next();
			System.out.println(value);			
		}
		
		// 이렇게 넣어도 되지만 me3()에서 사용한 방법이 더 자주 사용된다.
		ArrayList<String> list2 = new ArrayList<String>(set2);
		System.out.println("====================");
		System.out.println(list2);
		System.out.println("====================");
		
	}
	
	public void me3(List<Integer> list) {
		System.out.println("============me3()=============");
		Set<Apple> set3 = new HashSet<Apple>();
		
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 3500));
		set3.add(new Apple("사과3", 2000));
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 1000));
		
		System.out.println(set3.size());
		System.out.println(set3);
		
		System.out.println("========================");
		
		// set컬랙션은 순서가 없기때문에 값을 불러와서 
		// list컬랙션에 넣어주기위해 생성.
		// 반복문 밖에서도 쓰기위해 while문 밖에서 선언
		ArrayList<Apple> list3 = new ArrayList<Apple>();
		
		Iterator<Apple> it = set3.iterator();
		while (it.hasNext()) {
			Apple value = it.next();
			System.out.println(value.getName());
			System.out.println(value.getPrice());
			
			list3.add(value);
			// while문 밖에서도쓰기위해 list컬랙션에 넣는다.
			// 밖에서 선언해 주었고
			
		}		
	}
	
	public void me4() {
		System.out.println("============me4()==============");
		HashSet<Integer> set4 = new HashSet<Integer>();
		
		set4.add(1);
		set4.add(11);
		set4.add(121);
		set4.add(111);
		set4.add(101);
		set4.add(14);
		
		System.out.println(set4);
		
		set4.remove(101);
		System.out.println(set4);
		
		set4.clear();
		System.out.println(set4);
		
	}
	
	
	

}
