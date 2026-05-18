package com.javarush.lesson09.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @GetMapping("/product/gift")
    public String showGift() {
        throw new ResourceNotFoundException("Not found gift");
    }

    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
//                                BindingResult bindingResult,
                                Model model) {
//        if (bindingResult.hasErrors()) {
//            return "product-form";
//        }

        // Logic to save the product
        // System.out.println("Product saved: " + product.getName());

        return "redirect:/products/success";
    }

    @GetMapping("/products/success")
    public String showSucces(Model model) {
        model.addAttribute("product", new Product());
        return "product-success";
    }
}