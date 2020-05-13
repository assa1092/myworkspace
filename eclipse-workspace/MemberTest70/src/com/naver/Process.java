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
		
		Scanner sc=  new Scanner(System.in);
		
		boolean isTrue = true;
		int menu =-1;
		
		while(isTrue) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0.입 1. 조 2. 수 3. 삭. 4.종");
			menu = sc.nextInt();
			sc.nextLine();
			if(menu < command.length ) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		
		System.out.println("시스템 종료");
		sc.close();
	}

}
