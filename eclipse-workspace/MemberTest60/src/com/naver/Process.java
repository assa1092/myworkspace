package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import c.UpdateCommand;
import d.DeleteComand;
import kr.co.ca.Command;

public class Process {
	public Process() {
		Command[] command = {new InsertCommand(), new SelectCommand(), new UpdateCommand(), new DeleteComand()};
		
		Scanner sc = new Scanner(System.in);
		
		boolean isTrue = true;
		int menu = -1;
		
		while(isTrue) {
			System.out.println("메뉴선택");
			System.out.println("0.입력, 1.조회, 2.수정, 3, 삭제. 4. 종료");
			menu  = sc.nextInt();
			if (menu< command.length) {
				command[menu].execute(sc);
			}else {
				isTrue = false;
			}
			
		}
		
		
		System.out.println("시스템 종료");
		sc.close();
	}

}
