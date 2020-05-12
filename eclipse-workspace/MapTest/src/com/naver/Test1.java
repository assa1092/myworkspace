package com.naver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {
	// ���� key���� String ���� �ش�.
	// ���� key �� Set �� �������ش�.
	
	public void me1() {
		Map<String, String> map1 =  new HashMap<String, String>();
	}
	
	public void me2() {
		Map<Pear, Apple> map2 = new HashMap<Pear, Apple>();
	}
	
	public void me3() {
		System.out.println("================me3()======================");
		Map<Integer, String> map3 =  new HashMap<Integer, String>();
		
		// Map �÷��ǿ��� ���Է��� put()
		map3.put(1, "hello");
		map3.put(101, "hello");
		map3.put(1, "world");	// key�� 1�ΰ��� ���� hello���� world���� �ٲ������ �ν�. 
		map3.put(2, "!!!!");
		
		// Map �÷��ǿ����� �߰�ȣ�� ������  Set �÷��ǿ����� ���ȣ...
		System.out.println(map3);		// {1=world, 2=!!!!, 101=hello}
		
		// Map �÷����� key���� Set�÷����� �����ϹǷ�
		// map3.keySet() ���� Set�÷������� �޴´�.
		Set<Integer> set =map3.keySet();
	
		// Set�÷��ǿ����� ���� iterator�� �ҷ��´�...
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
		map5.put("�λ�", new Apple("�λ�", 2000));
		map5.put("�뱸", new Apple("ȫ��", 3000));
		map5.put("����", new Apple("�ջ��", 4000));
		map5.put("����", new Apple("�λ�", 1000));
		
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
