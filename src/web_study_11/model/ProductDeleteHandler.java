package web_study_11.model;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_11.dto.Product;
import web_study_11.service.ProductService;


@WebServlet("/productDelete.do")
public class ProductDeleteHandler extends HttpServlet {
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
     		Product p = service.selectProductByCode(code);
     		request.setAttribute("product", p);
     		request.getRequestDispatcher("productDelete.jsp").forward(request, response);
     
		}else {
			 System.out.println("POST"); 
			int code = Integer.parseInt(request.getParameter("code"));
				
			int res = service.deleteProduct(code);
			System.out.println(res);
			response.sendRedirect("productList.do");
		}

	}
}
