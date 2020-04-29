package kr.co.kr;

public class MainExam {
	private static int b=0;
	
	public static void z1(int a) {
		System.out.println(a);
	}
	
	public static void w1(int b) {
		MainExam.b = b;
	}
	
	public static void main(String[] args) {
		int what = -1;
		z1(what);
		w1(8);
	}
}
