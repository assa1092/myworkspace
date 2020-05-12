package com.naver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {
	// 보통 key값을 String 으로 준다.
	// 보통 key 는 Set 이 관리해준다.
	
	public void me1() {
		Map<String, String> map1 =  new HashMap<String, String>();
	}
	
	public void me2() {
		Map<Pear, Apple> map2 = new HashMap<Pear, Apple>();
	}
	
	public void me3() {
		System.out.println("================me3()======================");
		Map<Integer, String> map3 =  new HashMap<Integer, String>();
		
		// Map 컬랙션에서 값입력은 put()
		map3.put(1, "hello");
		map3.put(101, "hello");
		map3.put(1, "world");	// key가 1인것의 값이 hello에서 world으로 바뀐것으로 인식. 
		map3.put(2, "!!!!");
		
		// Map 컬랙션에서는 중괄호로 보여줌  Set 컬랙션에서는 대괄호...
		System.out.println(map3);		// {1=world, 2=!!!!, 101=hello}
		
		// Map 컬랙션의 key값은 Set컬랙션이 관리하므로
		// map3.keySet() 값은 Set컬랙션으로 받는다.
		Set<Integer> set =map3.keySet();
	
		// Set컬랙션에서는 값을 iterator로 불러온다...
		Iterator<Integer> it = set.iterator();	
		while (it.hasNext()) {
			Integer key = it.next();
			System.out.println(key);
			
		}
		
	}
	
	public void me4() {
		System.out.println("==================me4()====================");
		Map<String, Integer> map4 = new HashMap<String, Integer>();
		
		map4.put("hello", 1);
		map4.put("world", 2);
		map4.put("good", 3);
		map4.put("morning", 4);
		
		int a = map4.get("hello");
		System.out.println(a);
		
		
		Set<String> set = map4.keySet();
		Iterator<String> it= set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			
		}
		
	}
	
	public void me5() {
		System.out.println("=================me5()=====================");
		Map<String, Apple> map5 = new HashMap<String, Apple>();
		map5.put("부산", new Apple("부사", 2000));
		map5.put("대구", new Apple("홍옥", 3000));
		map5.put("대전", new Apple("왕사과", 4000));
		map5.put("서울", new Apple("부사", 1000));
		
		Set<String> set= map5.keySet();
		
		Iterator<String> it =set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Apple value = map5.get(key);
			
			System.out.println(value.getName());
			System.out.println(value.getPrice());
		}
	}
}
