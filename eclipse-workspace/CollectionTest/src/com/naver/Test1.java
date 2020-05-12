package com.naver;

import java.util.ArrayList;
import java.util.List;

import kr.co.ca.Apple;
import kr.co.ca.Pear;

public class Test1 {
	// me1()java.util.List�� �������
	// list��� �������� ���� �ִ�.
	// ��, �� list���� 3, 4, 5, ... ���� ������ �����Ҽ��ִ�.
	
	public void me1() {
		List<Integer> list = new ArrayList<Integer>();		
	}
	
	// me2()�޼���� List�� ������� list2��� ������ �����ִ�.
	// ��, �� list���� Apple ��ü�� ������ �ִ�.
	public void me2() {
		List<Apple> list2 =  new ArrayList<Apple>();
		
		list2.add(new Apple("���1", 3000));
		list2.add(new Apple("���2", 3500));
		list2.add(new Apple("���3", 2000));
		list2.add(new Apple("���1", 3000));
		list2.add(new Apple("���2", 1000));
		
		for (int i=0; i< list2.size();i++) {
			Apple a= list2.get(i);
			System.out.print(a.getName());
			System.out.println(a.getPrice());
		}
		
		// ���� �ٿ����鼭 �ϴ� for�� 
		// ���߿� remove�Ҷ� �ʿ��ϴ�.
		for(int i= list2.size()-1; i>=0;i--) {
			Apple aa=list2.get(i);
			System.out.println(aa.getName());
			System.out.println(aa.getPrice());
		}
	}
	
	// me3()�޼���� �ܺηκ��� List�� ��ü list3�� �Ѱܹ޾� 
	// �״�� ��ȯ�� �ִ� ����� �����ִ�.
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
	
	// list4��ü�� 1,1, 2, 3,5, 8, 11�� �Է��ϴ� ����� �����ִ�.
	public void me4() {
		// ������ �Է��ϴ°�...
		List<Integer> list4 =  new ArrayList<Integer>();
		list4.add(new Integer(1));	// ���� �̷��� �߾���.
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
	
	// list5 ��ü�� ��ü�� �Է��Ҷ�...
	// �⺻ �ڷ����� ���� �ٷ� ���� �Է��ϰ�
	// ���� �ڷ����� ���� ��ü�� ���� �����ϰ�..
	// �������� ������� ���� �Է�...
	public void me5() {
		List<Apple> list5 = new ArrayList<Apple>();
		
		// Apple��ü�� ���� ���� �Է�...
		Apple a1 =  new Apple("�λ�", 2000);
		Apple a2 =  new Apple("�λ�", 2500);
		Apple a3 =  new Apple("�˻��", 1000);
		
		list5.add(a1);
		list5.add(a2);
		list5.add(a3);
		list5.add(new Apple("�λ�", 3000));	// Apple ��ü����鼭 �ٷ� �Է�..
		list5.add(new Apple("ȫ��", 1000));	// ���� �̷��� ���....	
		
		
		// me5()�޼��忡 �ִ� list5�� ����� ����� name, price�� ��� ���.
				
		for (int i=0;i<list5.size();i++) {
			Apple app=list5.get(i);
			System.out.print(app.getName());
			System.out.println(app.getPrice());
		}
		
		
	}
	
	public void me6() {
		List<Pear> list6 = new ArrayList<Pear>();
		
		list6.add(new Pear("��1", 3000));
		list6.add(new Pear("��2", 3500));
		list6.add(new Pear("��3", 2000));
		list6.add(new Pear("��1", 3000));
		list6.add(new Pear("��2", 1000));
		
		
		Pear p2 = list6.get(2);
		System.out.println(p2.getName());
		System.out.println(p2.getPrice());
		
		// �Էµ� �� �ҷ�����...
		int lenlist =list6.size();
		// length()ó�� ArrayList�� ���̸� �˼��ִ�.
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
		
		list8.add(new Apple("�λ�", 1000));
		list8.add(new Apple("�λ�", 2000));
		list8.add(new Apple("ȫ��", 3000));
		list8.add(new Apple("�λ�", 1000)); 
		
		int idx = list8.indexOf(new Apple("ȫ��", 500));
		System.out.println(idx); 	// ������ -1
		
		idx=list8.indexOf(new Apple("�λ�", 1000));
		System.out.println(idx);	// �ߺ��Ǹ� ù��°�� 
		//list8.lastIndexOf();		// �� ����������...
		
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
		// ����Ʈ�߿� 34L �� �����ϰ������� true
		// ������ false
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
		list10.remove(1);				// �������� ���� ��ĭ���� ä����
		System.out.println(list10);		// [0, 42, 63, 84]
		list10.remove(3);				// �������� ���� ��ĭ�� ������.
		System.out.println(list10);		// [0, 42, 63]
		// �׷��� ArrayList�� �̿��ؼ��� ����, ������ ���� �ʴ´�..
		// �̷��� ��ũ�� ����Ʈ�� ����Ѵ�.(for������ i--�� ��� ȿ�����̴�.)
		// �׷��� �̷����� �Ųٷ� �ڿ������� ���� �����... 21 �� 63�� ����� ������
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
		list11.clear();		// ArrayList �ʱ�ȭ���ش�..
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
