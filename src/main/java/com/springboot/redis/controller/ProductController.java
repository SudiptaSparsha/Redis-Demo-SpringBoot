package com.springboot.redis.controller;

import com.springboot.redis.entity.Product;
import com.springboot.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        dao.save(product);
        return product;
    }

    @GetMapping
    public List<Product> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product getBuId(@PathVariable int id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return dao.deleteById(id);
    }
}
