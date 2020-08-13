package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.CategoryDTO;
import kr.co.domain.ProductDTO;
import kr.co.domain.ProductOptionDTO;
import kr.co.domain.SearchDTO;
import kr.co.persistence.ProductDAO;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;

	@Override
	public void insert(ProductDTO productDto) {
		productDao.insert(productDto);
		String[] files = productDto.getFiles();
		if(files != null) {  
			for(String fullName : files) {	
				productDao.addAttach(fullName, productDto.getProductNo());
			}			
		}
		List<ProductOptionDTO> list = productDto.getProductOptionList();
		for (ProductOptionDTO productOptionDTO : list) {
			if(productOptionDTO.getProductQuantity()!=0){
				productOptionDTO.setProductNo(productDto.getProductNo());
				productDao.insertProductOption(productOptionDTO);
			}
		}
		
	}
	
	@Override
	public void deleteAttachByFileName(String filename) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<String> getAttach(Integer productNo) {

		return productDao.getAttach(productNo);
	}
	
	@Override
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub
		return productDao.categoryList();
	}
	
	@Override
	public List<CategoryDTO> categoryListN(CategoryDTO categoryDto) {
		// TODO Auto-generated method stub
		return  productDao.categoryListN(categoryDto);
	}
	@Override
	public List<ProductDTO> productList() {
		List<ProductDTO> productList = productDao.productList();
		for (ProductDTO productDTO : productList) {
			List<String> fileList = productDao.getAttach(productDTO.getProductNo());	
			String[] files = new String[fileList.size()];
			int i = 0;
			for(String file : fileList) {
				files[i] = file;
				
				i++;
			}
			productDTO.setFiles(files);	
			productDTO.setCategoryName(productDao.getCategoryName(productDTO.getCategoryNo()));
			productDTO.setProductDiscountPrice(productDao.productDiscountPrice(productDTO));
			productDTO.setProductTotalQuantity(productDao.productTotalQuantity(productDTO));
		}
		
		
		return productList;
	}

	@Override
	public ProductDTO updateUI(int productNo) {
		ProductDTO productDto = productDao.updateUI(productNo);
		productDto.setCategoryName(productDao.getCategoryName(productDto.getCategoryNo()));
		List<String> productAttachList = productDao.getAttach(productNo);

		int arrSize = productAttachList.size();
		String[] files = new String[arrSize];
		int i = 0;
		for (String file : productAttachList) {
			files[i] = file;
			i++;
		}		
		
		productDto.setFiles(files);
		List<ProductOptionDTO> productOptionList = productDao.productOptionList(productNo);
		productDto.setProductOptionList(productOptionList);
		
		
		return productDto;
	}
	@Override
	public List<CategoryDTO> categoryListUpdate(CategoryDTO categoryDto, ProductDTO productDto) {
		// TODO Auto-generated method stub
		return productDao.categoryListUpdate(categoryDto, productDto);
	}
	
	@Override
	public void update(ProductDTO productDto) {
		productDao.update(productDto);
		productDao.deleteAttachByProductNo(productDto.getProductNo());
		productDao.deleteProductOptionByProductNo(productDto.getProductNo());
		
		String[] files = productDto.getFiles();
		if(files != null) {
			for (String fullname : files) {
				productDao.addAttach(fullname, productDto.getProductNo());
			}
		}
		
		List<ProductOptionDTO> list = productDto.getProductOptionList();
		for (ProductOptionDTO productOptionDTO : list) {
			if(productOptionDTO.getProductQuantity()!=0){
				productOptionDTO.setProductNo(productDto.getProductNo());
				productDao.insertProductOption(productOptionDTO);
			}
		}
	}
	@Override
	public List<ProductDTO> productSearchList(SearchDTO searchDTO) {
		List<ProductDTO> productList = productDao.productSearchList(searchDTO);
		for (ProductDTO productDTO : productList) {
			List<String> fileList = productDao.getAttach(productDTO.getProductNo());	
			String[] files = new String[fileList.size()];
			int i = 0;
			for(String file : fileList) {
				files[i] = file;		
				i++;
			}
			productDTO.setFiles(files);	
			productDTO.setCategoryName(productDao.getCategoryName(productDTO.getCategoryNo()));
			productDTO.setProductDiscountPrice(productDao.productDiscountPrice(productDTO));
			productDTO.setProductTotalQuantity(productDao.productTotalQuantity(productDTO));
		}
		
		
		return productList;
	}
	@Override
	public void deleteList(String[] checkbox_product) {
		for (String sProductNo : checkbox_product) {
			productDao.deleteList(Integer.valueOf(sProductNo));
		}
		
	}
	
	@Override
	public void updateList(ProductDTO productDTO) {
		productDao.updateList(productDTO);
		
	}
	


}