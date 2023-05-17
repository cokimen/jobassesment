package erbur.workassesment.app.product.route;


import erbur.workassesment.app.product.dto.ProductApiResp;
import erbur.workassesment.app.product.repository.ProductRepository;
import erbur.workassesment.app.product.service.ProductService;
import erbur.workassesment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRoute {


    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam int page, @RequestParam int size){

        Page<Product> pagination = productService.listProducts(page, size);
        HashMap<String, Object> dictJson = new HashMap<>();

        dictJson.put("Total Pages", pagination.getTotalPages());
        dictJson.put("Total Records", pagination.getTotalElements());
        dictJson.put("Page Active", pagination.getPageable().getPageNumber());
        dictJson.put("Size Record PerPage", pagination.getPageable().getPageSize());
        dictJson.put("content", pagination.getContent());


        return  ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                ProductApiResp.ProductApiRespBuilder(200, dictJson).getBodyJson()
        );
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Product product){
        Product result =productService.create(product);
        return  ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(
                ProductApiResp.ProductApiRespBuilder(201, result ).getBodyJson()
        );
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> detail(@PathVariable Long id){
        Product result = productService.getProduct(id);
        return  ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                ProductApiResp.ProductApiRespBuilder(200, result ).getBodyJson()
        );
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = {"application/json"}, headers = {"content-type=application/json"})
    public ResponseEntity<Object> updateDetail(@RequestBody Product product, @PathVariable Long id){
        product.setId(id);
        product = productService.update(product);
        return  ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                ProductApiResp.ProductApiRespBuilder(200, product).getBodyJson()
        );
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  consumes = {"application/json", "application/xml"}, headers = {"application/json"})
    public ResponseEntity<Object> delete(@PathVariable Long id){

        Product productRemove = productService.remove(id);
        return  ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                ProductApiResp.ProductApiRespBuilder(200, productRemove).getBodyJson()
        );
    }





}
