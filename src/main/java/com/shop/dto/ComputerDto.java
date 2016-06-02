package com.shop.dto;

import com.shop.entity.ProductType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ComputerDto {

    private int id;

    @NotEmpty(message = "Please, enter device name!")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters!")
    private String name;

    @NotEmpty(message = "Please, choose photo!")
    @Pattern(regexp = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)", message = "Select a valid file!")
    private String photo;

    @DecimalMin("1.00")
    @Digits(integer = 10, fraction = 2)
    @NotNull(message = "Please, enter device price!")
    private BigDecimal price;

    @NotEmpty(message = "Please, enter model!")
    private String model;

    private String type = ProductType.COMPUTERS.getValue();
    private boolean available;

    @NotEmpty(message = "Please, enter size!")
    private String size;

    @NotNull(message = "Please, enter weight!")
    private Integer weight;

    @NotNull(message = "Please, enter storage!")
    private Integer storage;

    @NotNull(message = "Please, enter RAM!")
    private Integer ram;

    @NotNull(message = "Please, enter screen size!")
    private Float screen;

    @NotEmpty(message = "Please, enter OS!")
    private String os;

    @NotEmpty(message = "Please, enter color!")
    private String color;

    @Size(min = 5, max = 500, message = "Description should be not less than 5 and not more than 500 characters")
    @NotEmpty(message = "Description cant be empty")
    private String description;

    @NotEmpty(message = "Please, enter processor!")
    private String processor;

    @NotEmpty(message = "Please, enter company!")
    private String company;

    @NotEmpty(message = "Please, Select motherboard")
    private String motherboard;

    @NotEmpty(message = "Please, Select cooling system")
    private String coolingSystem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Float getScreen() {
        return screen;
    }

    public void setScreen(Float screen) {
        this.screen = screen;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
    }
}
