package kr.co.ca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MainEx2 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(5);
		set.add(500);
		set.add(3);
		set.add(11);
		System.out.println("************************");
		
		// 람다식...실무에서 아직 사용안함...
		// set에서 나오는 값을 x에 넣겠다...
		// 외부에서 사용하고자 할때는 List 에 담아서...
		List<Integer> list = new ArrayList<Integer>();
		set.forEach(x->{
			System.out.println(x);
			list.add(x);
		});
		System.out.println(list.get(0));
		
		System.out.println("::::::::::::::::::::::::");
		Iterator<Integer> it = set.iterator();
		List<Integer> list2 = new ArrayList<Integer>();
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
			
		}
		
		
	}
}
