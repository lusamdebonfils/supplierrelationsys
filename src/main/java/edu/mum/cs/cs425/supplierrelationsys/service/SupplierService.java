package edu.mum.cs.cs425.supplierrelationsys.service;

import edu.mum.cs.cs425.supplierrelationsys.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    public Page<Supplier> getAllSuppliers(int pageNo);
    public Supplier saveSupplier(Supplier p);
    public List<Supplier> getAllSuppliers();
    public Supplier getOneByID(int id);
}
