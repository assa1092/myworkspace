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
			System.out.println("�޴��� �����ϼ���.");
			System.out.println("0. �Է�, 1. ��ȸ, 2. ����, 3. ����, 4, ����");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu < command.length) {
				command[menu].execute(sc);
			}else {
				isTrue = false;
			}
		}
		
		
		
		System.out.println("�ý��� ����");
		sc.close();
	}
	
}
