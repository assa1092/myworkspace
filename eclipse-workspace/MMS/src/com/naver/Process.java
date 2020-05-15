package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import c.UpdateCommand;
import d.DeleteCommand;
import kr.co.ca.Command;


// transaction 상황... 하나의 사건으로 여러개의 변화가 발행할 때 이럴때 Transaction 상황이라한다.  


public class Process {
	public Process() {
		Command[] command = {new InsertCommand(), new SelectCommand(), new UpdateCommand(),new DeleteCommand()};
		int menu=-1;
		boolean isTrue = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (isTrue) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0. 입력 1. 조회, 2. 수정, 3. 삭제, 4.종료");
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu < command.length) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}	
			
		}
		System.out.println("시스템 종료");
		sc.close();
	}

}
