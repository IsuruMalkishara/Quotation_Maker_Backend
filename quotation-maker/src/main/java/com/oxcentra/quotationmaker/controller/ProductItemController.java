package com.oxcentra.quotationmaker.controller;

import com.oxcentra.quotationmaker.model.ProductItem;
import com.oxcentra.quotationmaker.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductItemController {
    @Autowired
    private ProductItemService productItemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product")
    public @ResponseBody
    List<ProductItem> getProductItem(){
        return productItemService.getProductItemList();
    }
}
