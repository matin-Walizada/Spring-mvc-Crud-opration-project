package com.spring.mvc.products.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.products.dao.ProdcutsDao;
import com.spring.mvc.products.dao.UserSerivceDao;
import com.spring.mvc.products.entity.Products;

@Controller
public class SigInController {

	// we need to inject our UserSerivceDao in our SigInController

	// injection of UserSerivceDao
	@Autowired
	private UserSerivceDao userSerivceDao;
// our injection
	@Autowired
	private ProdcutsDao prodcutsDao;

	// take us to sign in page
	@GetMapping({ "/takeMetoSignInPage", "/" })
	public String showSignInPage() {

		return "signInScreen";
	}

	// let us to sign in
	@PostMapping("/signIn")
	public String ShowWecomeScreen(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");

		if (userSerivceDao.checkUserNameAndPassword(username, password)) {
			return "addproductScreen";

		} else {

			req.setAttribute("errorMessage", "username or password is not correct please try again");

			return "signInScreen";

		}
	}
	// save data in database
	@PostMapping("/saveData")
	public String saveProdcusts(HttpServletRequest req) {

		String name = req.getParameter("name");
		String brand = req.getParameter("brand");

		Products theProducts = new Products();
		theProducts.setName(name);
		theProducts.setBrand(brand);

		Timestamp theTimestamp = new Timestamp(new Date().getTime());
		theProducts.setDoe(theTimestamp);

		prodcutsDao.save(theProducts);

		req.setAttribute("successMessage", "your Record saved successfully");

		return "addproductScreen";
	}
	
		// get the data from database
	@GetMapping("/getData")
	public String getAllProduct(HttpServletRequest req, Model model) {

		List<Products> theProcductList = prodcutsDao.getAllProducts();

		if(theProcductList != null) {
			req.setAttribute("noproductmessage", "there is no product in database");

			model.addAttribute("products", theProcductList);
		}

		return "myproductList";
	}

	// delete product
	@GetMapping("/removeProduct")
	public String deleteProduct(HttpServletRequest req, Model model) {
		String pname = req.getParameter("name");
		prodcutsDao.deleteByName(pname);

		List<Products> theProcductList = prodcutsDao.getAllProducts();

		req.setAttribute("deletemessage", "the " + pname + " is deleted ");

		model.addAttribute("products", theProcductList);

		return "myproductList";

	}

  // update the data
	
	// this method show the edit data page
	
	@GetMapping("/updateProduct")
	public String showUpdataPage(@RequestParam int did, Model model) {
		
		Products product = prodcutsDao.findById(did);
		model.addAttribute("upatedProduct", product);
		return "updatePage";
	}
	
	
	
	@PostMapping("/updatePage")
	
	public String updateData(@RequestParam String name, @RequestParam String brand, int did,
			Model model ) {
		
		Products product = new Products();
		product.setName(name);
		product.setBrand(brand);
		product.setId(did);
		
		prodcutsDao.updateProduct(product);
		
		model.addAttribute("upadteMessage", "date is updated");
		
		return "updatePage";
		
		
	}
	
	
	// get photos from database
	
	@GetMapping({"/loadphoto"})
	public void getPhotos(@RequestParam int dbid, HttpServletResponse resp) throws IOException{
		byte[] photo  = prodcutsDao.renderPhoto(dbid);
		resp.setContentType("image/png");
		ServletOutputStream outputStream = resp.getOutputStream();
		if(photo != null) {
			outputStream.write(photo);
			outputStream.flush();
			outputStream.close();
			
		}
		
 		
		
	}
	 

}
