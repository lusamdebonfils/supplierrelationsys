package edu.mum.cs.cs425.supplierrelationsys.controller;

import edu.mum.cs.cs425.supplierrelationsys.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping(value = {"/supplierrelationsys/supplier/list"})
    public ModelAndView suppliersList(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", supplierService.getAllSuppliers(pageno));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }
}
