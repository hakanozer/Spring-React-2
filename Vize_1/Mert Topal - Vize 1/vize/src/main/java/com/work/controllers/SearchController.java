package com.work.controllers;

import com.work.entities.Product;
import com.work.service.AdminService;
import com.work.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {
    final SearchService service;
    final AdminService adminService;

    @GetMapping("/search")
    public String searchdata(@RequestParam(defaultValue = "") String search, Model model){
        model.addAttribute("admin",adminService.userAdmin());
        model.addAttribute("product",service.searchList(search));
        model.addAttribute( "data", search );

        return "search";
    }

}
