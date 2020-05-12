package com.naver;

import java.util.ArrayList;
import java.util.List;

import kr.co.ca.Apple;
import kr.co.ca.Pear;

public class Test1 {
	// me1()java.util.List로 만들어진
	// list라는 변수명을 갖고 있다.
	// 단, 이 list에는 3, 4, 5, ... 등의 정수를 저장할수있다.
	
	public void me1() {
		List<Integer> list = new ArrayList<Integer>();		
	}
	
	// me2()메서드는 List로 만들어진 list2라는 변수를 갖고있다.
	// 단, 이 list에는 Apple 객체만 넣을수 있다.
	public void me2() {
		List<Apple> list2 =  new ArrayList<Apple>();
		
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 3500));
		list2.add(new Apple("사과3", 2000));
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 1000));
		
		for (int i=0; i< list2.size();i++) {
			Apple a= list2.get(i);
			System.out.print(a.getName());
			System.out.println(a.getPrice());
		}
		
		// 값을 줄여가면서 하는 for문 
		// 나중에 remove할때 필요하다.
		for(int i= list2.size()-1; i>=0;i--) {
			Apple aa=list2.get(i);
			System.out.println(aa.getName());
			System.out.println(aa.getPrice());
		}
	}
	
	// me3()메서드는 외부로부터 List의 객체 list3를 넘겨받아 
	// 그대로 반환해 주는 기능을 갖고있다.
	public List<String> me3( List<String> list3) {
		list3.add("hello");
		list3.add("world");
		list3.add("good");
		list3.add("morning");
		list3.add("!!!!");
		
		for(int i=0; i <list3.size();i++) {
			String str = list3.get(i);
			System.out.println(str);
		}
		
		return list3;
	}
	
	// list4객체에 1,1, 2, 3,5, 8, 11을 입력하는 기능을 갖고있다.
	public void me4() {
		// 데이터 입력하는것...
		List<Integer> list4 =  new ArrayList<Integer>();
		list4.add(new Integer(1));	// 원래 이렇게 했었음.
		list4.add(1);
		list4.add(1);
		list4.add(3);
		list4.add(5);
		list4.add(8);
		list4.add(11);
		
		for(int i=0; i<list4.size();i++) {
			System.out.println(list4.get(i));
		}
	}
	
	// list5 객체에 객체값 입력할때...
	// 기본 자료형일 경우는 바로 값을 입력하고
	// 참조 자료형일 경우는 객체를 먼저 생성하고..
	// 여러가지 방법으로 값을 입력...
	public void me5() {
		List<Apple> list5 = new ArrayList<Apple>();
		
		// Apple객체를 만들어서 값을 입력...
		Apple a1 =  new Apple("부사", 2000);
		Apple a2 =  new Apple("부사", 2500);
		Apple a3 =  new Apple("알사과", 1000);
		
		list5.add(a1);
		list5.add(a2);
		list5.add(a3);
		list5.add(new Apple("부사", 3000));	// Apple 객체만들면서 바로 입력..
		list5.add(new Apple("홍옥", 1000));	// 보통 이렇게 사용....	
		
		
		// me5()메서드에 있는 list5에 저장된 요소의 name, price를 모두 출력.
				
		for (int i=0;i<list5.size();i++) {
			Apple app=list5.get(i);
			System.out.print(app.getName());
			System.out.println(app.getPrice());
		}
		
		
	}
	
	public void me6() {
		List<Pear> list6 = new ArrayList<Pear>();
		
		list6.add(new Pear("배1", 3000));
		list6.add(new Pear("배2", 3500));
		list6.add(new Pear("배3", 2000));
		list6.add(new Pear("배1", 3000));
		list6.add(new Pear("배2", 1000));
		
		
		Pear p2 = list6.get(2);
		System.out.println(p2.getName());
		System.out.println(p2.getPrice());
		
		// 입력된 값 불러오기...
		int lenlist =list6.size();
		// length()처럼 ArrayList의 길이를 알수있다.
		for (int i=0; i<lenlist; i++) {
			p2 = list6.get(i);
			System.out.print(p2.getName());
			System.out.println(p2.getPrice());
		}
		
	}
	
	
	public void me7() {
		List<Integer> list7 = new ArrayList<Integer>();
		
		System.out.println("============me7()==============");
		for(int i=0; i<10;i++) {
			list7.add(i*2);
		}
		list7.set(0, 1);
		
		for(int i = list7.size()-1; i>=0;i--) {
			System.out.println(list7.get(i));
		}
	}
	
	public void me8() {
		List<Apple> list8 =  new ArrayList<Apple>();
		System.out.println("============me8()==============");
		
		list8.add(new Apple("부사", 1000));
		list8.add(new Apple("부사", 2000));
		list8.add(new Apple("홍옥", 3000));
		list8.add(new Apple("부사", 1000)); 
		
		int idx = list8.indexOf(new Apple("홍옥", 500));
		System.out.println(idx); 	// 없으면 -1
		
		idx=list8.indexOf(new Apple("부사", 1000));
		System.out.println(idx);	// 중복되면 첫번째것 
		//list8.lastIndexOf();		// 젤 마지막에것...
		
	}
	
	public void me9() {
		List<Long> list9 =  new ArrayList<Long>();
		System.out.println("============me9()==============");
		
		list9.add(1L);
		list9.add(34L);
		list9.add(1L);
		list9.add(44L);
		
		for (int i=0; i<list9.size();i++) {
			long L = list9.get(i);
			System.out.println(L);
		}
		
		boolean b = list9.contains(34L);
		// 리스트중에 34L 을 포함하고있으면 true
		// 없으면 false
		System.out.println(b);			 
		
	}
	
	
	
	public void me10() {
		System.out.println("============me10()==============");
		List<Integer> list10 =  new ArrayList<Integer>();
		
		for (int i=0; i<5;i++) {
			list10.add(i*21);
		}
		
		for (int i = list10.size()-1 ; i >=0 ; i--) {
			System.out.println(list10.get(i));
		}
		System.out.println(list10);		// [0, 21, 42, 63, 84]
		list10.remove(1);				// 지워지고 나면 빈칸없이 채워짐
		System.out.println(list10);		// [0, 42, 63, 84]
		list10.remove(3);				// 지워지고 나면 한칸씩 땡겨짐.
		System.out.println(list10);		// [0, 42, 63]
		// 그래서 ArrayList를 이용해서는 수정, 삭제를 하지 않는다..
		// 이럴땐 링크드 리스트를 사용한다.(for문으로 i--로 써야 효율적이다.)
		// 그래서 이런경우는 거꾸로 뒤에껏부터 먼저 지운다... 21 과 63을 지우고 싶으면
		// list10.remove(3);
		//list10.remove(1);
	}
	
	public void me11() {
		System.out.println("============me11()==============");
		List<Integer> list11 =  new ArrayList<Integer>();
		for (int i=0; i <10; i++) {
			list11.add(i);
		}
		System.out.println(list11);
		list11.clear();		// ArrayList 초기화해준다..
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
