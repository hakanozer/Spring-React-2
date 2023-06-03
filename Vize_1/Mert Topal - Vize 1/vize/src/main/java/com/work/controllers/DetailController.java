package com.work.controllers;

import com.work.entities.ProductImage;
import com.work.service.AdminService;
import com.work.service.ImagesService;
import com.work.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DetailController {
    final AdminService adminService;
    final ProductService productService;
    final ImagesService imageService;
    Long pid = 0l;
    List<ProductImage> ls = new ArrayList<>();


    @GetMapping("/detail/{pid}")
    public String detail (@PathVariable Long pid, Model model){
        model.addAttribute("admin",adminService.userAdmin());
        model.addAttribute("product",productService.product(pid));
        model.addAttribute("images", ls );
        productService.product(pid);
        return "detail";
    }

    @GetMapping("/images/{pid}")
    public String images(@PathVariable Long pid, Model model) {
        model.addAttribute("admin",adminService.userAdmin());
        this.pid = pid;
        ls = imageService.list(this.pid);
        model.addAttribute("images", ls );
        return "images";
    }

    @PostMapping("/imageAdd")
    public String imageAdd(@RequestParam("image") MultipartFile file) throws IOException, SQLException {
        ProductImage productImage = new ProductImage();
        productImage.setPid(this.pid);
        byte[] fileBytes = file.getBytes();
        Blob blob = new SerialBlob(fileBytes);
        productImage.setImage(blob);
        imageService.addImage(productImage);
        return "redirect:/images/"+this.pid;
    }

    @ResponseBody
    @GetMapping (value = "/getImage/{index}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage( @PathVariable int index ) throws IOException, SQLException {
        Blob blob = ls.get(index).getImage();
        int blobLength = (int) blob.length();
        byte[] image = blob.getBytes(1, blobLength);
        return image;
    }

    @GetMapping("/imageDelete/{imgId}")
    public String imageDelete(@PathVariable(required=false) Long imgId, Model model){
        model.addAttribute("imgId", imgId);
        System.out.println(imgId);
        imageService.imageDelete(imgId);
        return "redirect:/images/"+this.pid;
    }

}
