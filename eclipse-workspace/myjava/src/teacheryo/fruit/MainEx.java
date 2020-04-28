package teacheryo.fruit;

public class MainEx {
	public static void main(String[] args) {
//		Fruit 클래스를 생성하시오
//		Fruit 클래스를 상속하는 
//		Apple 클래스, Banana클래스, Pear 클래스를 생성하시오
//
//		FruitSeller 클래스를 생성하시오.
//		- 이 과일 장수는 세상에 존재하는 모든 과일을 보유할수 있습니다.
//
//		Fruit 클래스를 왜 만들었을까???
//		객체를 다형성을 이용해서 생성하려고 함..
//		다형성	===
//		자료형 변수명 = new 생성자();
//		부모자료형  변수명 =  new 자식생성자();
//
//		Animal a = new Dog();
//		Animal b = new Cat();
//		Animal c = new Camel();
//
//
//		a, b, c 의 자료형:  Animal
		
		
		Fruit[] fArr = {new Banana(), new Apple(),new Banana(), new Pear() };
		
		Fruit a=fArr[0];
		
		FruitSeller jangsu = new FruitSeller(fArr);
		
		
		
		
		
		
		
		
	}

}
