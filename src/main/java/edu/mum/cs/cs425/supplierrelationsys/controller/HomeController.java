package edu.mum.cs.cs425.supplierrelationsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/","/supplierrelationsys"})
    public String displayHome(){
        return "index";
    }

}
