package kr.co.service;


import java.util.List;

import kr.co.domain.CategoryDTO;
import kr.co.domain.ProductDTO;
import kr.co.domain.SearchDTO;


public interface ProductService {

	void insert(ProductDTO productDto);

	void deleteAttachByFileName(String filename);

	List<String> getAttach(Integer productNo);

	List<CategoryDTO> categoryList();

	List<CategoryDTO> categoryListN(CategoryDTO categoryDto);

	List<ProductDTO> productList();

	ProductDTO updateUI(int productNo);

	List<CategoryDTO> categoryListUpdate(CategoryDTO categoryDto, ProductDTO productDto);

	void update(ProductDTO productDto);

	List<ProductDTO> productSearchList(SearchDTO searchDTO);

	void deleteList(String[] checkbox_product);

	void updateList(ProductDTO productDTO);



}