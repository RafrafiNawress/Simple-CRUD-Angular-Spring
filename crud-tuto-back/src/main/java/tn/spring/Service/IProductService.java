package tn.spring.Service;

import java.util.List;

import tn.spring.entity.Product;

public interface IProductService {

	Product addProduct(Product p);

	Product editProduct(Product p);

	void deleteProduct(Long idProduct);

	List<Product> retrieveAll();
}
