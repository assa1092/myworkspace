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
		
		boolean isTrue = true;
		int menu = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while(isTrue) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0. 입력, 1. 조회, 2. 수정, 3. 삭제, 4, 종료");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu < command.length) {
				command[menu].execute(sc);
			}else {
				isTrue = false;
			}
		}
		
		
		
		System.out.println("시스템 종료");
		sc.close();
	}
	
}
