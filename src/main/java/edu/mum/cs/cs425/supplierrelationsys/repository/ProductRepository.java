package edu.mum.cs.cs425.supplierrelationsys.repository;

import edu.mum.cs.cs425.supplierrelationsys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
