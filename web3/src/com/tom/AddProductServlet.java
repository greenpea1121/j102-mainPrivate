package com.tom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/addProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		Part picPart = request.getPart("pic");
		String fileName = getFileName(picPart);
		String path = "c:"+File.separator+"temp";
		InputStream is = picPart.getInputStream();
		FileOutputStream fos = new FileOutputStream(path+File.separator+fileName);
		int len = is.available();
		if (len>0){
			byte[] buff = new byte[len];
			is.read(buff);
			fos.write(buff);
			fos.flush();
		}
		fos.close();
		
		//		for (Part part : request.getParts()) {
//			System.out.println(part.getName());
//			InputStream is = request.getPart(part.getName()).getInputStream();
//			int i = is.available();
//			byte[] b = new byte[i];
//			is.read(b);
//			String fileName = getFileName(part);
//			FileOutputStream os = new FileOutputStream("c:/temp/"
//					+ fileName);
//			os.write(b);
//			is.close();
//		}
	}

	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
