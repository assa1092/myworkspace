package kr.co.ca;

// <T>�� �־� ���׸� Ÿ������ �������.
public class GTest<T> {
	// �ڷ��� T ������ name
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
