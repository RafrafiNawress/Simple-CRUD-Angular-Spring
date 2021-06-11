package tn.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.Repository.ProductRepository;
import tn.spring.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product p) {
		return productRepository.save(p);
	}
	@Override
	public Product editProduct(Product p) {
		Product product = productRepository.findById(p.getId_product()).get();
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		product.setQuantity(p.getQuantity());
		return productRepository.save(product);
	}
	@Override
	public void deleteProduct(Long idProduct) {
		Optional<Product> product = productRepository.findById(idProduct);

		if (product.isPresent()) {
			productRepository.deleteById(idProduct);
		} else {
			System.out.println("No Product record exist for given id");
		}

	}
	@Override
	public List<Product> retrieveAll() {
		return productRepository.findAll();
	}

}
