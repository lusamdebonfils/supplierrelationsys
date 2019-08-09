package edu.mum.cs.cs425.supplierrelationsys.service.implementation;

import edu.mum.cs.cs425.supplierrelationsys.model.Product;
import edu.mum.cs.cs425.supplierrelationsys.repository.ProductRepository;
import edu.mum.cs.cs425.supplierrelationsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    protected ProductRepository productRepo;

    @Override
    public Page<Product> getAllProducts(int pageNo) {
        return productRepo.findAll(PageRequest.of(pageNo, 3, Sort.by("productNumber")));
    }

    @Override
    public Product saveProduct(Product p) {
        return productRepo.save(p);
    }
}
