package edu.mum.cs.cs425.supplierrelationsys.controller;

import edu.mum.cs.cs425.supplierrelationsys.model.Product;
import edu.mum.cs.cs425.supplierrelationsys.model.Supplier;
import edu.mum.cs.cs425.supplierrelationsys.service.ProductService;
import edu.mum.cs.cs425.supplierrelationsys.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @GetMapping(value = {"/supplierrelationsys/product/list"})
    public ModelAndView suppliersList(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productService.getAllProducts(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

//    @PostMapping(value = {"/supplierrelationsys/product/new"})
//    public String addNewProduct(
//            @Valid
//            @ModelAttribute("product")
//                    Product product,
//            BindingResult bindingResult,
//            Model model
//    ) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "product/add";
//        }
//        productService.saveProduct(product);
//        return "redirect:/supplierrelationsys/product/list";
//    }

    @GetMapping(value={"/supplierrelationsys/product/newform"})
    public String addNewProductPost(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "product/add";
    }

    @PostMapping(value = {"/supplierrelationsys/product/new"})
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/add";
        }
        //Supplier supplier = supplierService.getOneByID(product.getSupplierIdRef());
        //supplier.getProductList().add(product);
        product = productService.saveProduct(product);
        return "redirect:/supplierrelationsys/product/list";
    }


}
