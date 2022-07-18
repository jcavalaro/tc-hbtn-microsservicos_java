package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        for(Product prod : list){
            if(id.equals(prod.getId())){
                return prod;
            }
        }
        return null;
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        for(Product prod: list){
            if(s.getId().equals(prod.getId())){
                list.set(list.indexOf(prod), s);
            }
        }
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}
