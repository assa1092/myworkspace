package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.File;




/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
			File uploadFolder = new File("C:"+ File.separator +"upload");
			if(!uploadFolder.exists()) {
				uploadFolder.mkdir();
			}
			
			String title="";
			
			
			String fileName ="";	// 파일 중복 방지를 위해 새로운 파일 이름으로 저장된다.
			String orgFileName ="";
			
			// 5개의 파라미터...어디에 ="C:"+ File.separator +"upload", maxPostSize=10*1024*1024(10MB), encoding="utf-8" , 파일중복시 정책 = new DefaultFileRenamePolicy()
			// MultipartRequest는 cos.jar를 다운 받아야 쓸수있다...
			// MultipartRequest multi를 만든 순간 업로드는 끝났음...
			
			MultipartRequest multi = new MultipartRequest(request, 
														"C:"+ File.separator +"upload", 
														10*1024*1024, 
														"utf-8",
														new DefaultFileRenamePolicy());
			// 파일이 들어오면 시스템에서 관리하는  이름으로 다시 저장된다...
			title = multi.getParameter("title");
			fileName = multi.getFilesystemName("file");	// upload.jsp =>첨부파일 name ="file" 같은 이름이 들어오면 이름뒤에 숫자가 붙는다...
			orgFileName = multi.getOriginalFileName("file");	
			
//			System.out.println(title);
//			System.out.println(fileName);
//			System.out.println(orgFileName);
			
			//바인딩...
			request.setAttribute("fileName", fileName);
			request.setAttribute("orgFileName", orgFileName);
			
			// 포워딩...
			request.getRequestDispatcher("check.jsp").forward(request, response);
			
	}

}
