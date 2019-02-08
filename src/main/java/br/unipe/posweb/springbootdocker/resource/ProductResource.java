package br.unipe.posweb.springbootdocker.resource;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.unipe.posweb.springbootdocker.domain.Product;
import br.unipe.posweb.springbootdocker.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductResource {

	@Autowired
	ProductService service;
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Product product) {
		Product personSave = this.service.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(personSave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product) {
		product.setId(id);
		product = this.service.save(product);
		return ResponseEntity.accepted().body(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		Product product = this.service.find(id);
		this.service.delete(product);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> find(@PathVariable(value = "id") Long id) {
		Product product = this.service.find(id);
		return ResponseEntity.ok().body(product);
	}

	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> products = this.service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
}
