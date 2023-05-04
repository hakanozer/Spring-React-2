package com.works.controllers;

import com.works.props.Products;
import com.works.services.utils.SearchServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    SearchServices services=new SearchServices();

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String q, Model model){
        List<Products> ls=services.search(q);
        model.addAttribute("products",ls);
        model.addAttribute("q", q);
        return "search";
    }

}
