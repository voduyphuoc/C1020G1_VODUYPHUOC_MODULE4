package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String getCart(){
        return "cart";
    }
    @GetMapping(value = "/{id}/add")
    public String viewAdd(HttpSession session, @PathVariable("id") Integer productId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        return "/cart";
    }

    @GetMapping(value = "/{productId}/remove")
    public String viewRemove(HttpSession session, @PathVariable("productId") Integer productId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(productId);
        if (cartItems.get(productId).getQuantity() == 1){
            cartItems.remove(productId);
            return "cart";
        }else if (cartItems.containsKey(productId)) {
            Cart item = cartItems.get(productId);
            item.setProduct(product);
            item.setQuantity(item.getQuantity() - 1);
            cartItems.put(productId, item);
        }
        session.setAttribute("myCartItems", cartItems);
        return "/cart";
    }
}
