package kr.co.ca;

import java.io.File;

public class MainEx {

	public static void main(String[] args) {
		
		// C: 밑에...BBB 폴더라는 의미...
		File f4 = new File("C:"+File.separator+"BBB");
		if( !f4.exists()) {
			f4.mkdir();
		}

		File f5 = new File("C:" , "new.txt");

		// 
		// File f6 = new File("C:"+File.separator+"BBB"+File.separator+"new.txt");
		File f6 = new File(f4,"new.txt"); // 위쪽것과 같은내용...
		
		f5.renameTo(f6);
		
		
		File f3 = new File("C:", "test119.txt");
		File newName = new File("C:", "new.txt");
		f3.renameTo(newName);
		
		
		
		
		File f2 = new File("C:"+ File.separator + "test119.txt");
		
		boolean isDel = f2.delete();
		if (isDel) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		// 확장자까지 있어야 파일이름...없으면 디렉토리
		// File.separator 파일 구분자...(C:\\AAA)
		File f1 = new File("C:"+ File.separator+"AAA");
 		
		// 선택문일때는 가장 빈도수가 많은것을 제일 위쪽에 작성한다...
		if (!f1.exists()) {
			System.out.println("AAA 폴더가 없습니다.");
			f1.mkdir();	// C:\\AAA 를 만드세요...
			
		} else {
			System.out.println("AAA 폴더가 있습니다.");
			f1.delete();
			
		}

	}

}
