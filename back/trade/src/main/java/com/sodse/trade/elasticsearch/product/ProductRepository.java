package com.sodse.trade.elasticsearch.product;

import com.sodse.trade.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product ,Long> {


    List<Product> findAllByNameLike(String  name);




}
