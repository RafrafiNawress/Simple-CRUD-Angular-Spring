package tn.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}





