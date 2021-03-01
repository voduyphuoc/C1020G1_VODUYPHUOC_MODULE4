package com.example.service.imp;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImp implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone6", 1000000, 30, "USA", "New"));
        productMap.put(2, new Product(2, "Iphone7", 3000000, 20, "USA", "New"));
        productMap.put(3, new Product(3, "Iphone8", 4000000, 20, "USA", "New"));
        productMap.put(4, new Product(4, "IphoneX", 7000000, 20, "USA", "New"));
        productMap.put(5, new Product(5, "IphoneXI", 15000000, 10, "USA", "New"));
        productMap.put(6, new Product(6, "IphoneXII", 35000000, 50, "USA", "New"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
