package com.example.packbox_demo.services;

import com.example.packbox_demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "Cycle Sport", "Simple description",  "Moscow", "Иванов И.И",25000));
        products.add(new Product(++ID, "Samsung Galaxy Fold", "Simple description",  "Moscow", "Зайцев А.В.", 100000));
    }

    public List<Product> listProducts() { return products; }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Object getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
