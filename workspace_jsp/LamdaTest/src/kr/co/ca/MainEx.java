package kr.co.ca;

import com.naver.Cat;
import com.naver.CatImpl;
import com.naver.Dog;
import com.naver.Turtle;
import com.naver.TurtleImpl;

public class MainEx {

	public static void main(String[] args) {
		
		Turtle t = (String str, int a)->{
			System.out.println("Turtle lambda : " + str + a);
			for(int i=0;i<a;i++) {
				System.out.println(str);
			}
		};
		t.me3("꼬북이", 4);
		
		
		Turtle t2 = new TurtleImpl();
		t2.me3("거북이", 5);
		
		
		Turtle t1 = new Turtle() {
			@Override
			public void me3(String str, int c) {
				System.out.println("Turtle :" + str + c);
				
			}
		};
		
		t1.me3("거북이", 10);
		
		
		
		System.out.println(":::::::::::::::::::::::::::::::::::");
		//람다식
		Cat c = (int a) -> {
			// Cat 객체가 가지고있는 me2()메서드에서 할일을 적는다.
			System.out.println("Cat lambda : " +a);
		};
		c.me2(3);
		
		Cat c2 = new CatImpl();
		c2.me2(5);
		
		
		Cat c1 = new Cat() {
			
			@Override
			public void me2(int a) {
				System.out.println("Cat");
				
			}
		};
		c1.me2(10);
		
		
		System.out.println("::::::::::::::::::::::::::::::::");
		
		
		// 람다식
		Dog d = () -> {
			System.out.println("Dog 인터페이스의 me1()메서드의 오버라이딩");
		};
		d.me1();
		
		
		
		// override 해서... 
		Dog d1 = new Dog() {
			
			public void me1() {
				System.out.println("d1");
				
			}
		};
		d1.me1();
		
		
		// 내부 클래스 사용해서 객체 만들기...
		class DogImpl implements Dog{

			public void me1() {
				System.out.println("DogImpl");
				
			}
			
		}
		
		Dog d2 = new DogImpl();
		d2.me1();

	}

}
