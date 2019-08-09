package edu.mum.cs.cs425.supplierrelationsys.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;

    private Integer supplierNumber;

    private String name;

    private String  contactPhoneNumber;

   @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<Product> productList;

    public Supplier() {
    }

    public Supplier(Integer supplierNumber, String name, String contactPhoneNumber) {
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
        this.productList = new ArrayList<>();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierNumber=" + supplierNumber +
                ", name='" + name + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", productList=" + productList +
                '}';
    }
}
