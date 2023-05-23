package com.works.controllers;

import com.works.entities.ProductImage;
import com.works.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class ImagesController {

    Long pid = 0l;
    final ImageService imageService;

    @GetMapping("/images/{pid}")
    public String images(@PathVariable Long pid, Model model) {
        this.pid = pid;
        model.addAttribute("images", imageService.list(this.pid));
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



}
