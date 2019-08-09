package edu.mum.cs.cs425.supplierrelationsys.service;

import edu.mum.cs.cs425.supplierrelationsys.model.Product;
import edu.mum.cs.cs425.supplierrelationsys.model.Supplier;
import org.springframework.data.domain.Page;

public interface ProductService {
    public Page<Product> getAllProducts(int pageNo);
    public Product saveProduct(Product p);
}
