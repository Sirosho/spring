package com.spring.basic.chap2_3.practice;

import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("/practice/api/v1")
    public class PracticeController2_3 {

        @GetMapping("/welcome")
        public String welcome() {
            return "welcome to Spring MVC!";
        }



        @GetMapping("/product/product/{id}")
        public String getProduct(@PathVariable("id") String productId) {
            return "Product ID: " + productId;
        }


        @GetMapping("/books")
        public String getBooks(@RequestParam("author") String author,
                               @RequestParam("genre") String genre) {
            return "Author: " + author + ", Genre: " + genre;
        }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query,
                         @RequestParam(value = "page", defaultValue = "1") int page) {
        return "Query: " + query + ", Page: " + page;
    }





    }

