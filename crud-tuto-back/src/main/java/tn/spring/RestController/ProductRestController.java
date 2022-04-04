package tn.spring.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.Service.IProductService;
import tn.spring.entity.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductRestController {

	@Autowired
	IProductService productService;

	// http://localhost:8081/all-products
	@GetMapping("/all-Products")
	public List<Product> getProducts() {
		return productService.retrieveAll();
	}

	// http://localhost:8081/add-Product
	@PostMapping("/add-Product")
	public Product addProduct(@RequestBody Product p) {
		return productService.addProduct(p);
	}
	
	// http://localhost:8081/edit-Product
	@PutMapping("/edit-Product")
	public Product editProduct(@RequestBody Product p) {
		return productService.editProduct(p);
	}

	// http://localhost:8081/delet-Product/id
		@DeleteMapping("/delete-Product/{idProduct}")
		public void deleteProduct(@PathVariable("idProduct") Long id) {
			 productService.deleteProduct(id);
		}
}
