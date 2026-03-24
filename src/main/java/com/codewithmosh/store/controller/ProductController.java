package com.codewithmosh.store.controller;
import com.codewithmosh.store.dto.ProductDto;
import com.codewithmosh.store.mapper.ProductMapper;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping({"", "/"})
    public List<ProductDto> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        var product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));

    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto)
    {
        var product = productMapper.toEntity(productDto);
        productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
    ){
        var product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        productMapper.update(productDto,product);
        productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        var product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}
