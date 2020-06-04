package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		String uploadPath = "C:" + File.separator + "upload";
		// 보통은 WebContent안에 만든다... 원래는 이런식으로...
		// String uploadPath = request.getServletContext().getRealPath("img");
		
		// uploadPath + fileName 
		String filePath = uploadPath + File.separator +fileName;
		
		File f = new File(filePath);
		// 파일경로 알았으니 

		// 스트림 만들어준다...
		// 다 받을수있는 바이트 스트림으로...
		
		InputStream in = null;
		
		try {
			in = new FileInputStream(f);
			
			
			// 다운로드를 하기위한 환경설정...
			String sMimeType = getServletContext().getMimeType(filePath);
			
			if (sMimeType == null) {
				sMimeType = "application/octet-stream"; 
				// 어떤 타입인지 알수없을때 이렇게 지정해준다.
			}
			
			response.setContentType(sMimeType);		//text인지 img 인지 모르기때문에....
			
			// 브라우져에서는 utf-8 이 아니고 8859_1때문에....
			String encoding = new String(fileName.getBytes("utf-8"), "8859_1" );	// 원래 utf-8인데...8859_1로 바꿔준다...
			
			
			// Key="Content-Disposition"   value ="attachmemt;filename="
			response.setHeader("Content-Disposition", "attachmemt;filename="+encoding);
			
			// 이미 가지고있는것을 가져다 쓰는것...FileOutputStream 과 비슷...
			ServletOutputStream out = response.getOutputStream();	// outputStream 객체를 넘겨준다...
			// 가져다 쓰는것이기 때문에 닫아주면 안된다...

			// 스트림2개 형성 완료
			
			byte[] arr = new byte[1024];
			
			int leng = -1;
			
			while (true) {
				leng = in.read(arr, 0, arr.length);	// 마지막에 가져오는 배열의 개수를 알아야한다...
				if (leng == -1) {
					break;
				}
				// 다 가져왔으면...
				out.write(arr, 0, leng);
			}
			out.flush();
			
		// 출력할수있는 다른 스트림을 만들어야한다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
