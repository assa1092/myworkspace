package com.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	// set 컬렉션 (주머니)
	// 1. 순서가 없다. -> index 가 없다.
	// 2. 중복이 없다...
	
	// Set 컬렉션... 순서 상관없고 중복제외
	
	public void me1(int a) {
		System.out.println("===========me1()=============");
		Set<Integer> set1 = new HashSet<Integer>();
		
		// add()반환값이 boolean 값이 들어가면 true
		// Set 컬렉션에서 값 입력은 add()
		set1.add(0);
		set1.add(0);
		set1.add(1);
		set1.add(1);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(5);
		
		System.out.println(set1.size());	// 5	중복이 되지 않기때문에
		System.out.println(set1);			// [0, 1, 3, 4, 5]	중복이 되지 않기때문에
		
		// Set 컬렉션... 순서 상관없고 중복제외
		Iterator<Integer> it=set1.iterator();
		while (it.hasNext()) {
			Integer value = it.next();
			System.out.println(value);
			
		}
		
		
		
	}
	public void me2(Pear p) {
		System.out.println("===========me2()=============");
		Set<String > set2 = new HashSet<String>();
		
		// 참조 자료형이므로 동등성비교를 한다.
		set2.add("hello");
		set2.add("world");
		set2.add("hello");
		set2.add(new String ("world"));
		set2.add("good");
		set2.add("morning");
		set2.add(new String ("good"));
		
		
		// 들어가는 순서와 나오는 순서는 다르다...
		System.out.println(set2.size());
		System.out.println(set2);
		
		System.out.println("=======================");
		
		// Set 컬렉션... 순서 상관없고 중복제외
		Iterator<String> it=set2.iterator();
		while (it.hasNext()) {			// 커서 뒤에 데이터가 있는지...hasNext() 없으면 false while문 종료
			String value = it.next();	// 기존에 있던 데이터가 반환...next()
			System.out.println(value);
			
		}
		
		
		// 
		ArrayList<String> list2 =  new ArrayList<String>(set2);
		System.out.println("====================");
		System.out.println(list2);
		System.out.println("====================");
		
	}
	
	public void me3(List<Integer> list) {
		System.out.println("===========me3()=============");
		Set<Apple> set3 = new HashSet<Apple>();
		
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 3500));
		set3.add(new Apple("사과3", 2000));
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 1000));
		
		System.out.println(set3.size());
		System.out.println(set3);
		
		
		System.out.println("=======================");
		
		
		// value 값은 while문 내에서만 사용 가능하므로 밖에서 먼저 선언한다
		ArrayList<Apple> list3 = new ArrayList<Apple>();
		
		// Set 컬렉션... 순서 상관없고 중복제외
		// Set 컬렉션은 인덱스가 없기때문에 하나씩 꺼내온다.
		Iterator<Apple> it =set3.iterator();
		while (it.hasNext()) {				// hasNext() 다음껏이 남아있으면 true 반복
			Apple apple = it.next();		// 데이터가 있으면 그 값 
			System.out.println(apple.getName());
			System.out.println(apple.getPrice());
			
			// list3에 값을 넣어준다.
			// while 문 밖에서 선언한 list3 이기때문에 while 문 밖에서도 쓸수 있다.
			list3.add(apple);	
		}
		
	}
	
	public void me4() {
		
		System.out.println("===========me4()=============");
		HashSet<Integer> set4 = new HashSet<Integer>();
		set4.add(1);
		set4.add(11);
		set4.add(121);
		set4.add(111);
		set4.add(101);
		set4.add(14);
		
		System.out.println(set4);
		
		// Set 컬랙션은 입력되는 인덱스가 따로 없기때문에 값으로 제거
		set4.remove(14);	 
		System.out.println(set4);
		
		set4.clear();
		System.out.println(set4);
		
		
	}
	
	

}
