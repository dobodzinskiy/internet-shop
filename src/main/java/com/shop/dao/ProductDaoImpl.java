package com.shop.dao;

import com.shop.entity.Computer;
import com.shop.entity.Laptop;
import com.shop.entity.Phone;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.SortType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${pagination.productsPerPage}")
    private Integer productsPerPage;

    @Override
    public void addPhone(Phone phone) {
        entityManager.persist(phone);
    }

    @Override
    public void addLaptop(Laptop laptop) {
        entityManager.persist(laptop);
    }

    @Override
    public void addComputer(Computer computer) {
        entityManager.persist(computer);
    }

    @Override
    public List<Phone> getPhones(int page, SortType sortType) {
        TypedQuery<Phone> phoneTypedQuery;

        switch (sortType) {
            case NAME:
                phoneTypedQuery = entityManager.createNamedQuery("Phone.getPhonesByName", Phone.class);
                break;
            case PRICE_DESC:
                phoneTypedQuery = entityManager.createNamedQuery("Phone.getPhonesByPriceDesc", Phone.class);
                break;
            case PRICE_ASC:
                phoneTypedQuery = entityManager.createNamedQuery("Phone.getPhonesByPriceAsc", Phone.class);
                break;
            case COMPANY:
                phoneTypedQuery = entityManager.createNamedQuery("Phone.getPhonesByCompany", Phone.class);
                break;
            default:
                return Collections.emptyList();
        }

        phoneTypedQuery.setFirstResult(page).setMaxResults(productsPerPage);
        return phoneTypedQuery.getResultList();
    }

    @Override
    public List<Laptop> getLaptops(int page, SortType sortType) {
        TypedQuery<Laptop> laptopTypedQuery;

        switch (sortType) {
            case NAME:
                laptopTypedQuery = entityManager.createNamedQuery("Laptop.getLaptopsByName", Laptop.class);
                break;
            case PRICE_DESC:
                laptopTypedQuery = entityManager.createNamedQuery("Laptop.getLaptopsByPriceDesc", Laptop.class);
                break;
            case PRICE_ASC:
                laptopTypedQuery = entityManager.createNamedQuery("Laptop.getLaptopsByPriceAsc", Laptop.class);
                break;
            case COMPANY:
                laptopTypedQuery = entityManager.createNamedQuery("Laptop.getLaptopsByCompany", Laptop.class);
                break;
            default:
                return Collections.emptyList();
        }

        laptopTypedQuery.setFirstResult(page).setMaxResults(productsPerPage);
        return laptopTypedQuery.getResultList();
    }

    @Override
    public List<Computer> getComputers(int page, SortType sortType) {
        TypedQuery<Computer> computerTypedQuery;

        switch (sortType) {
            case NAME:
                computerTypedQuery = entityManager.createNamedQuery("Computer.getComputersByName", Computer.class);
                break;
            case PRICE_DESC:
                computerTypedQuery = entityManager.createNamedQuery("Computer.getComputersByPriceDesc", Computer.class);
                break;
            case PRICE_ASC:
                computerTypedQuery = entityManager.createNamedQuery("Computer.getComputersByPriceAsc", Computer.class);
                break;
            case COMPANY:
                computerTypedQuery = entityManager.createNamedQuery("Computer.getComputersByCompany", Computer.class);
                break;
            default:
                return Collections.emptyList();
        }

        computerTypedQuery.setFirstResult(page).setMaxResults(productsPerPage);
        return computerTypedQuery.getResultList();
    }

    @Override
    public void updatePhone(Phone phone) {
        entityManager.merge(phone);
    }

    @Override
    public void updateLaptop(Laptop laptop) {
        entityManager.merge(laptop);
    }

    @Override
    public void updateComputer(Computer computer) {
        entityManager.merge(computer);
    }

    @Override
    public Phone getPhone(int id) {
        TypedQuery<Phone> getPhone = entityManager.createNamedQuery("Phone.getPhone", Phone.class);
        return getPhone.setParameter("id", id).getSingleResult();
    }

    @Override
    public Laptop getLaptop(int id) {
        TypedQuery<Laptop> getLaptop = entityManager.createNamedQuery("Laptop.getLaptop", Laptop.class);
        return getLaptop.setParameter("id", id).getSingleResult();
    }

    @Override
    public Computer getComputer(int id) {
        TypedQuery<Computer> getComputer = entityManager.createNamedQuery("Computer.getComputer", Computer.class);
        return getComputer.setParameter("id", id).getSingleResult();
    }

    @Override
    public Product getProduct(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public int countProducts(ProductType productType) {
        TypedQuery<Long> countProducts = entityManager.createNamedQuery("Product.countProducts", Long.class);
        countProducts.setParameter("type", productType);
        Long count = countProducts.getSingleResult();
        return count.intValue();
    }

}
