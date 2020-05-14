package com.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	
	// set �÷���(�ָӴ�)
	// ����(index)�� ����. �ߺ��� ����...
	// �׷��� ���� �����ö� �ϳ��� �������� �� ������ ���� �ִ��� ������ Ȯ���ؾ��Ѵ�.
		
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
		// set1�� �ϳ��� ���... set �÷����� ���ȣ[]�� ��� map�÷����� �߰�ȣ{}
		
		// set�÷��ǿ��� �ε����� ���⶧���� �ݺ����� iterator()�� �ҷ��� ����Ѵ�.
		Iterator<Integer> it = set1.iterator();
		while (it.hasNext()) {	// set1�÷����� �ݺ��ڸ� ���� it�� �������� ������ true
			// ���� ������ ���Ͷ�. �׸��� �� ���� value�� �޴´�.
			Integer value = it.next();	
			System.out.println(value);
			
		}
	}
	
	public void me2(Pear p) {
		System.out.println("=============me1()================");
		Set<String> set2 = new HashSet<String>();
		
		// ���� �ڷ����̹Ƿ� ����񱳸� �Ѵ�.
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
		
		// set�÷��ǿ��� �ε����� ���⶧���� 
		// �ݺ����� iterator()�� �ҷ��� ����Ѵ�.
		Iterator<String> it = set2.iterator();
		while (it.hasNext()) {
			// set1�÷����� �ݺ��ڸ� ���� it�� �������� ������ true
			// ���� ������ ���Ͷ�. �׸��� �� ���� value�� �޴´�.
			String value = it.next();
			System.out.println(value);			
		}
		
		// �̷��� �־ ������ me3()���� ����� ����� �� ���� ���ȴ�.
		ArrayList<String> list2 = new ArrayList<String>(set2);
		System.out.println("====================");
		System.out.println(list2);
		System.out.println("====================");
		
	}
	
	public void me3(List<Integer> list) {
		System.out.println("============me3()=============");
		Set<Apple> set3 = new HashSet<Apple>();
		
		set3.add(new Apple("���1", 3000));
		set3.add(new Apple("���2", 3500));
		set3.add(new Apple("���3", 2000));
		set3.add(new Apple("���1", 3000));
		set3.add(new Apple("���2", 1000));
		
		System.out.println(set3.size());
		System.out.println(set3);
		
		System.out.println("========================");
		
		// set�÷����� ������ ���⶧���� ���� �ҷ��ͼ� 
		// list�÷��ǿ� �־��ֱ����� ����.
		// �ݺ��� �ۿ����� �������� while�� �ۿ��� ����
		ArrayList<Apple> list3 = new ArrayList<Apple>();
		
		Iterator<Apple> it = set3.iterator();
		while (it.hasNext()) {
			Apple value = it.next();
			System.out.println(value.getName());
			System.out.println(value.getPrice());
			
			list3.add(value);
			// while�� �ۿ������������� list�÷��ǿ� �ִ´�.
			// �ۿ��� ������ �־���
			
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
