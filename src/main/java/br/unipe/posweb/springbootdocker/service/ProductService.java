package br.unipe.posweb.springbootdocker.service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unipe.posweb.springbootdocker.domain.Product;
import br.unipe.posweb.springbootdocker.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product save(Product product) {
        return this.repository.save(product);
    }

	public Product update(Product product) {
		return this.repository.save(product);
    }
    
    public void delete(Product product) {
    	this.repository.delete(product);
    }
    
    public Product find(Long id) {
    	return this.repository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

}
