package teacheryo.com.naver;

import teacheryo.fruit.Apple;
import teacheryo.fruit.Banana;
import teacheryo.fruit.Fruit;
import teacheryo.fruit.FruitSeller;
import teacheryo.fruit.Pear;
import teacheryo.kr.co.ca.Person;

public class MainEx {
	public static void main(String[] args) {
		
		//int b = 4/0;	// 0으로 나눴으므로 실행중 error	RuntimeException 
		
		//Cat[] a =  new Cat();		
		
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat c3 = new Cat(2300, new String("hello"));
		Cat[] cArr = {c1, c3}; 
		
		
		Person hong = new Person("33", "홍길동",cArr);
		
		
		Cat[] arr = hong.getcArr();
		Cat who = arr[1];
		String name = who.getName();
		System.out.println(name);
		
//		hong.setName("홍길동");
//		hong.setSsn("990115-5487512");
//		
//		hong.setcArr(cArr);
				
		
		
		// hello -> world로 
		// 수 많은 값을 바꿀때 힘들지 않기위해 변수를 잘 활용하면 
		// 유지 보수가 쉽다.
		String str = "hello";
		
		System.out.println("hello");
		System.out.println("hi");
		System.out.println("hello");
		System.out.println("hi");
		System.out.println("good");
		System.out.println("hi");
		System.out.println("hello1");
		System.out.println("hi");
		
		
		
		
		
//		Fruit 클래스를 왜 만들었을까???
		
//		객체를 다형성을 이용해서 생성하려고 함..
//		다형성	===
//		자료형 변수명 = new 생성자();
//		부모자료형  변수명 =  new 자식생성자();
//
//		Animal a = new Dog();
//		Animal b = new Cat();
//		Animal c = new Camel();
//		a, b, c 의 자료형:  Animal
		
		
		Fruit[] fArr = {new Apple(), new Banana(), new Apple(), new Pear()};
		
		
		Fruit a = fArr[0];
		
		FruitSeller jangsu = new FruitSeller(fArr);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
