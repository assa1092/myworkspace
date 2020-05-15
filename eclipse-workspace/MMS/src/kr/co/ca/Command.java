package kr.co.ca;

import java.util.Scanner;

public interface Command {
	public abstract void execute(Scanner sc);// 펑셔널 인터페이스(Functional Interface) :  인터페이스에 하나의 추상메서드만 있는것

}
