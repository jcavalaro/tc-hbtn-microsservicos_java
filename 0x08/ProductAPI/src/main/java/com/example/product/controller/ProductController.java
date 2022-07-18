package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Product API REST")
@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;
//GET => /api-product/products/welcome: exibe a seguinte mensagem de boas vindas ‘BEM VINDO À PRODUCT REST API.’
    @ApiOperation(value="Responsável por retornar uma mensagem de boas vindas.")
    @GetMapping("/welcome")
    public String msgBoasVindas(){
        return "BEM VINDO À PRODUCT REST API.";
    }
    //GET => /api-product/products/allProducts: lista todos as produtos
    @ApiOperation(value="Responsável por retornar uma lista de produtos.")
    @GetMapping(path = "/allProducts")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> prodList = productRepository.getAllProducts();
            if(prodList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(prodList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //GET => /api-product/products/findProductById/{id}: buscar um produto pelo id
    @ApiOperation(value="Responsável por retornar um produto pelo id.")
    @GetMapping(path = "/findProductById/{id}")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long id){
        Optional<Product> prodList = Optional.ofNullable(productRepository.getProductById(id));
        return prodList.map(resp -> ResponseEntity.ok(resp)).
                orElse(ResponseEntity.notFound().build());
    }
    //POST => /api-product/products/addProduct: adicionar um produto.
    @ApiOperation(value="Responsável por adicionar um produto.")
    @PostMapping(path = "/addProduct")
    @ApiResponse(code = 10, message = "Required fields not informed.")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        try{
            productRepository.addProduct(prod);
            return new ResponseEntity<>(productRepository.getProductById(prod.getId()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //PUT => /api-product/products/updateProduct: atualiza um produto.
    @ApiOperation(value="Responsável por atualizar um produto.")
    @PutMapping(path = "/updateProduct")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod){
        Optional<Product> prodList = Optional.ofNullable((productRepository.getProductById(prod.getId())));
        if (prodList.isPresent()) {
            productRepository.updateProduct(prod);
            return new ResponseEntity<>(productRepository.getProductById(prod.getId()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //DELETE => /api-product/products/removeProduct: remove um produto.
    @ApiOperation(value="Responsável por remover um produto.")
    @DeleteMapping(path = "/removeProduct")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    public ResponseEntity<Void> deleteProductById(@RequestBody Product prod){
        try {
            Optional<Product> productById = Optional.ofNullable(productRepository.getProductById(prod.getId()));
            if (productById.isPresent()) {
                productRepository.removeProduct(prod);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
