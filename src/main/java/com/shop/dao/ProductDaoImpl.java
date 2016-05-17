package com.shop.dao;

import com.shop.entity.Computer;
import com.shop.entity.Laptop;
import com.shop.entity.Phone;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.entity.SortType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

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
    public List<Phone> getPhones() {
        return entityManager.createNamedQuery("getPhones", Phone.class).getResultList();
    }

    @Override
    public List<Laptop> getLaptops() {
        return entityManager.createNamedQuery("getLaptops", Laptop.class).getResultList();
    }

    @Override
    public List<Computer> getComputers() {
        return entityManager.createNamedQuery("getComputers", Computer.class).getResultList();
    }

    @Override
    public List<Product> getProducts(ProductType productType, SortType sortType, int productNumber, int productsPerPage) {
        TypedQuery<Product> getProducts = null;
        switch(sortType) {
            case Name:
                getProducts = entityManager.createNamedQuery("getProductsByName", Product.class);
                break;
            case PriceDesc:
                getProducts = entityManager.createNamedQuery("getProductsByPriceDesc", Product.class);
                break;
            case PriceAsc:
                getProducts = entityManager.createNamedQuery("getProductsByPriceAsc", Product.class);
                break;
            case Company:
                getProducts = entityManager.createNamedQuery("getProductsByCompany", Product.class);
                break;
        }
        getProducts.setFirstResult(productNumber).setMaxResults(productsPerPage);
        return getProducts.setParameter("type", productType).getResultList();
    }

    @Override
    public List<Object> getProducts(ProductType productType) {
        TypedQuery<Object> getProducts = entityManager.createNamedQuery("getProductsByName", Object.class);
        return getProducts.setParameter("type", productType).getResultList();
    }

    @Override
    public List<Product> getTopProducts(int topProductsCount) {
        TypedQuery<Product> getAllProducts = entityManager.createNamedQuery("getTopProducts", Product.class);
        return getAllProducts.setMaxResults(topProductsCount).getResultList();
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
        TypedQuery<Phone> getPhone = entityManager.createNamedQuery("getPhone", Phone.class);
        return getPhone.setParameter("id", id).getSingleResult();
    }

    @Override
    public Laptop getLaptop(int id) {
        TypedQuery<Laptop> getLaptop = entityManager.createNamedQuery("getLaptop", Laptop.class);
        return getLaptop.setParameter("id", id).getSingleResult();
    }

    @Override
    public Computer getComputer(int id) {
        TypedQuery<Computer> getComputer = entityManager.createNamedQuery("getComputer", Computer.class);
        return getComputer.setParameter("id", id).getSingleResult();
    }

    @Override
    public Product getProduct(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> getProductsByName(String name, SortType sortType, int productNumber, int productsPerPage) {
        TypedQuery<Product> getProductByName = null;
        switch(sortType) {
            case Name:
                getProductByName = entityManager.createNamedQuery("searchProductsByName", Product.class);
                break;
            case PriceDesc:
                getProductByName = entityManager.createNamedQuery("searchProductsByPriceDesc", Product.class);
                break;
            case PriceAsc:
                getProductByName = entityManager.createNamedQuery("searchProductsByPriceAsc", Product.class);
                break;
            case Company:
                getProductByName = entityManager.createNamedQuery("searchProductsByCompany", Product.class);
                break;
        }
        getProductByName.setFirstResult(productNumber).setMaxResults(productsPerPage);
        return getProductByName.setParameter("name", "%" + name + "%").getResultList();
    }

    @Override
    public int countProducts(ProductType productType) {
        TypedQuery<Long> countProducts = entityManager.createNamedQuery("countProducts", Long.class);
        countProducts.setParameter("type", productType);
        Long count = countProducts.getSingleResult();
        return count.intValue();
    }

    @Override
    public int countSearchProducts(String searchWord) {
        TypedQuery<Long> countSearchProducts = entityManager.createNamedQuery("countSearchProducts", Long.class);
        countSearchProducts.setParameter("name", "%" + searchWord + "%");
        Long count = countSearchProducts.getSingleResult();
        return count.intValue();
    }
}
