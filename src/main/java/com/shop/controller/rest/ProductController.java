package com.shop.controller.rest;

import com.shop.dto.CommentDto;
import com.shop.dto.ComputerDto;
import com.shop.dto.LaptopDto;
import com.shop.dto.PhoneDto;
import com.shop.service.CommentService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public List<PhoneDto> getPhones(int page, String sort) {
        return productService.getPhones(page, sort);
    }

    @RequestMapping(value = "/laptops", method = RequestMethod.GET)
    public List<LaptopDto> getLaptops(int page, String sort) {
        return productService.getLaptops(page, sort);
    }

    @RequestMapping(value = "/computers", method = RequestMethod.GET)
    public List<ComputerDto> getComputers(int page, String sort) {
        return productService.getComputers(page, sort);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/phones", method = RequestMethod.PUT)
    public PhoneDto changePhone(@Valid @RequestBody PhoneDto phoneDto) {
        return productService.updatePhone(phoneDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/laptops", method = RequestMethod.PUT)
    public LaptopDto changeLaptop(@Valid @RequestBody LaptopDto laptopDto) {
        return productService.updateLaptop(laptopDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/computers", method = RequestMethod.PUT)
    public ComputerDto changeComputer(@Valid @RequestBody ComputerDto computerDto) {
        return productService.updateComputer(computerDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/phones/add", method = RequestMethod.POST)
    public PhoneDto addPhone(@Valid @RequestBody PhoneDto phoneDto) {
        return productService.addPhone(phoneDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/laptops/add", method = RequestMethod.POST)
    public LaptopDto addLaptop(@Valid @RequestBody LaptopDto laptopDto) {
        return productService.addLaptop(laptopDto);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/computers/add", method = RequestMethod.POST)
    public ComputerDto addComputer(@Valid @RequestBody ComputerDto computerDto) {
        return productService.addComputer(computerDto);
    }

    @RequestMapping(value = "/pages/{type}", method = RequestMethod.GET)
    public int getPages(@PathVariable("type") String productType) {
        return productService.getPagesCount(productType);
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public List<CommentDto> getComments(@PathVariable("id") int productId) {
        return commentService.getComments(productId);
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
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/available/{id}", method = RequestMethod.PUT)
    public void changeAvailable(@PathVariable("id") int productId) {
        productService.changeAvailable(productId);
    }

    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/comments/add", method = RequestMethod.POST)
    public CommentDto addComment(@Valid @RequestBody CommentDto comment) {
        return commentService.addComment(comment);
    }

    @Secured("ROLE_USER")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int commentId) {
        commentService.removeComment(commentId);
    }

}
