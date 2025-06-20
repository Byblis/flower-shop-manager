package com.example.flowershopmanager.controller;

import com.example.flowershopmanager.entity.Product;
import com.example.flowershopmanager.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 商品登録フォームを表示
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

   @PostMapping("/save")
public String saveProduct(@ModelAttribute Product product) {
    if (product.getThreshold() == null) {
        product.setThreshold(20); // ← nullだったら20を入れる（自動設定）
    }
    productRepository.save(product);
    return "redirect:/products/list";
}


    // 商品一覧を表示（次ステップで作る画面）
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product-list";
    }
}


