package edu.mum.cs.cs425.supplierrelationsys.service.implementation;

import edu.mum.cs.cs425.supplierrelationsys.model.Supplier;
import edu.mum.cs.cs425.supplierrelationsys.repository.SupplierRepository;
import edu.mum.cs.cs425.supplierrelationsys.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService {
    @Autowired
    protected SupplierRepository supplierRepo;

    @Override
    public Page<Supplier> getAllSuppliers(int pageNo) {
        return supplierRepo.findAll(PageRequest.of(pageNo, 3, Sort.by("name")));
    }

    @Override
    public Supplier saveSupplier(Supplier p) {
        return supplierRepo.save(p);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier getOneByID(int id) {
        return supplierRepo.getOne(id);
    }
}
