package com.work.service;

import com.work.entities.Admin;
import com.work.entities.Product;
import com.work.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;
    final HttpServletResponse response;
    final HttpServletRequest request;

    Long pid ;

    public Product save(Product product) {
       Admin admin = (Admin) request.getSession().getAttribute("admin");
       product.setAid(admin.getAid());
        return productRepository.save(product);
    }


    public Page<Product> adminProduct(int page){

        Admin admin = (Admin) request.getSession().getAttribute("admin");

        Pageable pageable = PageRequest.of(page,10);

        Page<Product> productPage = productRepository.findByAidEquals(admin.getAid(), pageable);

        return productPage;
    }

    public Page<Product> allProduct(int page){

        Pageable pageable = PageRequest.of(page,10);

        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage;
    }
    public boolean deleteProduct(String stPid){
        try {
            long pid = Long.parseLong(stPid);
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            boolean status = productRepository.existsByPidEqualsAndAidEquals(pid, admin.getAid());
            if(status){
                productRepository.deleteById(pid);
                return true;
            }
        }catch (Exception exception){
            System.err.println(exception);
        }
        return false;
    }

    public Product product(Long pid){
        try {
            this.pid = pid;
            return productRepository.findByPidEquals(pid);
        }catch (Exception exception){
            return null;
        }
    }

    public Product productid(){
        return product(this.pid);
    }




}
