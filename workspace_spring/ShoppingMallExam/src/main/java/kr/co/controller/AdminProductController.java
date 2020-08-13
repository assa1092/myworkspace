package kr.co.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.CategoryDTO;
import kr.co.domain.ProductDTO;
import kr.co.domain.ProductOptionDTO;
import kr.co.domain.SearchDTO;
import kr.co.service.ProductService;

@Controller
public class AdminProductController {

	@Autowired
	private ProductService productService;
	@RequestMapping(value ="/admin/product/insert", method = RequestMethod.GET)
	public void insert() {
	}
	
	@RequestMapping(value ="/admin/product/insert", method = RequestMethod.POST)
	public String insert(ProductDTO productDto) {
		productService.insert(productDto);
		
		return "redirect:/admin/product/insert";
	}
	
	@RequestMapping(value ="/admin/product/list")
	public void list(Model model) {
		
		List<ProductDTO> productList = productService.productList();
		Calendar today = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		
		model.addAttribute("today", format.format(today.getTime()));
		today.add(Calendar.DATE, -7);
		model.addAttribute("aWeekAgo", format.format(today.getTime()));
		today.add(Calendar.DATE, +7);
		today.add(Calendar.MONTH, -1);
		model.addAttribute("aMonthAgo", format.format(today.getTime()));
		today.add(Calendar.MONTH, -2);
		model.addAttribute("threeMonthsAgo", format.format(today.getTime()));
		model.addAttribute("productList", productList);

	}
	
	
	@ResponseBody
	@RequestMapping(value ="/product_Category", method = RequestMethod.GET)
	public List<CategoryDTO> category() {
		List<CategoryDTO> list = productService.categoryList();

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value ="/product_CategoryN", method = RequestMethod.GET)
	public List<CategoryDTO> category2(CategoryDTO categoryDto) {
		List<CategoryDTO> list = productService.categoryListN(categoryDto);
		return list;
	}
	
	
	@RequestMapping(value ="/admin/product/search", method = RequestMethod.POST)
	public String productSearchList(Model model, SearchDTO searchDTO) {
	
		List<ProductDTO> productList = productService.productSearchList(searchDTO);
		Calendar today = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		
		model.addAttribute("today", format.format(today.getTime()));
		today.add(Calendar.DATE, -7);
		model.addAttribute("aWeekAgo", format.format(today.getTime()));
		today.add(Calendar.DATE, +7);
		today.add(Calendar.MONTH, -1);
		model.addAttribute("aMonthAgo", format.format(today.getTime()));
		today.add(Calendar.MONTH, -2);
		model.addAttribute("threeMonthsAgo", format.format(today.getTime()));
		model.addAttribute("productList", productList);
		return "/admin/product/list";
	}
	
	@RequestMapping(value ="/admin/product/update/{productNo}")
	public String updateUI(Model model, @PathVariable("productNo") int productNo) {
		ProductDTO productDTO = productService.updateUI(productNo);
		model.addAttribute("productDTO",productDTO );
		
		return "/admin/product/update";
	}
	@ResponseBody
	@RequestMapping(value ="/product_Category_list", method = RequestMethod.POST)
	public List<CategoryDTO> CategoryList() {
		List<CategoryDTO> list = productService.categoryList();

		return list;
	}
	
	@RequestMapping(value ="/admin/product/test")
	public void test() {
		//test용 삭제필수
	}
	@ResponseBody
	@RequestMapping(value ="/product_category_list_update", method = RequestMethod.GET)
	public List<CategoryDTO> categoryListUpdate(CategoryDTO categoryDto, ProductDTO productDto) {
		
		List<CategoryDTO> list = productService.categoryListUpdate(categoryDto, productDto);
		return list;
	}
	@RequestMapping(value ="/admin/product/update", method = RequestMethod.POST)
	public String update(ProductDTO productDto) {
		
		productService.update(productDto);
		
		return "redirect:/admin/product/list";
		
	}
	
	@RequestMapping(value = "/admin/product/list_delete", method = RequestMethod.POST)
	public String productListDelete(String[] checkbox_product) {
		if(checkbox_product!=null) {
		productService.deleteList(checkbox_product);
		}
		return "redirect:/admin/product/list";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/product_checked_update", method = RequestMethod.POST)
	public void productListUpdate(@RequestParam Map<String, Object> map ) throws Exception {
		String jsonStr = map.get("checkedArr").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> mlist = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>() {
		});
		
		
		for (Map<String, Object> m : mlist) {
			int productNo = Integer.valueOf((String) m.get("productNo"));
			int sellStatus = Integer.valueOf((String) m.get("sellStatus"));
			int isDelete = Integer.valueOf((String) m.get("isDelete"));
			ProductDTO productDTO = new ProductDTO(productNo, isDelete, sellStatus);	
			productService.updateList(productDTO);
		}
		
	}
}
