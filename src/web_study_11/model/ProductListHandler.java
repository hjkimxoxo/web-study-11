package web_study_11.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_11.dto.Product;
import web_study_11.service.ProductService;


@WebServlet("/productList.do")
public class ProductListHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	
	public void init(ServletConfig config) throws ServletException {
		service = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = service.selectProductByAll();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("productList.jsp").forward(request, response);
		
	}

}
