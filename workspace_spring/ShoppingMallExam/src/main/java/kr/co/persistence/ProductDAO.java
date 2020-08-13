package kr.co.persistence;

import java.util.List;

import kr.co.domain.CategoryDTO;
import kr.co.domain.ProductDTO;
import kr.co.domain.ProductOptionDTO;
import kr.co.domain.SearchDTO;

public interface ProductDAO {

	List<CategoryDTO> categoryList();

	List<CategoryDTO> categoryListN(CategoryDTO categoryDto);

	void insert(ProductDTO productDto);

	void addAttach(String fullName, int productNo);

	void insertProductOption(ProductOptionDTO productOptionDTO);

	List<ProductDTO> productList();

	String getCategoryName(int categoryNo);

	ProductDTO updateUI(int productNo);

	List<String> getAttach(Integer productNo);

	List<CategoryDTO> categoryListUpdate(CategoryDTO categoryDto, ProductDTO productDto);

	void update(ProductDTO productDto);

	void deleteAttachByProductNo(int productNo);

	void deleteProductOptionByProductNo(int productNo);

	List<ProductOptionDTO> productOptionList(int productNo);

	List<ProductDTO> productSearchList(SearchDTO searchDTO);

	int productDiscountPrice(ProductDTO productDTO);

	int productTotalQuantity(ProductDTO productDTO);

	void deleteList(Integer productNo);

	void updateList(ProductDTO productDTO);

}