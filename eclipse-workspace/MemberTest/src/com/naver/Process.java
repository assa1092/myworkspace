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
		
		boolean isTrue = true;	// �ݺ����� ����ϱ� ���� ����.
		int menu = -1;	// �޴���ȣ.
		
		Scanner sc = new Scanner(System.in);	// sc.close(); �� ��Ʈ...
		
		while(isTrue) {
			System.out.println("�޴��� �����Ͻÿ�.");
			System.out.println("0: �Է�, 1: ��ȸ, 2: ����, 3: ����, 4: ����");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			// �޴��� 0, 1,2,3,4 �� ��� 
			if(menu < command.length) {
				// �Էµ� ��ȣ�� �°� execute()�޼ҵ� ȣ��
				// �̰� �ϴϸ� if�� switch�� �ϳ��� ������־����...
				command[menu].execute(sc);
				
			}else {	//�޴��� 0, 1,2,3,4 �ƴ� ��� 
				isTrue = false;
			}
			
		}
				
		
		System.out.println("�ý��� ����");
		sc.close();
	}
}
