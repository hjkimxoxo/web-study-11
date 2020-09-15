package web_study_11.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_11.dao.impl.ProductDaoImpl;
import web_study_11.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	private static ProductDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		//con = JdbcUtil.getConnection();
		dao = ProductDaoImpl.getInstance();
		//dao.setCon(con);
	}
	

	@Test
	public void test01SelectProductByAll() {
		System.out.print("selectAll");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test02SelectProductByCode() {
		System.out.print("selectCode");
		//Product p = dao.selectProductByCode(new Product(1));
		Product p = dao.selectProductByCode(1);
		Assert.assertNotNull(p);
		System.out.println(p);
		System.out.println();
	}
	
	@Test
	public void test03InsertProduct() {
		System.out.println("insert");
		Product p = new Product(7, "책이름", 20000, "설명", "사진");
		int res = dao.insertProduct(p);
		Assert.assertEquals(1, res);
		System.out.println("--확인--");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}


	@Test
	public void test04UpdateProduct() {
		System.out.println("update");
		Product p = dao.selectProductByCode(7);
		p.setName("책이름변경");
		p.setPrice(30000);
		p.setDescription("설명변경");
		p.setPicUrl("사진변경");
		int res = dao.updateProduct(p);
		Assert.assertEquals(1, res);
		System.out.println("--확인--");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		
	}
	
	@Test
	public void test05DeleteProduct() {
		System.out.println("delete");
		int code = dao.deleteProduct(7);
		Assert.assertEquals(1, code);
	
		//int res = dao.deleteProduct(p);
		//Assert.assertEquals(1, res);
		System.out.println("--확인--");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}


}
