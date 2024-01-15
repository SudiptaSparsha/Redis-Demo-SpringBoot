package com.springboot.redis.repository;

import com.springboot.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    public static final String Hash_Key = "Product";

    public Product save(Product product){
        template.opsForHash().put(Hash_Key, product.getId(), product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(Hash_Key);
    }

    public Product findById(int id){
        return (Product) template.opsForHash().get(Hash_Key, id);
    }

    public String deleteById(int id){
        template.opsForHash().delete(Hash_Key, id);
        return "Product Removed!";
    }
}
