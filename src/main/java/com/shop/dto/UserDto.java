package com.shop.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

public class UserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    @NotEmpty(message = "Please, your valid email")
    private String email;

    @NotEmpty(message = "Please, enter your password")
    private String password;

    @NotEmpty(message = "Please, enter your login")
    private String login;

    @Pattern(regexp = "(^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$)", message = "Date not valid!")
    private String date;

    @NotEmpty(message = "Please, enter your phone")
    @Pattern(regexp = "(380+[0-9]{9})", message = "Not valid. Enter 380XXXXXXXXX")
    private String phone;

    private Set<String> userRoles;

    private boolean enabled;

    private boolean staff;

    private List<OrderDto> orders;

    private List<ProductDto> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<String> userRoles) {
        this.userRoles = userRoles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
