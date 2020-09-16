package web_study_11.model;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import web_study_11.dto.Product;
import web_study_11.service.ProductService;


@WebServlet("/productUpdate.do")
public class ProductUpdateHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new ProductService();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) { 
            System.out.println("GET");     
            int code = Integer.parseInt(request.getParameter("code"));
    		Product product = service.selectProductByCode(code);
    		request.setAttribute("product", product);
    		request.getRequestDispatcher("productUpdate.jsp").forward(request, response);
		}else {
			 System.out.println("POST"); //가져와서 수정
			request.setCharacterEncoding("UTF-8");
			
			ServletContext context = getServletContext();
			String path = context.getRealPath("upload");
			String encType = "UTF-8";
			int sizeLimit = 20*1024*1024;
			
			MultipartRequest multi = new MultipartRequest(request, 
					path,
					sizeLimit, 
					encType, 
					new DefaultFileRenamePolicy());
			
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String description = multi.getParameter("description");
			String pictureUrl = multi.getFilesystemName("pictureUrl");
			if(pictureUrl == null) {
				pictureUrl = multi.getParameter("nonmakeImg");
			}
			
			
			Product p = new Product();
			p.setCode(code);
			p.setName(name);
			p.setPrice(price);
			p.setDescription(description);
			p.setPicUrl(pictureUrl);
	
			int res = service.updateProduct(p);
			System.out.println(res);
			
			response.sendRedirect("productList.do");
		}
		
	}


}
