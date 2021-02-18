package com.sodse.trade;

import com.sodse.trade.domain.Product;
import com.sodse.trade.elasticsearch.product.ProductRepository;
import com.sodse.trade.redis.service.OrderRedis;
import com.sodse.trade.service.ProductService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ElasticsearchTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;


    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testAgg(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为categorys，聚合字段为category
        queryBuilder.addAggregation(
                AggregationBuilders.terms("categorys").field("category"));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Product> aggPage = (AggregatedPage<Product>) productRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为category的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("categorys");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即种类
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }

    }


    @Test
    public void testSort(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", "书籍"));

        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));

        // 执行搜索，获取结果
        Page<Product> items = productRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        items.forEach(System.out::println);
    }


    @Test
    public void testNativeQuery2(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", "手机"));

        // 初始化分页参数
        int page = 0;
        int size = 3;
        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 执行搜索，获取结果
        Page<Product> items = productRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        // 每页大小
        System.out.println(items.getSize());
        // 当前页
        System.out.println(items.getNumber());
        items.forEach(System.out::println);
    }


    @Test
    public void testNativeQuery(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", "手机"));
        // 执行搜索，获取结果
        Page<Product> items = productRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        items.forEach(System.out::println);
    }


    @Test
    public void testBaseQuery(){
        // 词条查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "小米");
        // 执行查询
        Iterable<Product> items = productRepository.search(queryBuilder);
        items.forEach(System.out::println);
    }


    @Test
    void product_es_test4(){
        productRepository.deleteAll();

    }

    @Test
    void product_es_test3(){

        List<Product> products = productRepository.findAllByNameLike("手机");
        for (Product p:products) {
            System.out.println(p.getName());
        }
        productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));

    }
    @Test
    public void es_Create() {
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchRestTemplate.putMapping(Product.class);
        // 创建索引，会根据Item类的@Document注解信息来创建
//        elasticsearchRestTemplate.createIndex(Product.class);

    }

    @Test
    public void es_Delete() {
        productRepository.deleteAll();
        elasticsearchRestTemplate.deleteIndex(Product.class);
    }

    @Test
    void product_es_test2(){
        productRepository.saveAll(productService.find());
    }


    @Test
    void product_es_test(){
        Product p=new Product();
        p.setId(2L);
        p.setName("手机");
        p.setPrice(new BigDecimal(100));
        p.setContent("这是一件物品");
//        productRepository.index(p);
        productRepository.save(p);


    }

}
