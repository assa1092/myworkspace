package kr.co.ca;

// <T>를 넣어 제네릭 타입으로 만들어줌.
public class GTest<T> {
	// 자료형 T 변수명 name
	private T name;
	public GTest() {
		// TODO Auto-generated constructor stub
	}
	public GTest(T name) {
		super();
		this.name = name;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	
	
}
