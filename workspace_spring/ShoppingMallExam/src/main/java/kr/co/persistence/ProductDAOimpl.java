package kr.co.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.CategoryDTO;
import kr.co.domain.ProductDTO;
import kr.co.domain.ProductOptionDTO;
import kr.co.domain.SearchDTO;

@Repository
public class ProductDAOimpl implements ProductDAO {

	@Autowired
	private SqlSession session;
	
	private final String NS = "p.r.o";

	@Override
	public void insert(ProductDTO productDto) {
		int productNo = session.selectOne(NS+".getProductNo");
		productDto.setProductNo(productNo);
		session.insert(NS+".insert", productDto);
		 
	}
	
	@Override
	public void addAttach(String fullName, int productNo) {	
		int attachNo = session.selectOne(NS+".getAttachNo");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attachNo", attachNo);
		map.put("fullName", fullName);
		map.put("productNo", productNo);
		session.insert(NS+".addAttach", map);
	}
	@Override
	public List<CategoryDTO> categoryList() {
		return session.selectList(NS+".categoryList");
	}
	
	@Override
	public List<CategoryDTO> categoryListN(CategoryDTO categoryDto) {
		return session.selectList(NS+".categoryList2",categoryDto);
	}
	
	@Override
	public void insertProductOption(ProductOptionDTO productOptionDTO) {
		int productOptionNo = session.selectOne(NS+".getProductOptionNo");
		productOptionDTO.setProductOptionNo(productOptionNo);
		session.insert(NS+".insertProductOption", productOptionDTO);		
	}
	@Override
	public List<ProductDTO> productList() {
			
		return session.selectList(NS+".productList");
	}
	@Override
	public String getCategoryName(int categoryNo) {
	
		return session.selectOne(NS+".getCategoryName", categoryNo);
	}
	@Override
	public ProductDTO updateUI(int productNo) {
	
		 return session.selectOne(NS+".updateUI",productNo);
	}
	@Override
	public List<ProductOptionDTO> productOptionList(int productNo) {
		// TODO Auto-generated method stub
		return session.selectList(NS+".getProductOptionList", productNo);
	}
	
	@Override
	public List<String> getAttach(Integer productNo) {
	
		return session.selectList(NS + ".getAttach", productNo);
	}
	@Override
	public List<CategoryDTO> categoryListUpdate(CategoryDTO categoryDto, ProductDTO productDto) {
		int categoryNo = session.selectOne(NS+".getCategoryNo", productDto);
		
		if(categoryDto.getCategoryDegree()==2)
			categoryDto.setCategoryNoRef((categoryNo/100)*100);
		else if(categoryDto.getCategoryDegree()==3)
			categoryDto.setCategoryNoRef((categoryNo/10)*10);
		
		return session.selectList(NS+".categoryListUpdate", categoryDto);
	}
	@Override
	public void update(ProductDTO productDto) {
		session.update(NS + ".update", productDto);
		
	}
	@Override
	public void deleteAttachByProductNo(int productNo) {
		session.delete(NS + ".deleteAttachByProductNo", productNo);
		
	}
	@Override
	public void deleteProductOptionByProductNo(int productNo) {
		session.delete(NS + ".deleteProductOptionByProductNo", productNo);
		
	}
	@Override
	public List<ProductDTO> productSearchList(SearchDTO searchDTO) {
		int categoryNo = searchDTO.getCategoryNo();
		if (categoryNo % 10 != 0) {
		} else if(categoryNo % 100 != 0) {
			searchDTO.setCategoryNo(categoryNo/10);
		} else {
			searchDTO.setCategoryNo(categoryNo/100);
		}
		Date minDate = new Date(searchDTO.getRegDate()[0].getTime());
		Date maxDate = new Date(searchDTO.getRegDate()[1].getTime()+(long) (24*60*60*1000));
		Date[] regDate = {minDate, maxDate};
		searchDTO.setRegDate(regDate);
		return session.selectList(NS+".productSearchList", searchDTO);
	}
	@Override
	public int productTotalQuantity(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".productTotalQuantity", productDTO);
	}
	
	@Override
	public int productDiscountPrice(ProductDTO productDTO) {
	
		return session.selectOne(NS+".productDiscountPrice", productDTO);
	}
	
	@Override
	public void deleteList(Integer productNo) {
		session.update(NS+".deleteList", productNo);
	}
	@Override
	public void updateList(ProductDTO productDTO) {
		session.update(NS+".updateList", productDTO);
		
	}

}