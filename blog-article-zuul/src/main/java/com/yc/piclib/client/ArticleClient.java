package com.yc.piclib.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",configuration = FeignClient.class)
public interface ArticleClient {

    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/blog-proxy/blog/{id}")
    String findById(@RequestParam("id") Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/blog-proxy/blog/findNew",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String findNew();

    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/blog-proxy/blog/findHot",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String findHot();

    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/blog-proxy/blog/findCategory/{id}")
    String findByCategory(@RequestParam("id") Integer id);
}
