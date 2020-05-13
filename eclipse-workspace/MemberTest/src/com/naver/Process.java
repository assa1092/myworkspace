package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import c.UpdateCommand;
import d.DeleteCommand;
import kr.co.ca.Command;

public class Process {
	public Process() {
		Command[] command = {new InsertCommand(), new SelectCommand(), new UpdateCommand(), new DeleteCommand()};
		
		boolean isTrue = true;	// 반복문을 사용하기 위한 변수.
		int menu = -1;	// 메뉴번호.
		
		Scanner sc = new Scanner(System.in);	// sc.close(); 와 세트...
		
		while(isTrue) {
			System.out.println("메뉴를 선택하시오.");
			System.out.println("0: 입력, 1: 조회, 2: 수정, 3: 삭제, 4: 종료");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			// 메뉴가 0, 1,2,3,4 인 경우 
			if(menu < command.length) {
				// 입력된 번호에 맞게 execute()메소드 호출
				// 이게 하니면 if나 switch로 하나씩 만들어주어야함...
				command[menu].execute(sc);
				
			}else {	//메뉴가 0, 1,2,3,4 아닌 경우 
				isTrue = false;
			}
			
		}
				
		
		System.out.println("시스템 종료");
		sc.close();
	}
}
