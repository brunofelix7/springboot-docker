package br.unipe.posweb.springbootdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.unipe.posweb.springbootdocker.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
