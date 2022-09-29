package service;


import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {
    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProductById(int id) {
        return productRepository.findOneById(id);
    }

    public ServiceProduct() {
    }
}
