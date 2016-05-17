package com.shop.controller;

import com.shop.dto.*;
import com.shop.service.CommentService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public List<PhoneDto> getPhones() {
        return productService.getPhones();
    }

    @RequestMapping(value = "/laptops", method = RequestMethod.GET)
    public List<LaptopDto> getLaptops() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        return productService.getLaptops();
    }

    @RequestMapping(value = "/computers", method = RequestMethod.GET)
    public List<ComputerDto> getComputers() {
        return productService.getComputers();
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public List<CommentDto> getComments(@PathVariable("id") int productId) {
        return commentService.getComments(productId);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/phones/add", method = RequestMethod.POST)
    public ResponseEntity<?> addPhone(@RequestBody PhoneDto phoneDto) {
        return new ResponseEntity<>(productService.addPhone(phoneDto), HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/laptops/add", method = RequestMethod.POST)
    public ResponseEntity<?> addLaptop(@RequestBody LaptopDto laptopDto) {
        return new ResponseEntity<>(productService.addLaptop(laptopDto), HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/computers/add", method = RequestMethod.POST)
    public ResponseEntity<?> addComputer(@RequestBody ComputerDto computerDto) {
        return new ResponseEntity<>(productService.addComputer(computerDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/phones/{id}", method = RequestMethod.GET)
    public PhoneDto getPhone(@PathVariable("id") int productId) {
        return productService.getPhone(productId);
    }

    @RequestMapping(value = "/laptops/{id}", method = RequestMethod.GET)
    public LaptopDto getLaptop(@PathVariable("id") int id) {
        return productService.getLaptop(id);
    }

    @RequestMapping(value = "/computers/{id}", method = RequestMethod.GET)
    public ComputerDto getComputer(@PathVariable("id") int id) {
        return productService.getComputer(id);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/phones/change", method = RequestMethod.PUT)
    public ResponseEntity<?> changePhone(@RequestBody PhoneDto phoneDto) {
        return new ResponseEntity<>(productService.updatePhone(phoneDto), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/laptops/change", method = RequestMethod.PUT)
    public ResponseEntity<?> changeLaptop(@RequestBody LaptopDto laptopDto) {
        return new ResponseEntity<>(productService.updateLaptop(laptopDto), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/computers/change", method = RequestMethod.PUT)
    public ResponseEntity<?> changeComputer(@RequestBody ComputerDto computerDto) {
        return new ResponseEntity<>(productService.updateComputer(computerDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/comments/add", method = RequestMethod.POST)
    public ResponseEntity<?> addComment(@RequestBody CommentDto comment) {
        return new ResponseEntity<>(commentService.addComment(comment), HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/comments/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteComment(@RequestBody int commentId) {
        commentService.removeComment(commentId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
