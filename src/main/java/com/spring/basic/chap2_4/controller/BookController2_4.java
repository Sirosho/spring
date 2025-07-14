package com.spring.basic.chap2_4.controller;

import com.spring.basic.chap2_4.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v2-4/books")
public class BookController2_4 {

    // 데이터베이스 대용으로 책들을 모아서 관리
    Map<Long, Book> bookStore = new HashMap<>();

    private Long nextId = 1L;

    public BookController2_4() {
        bookStore.put(nextId, new Book(nextId, "클린코드", "로버트 마틴", 20000));
        nextId++;
        bookStore.put(nextId, new Book(nextId, "해리포터", "조앤 롤링", 10000));
        nextId++;
        bookStore.put(nextId, new Book(nextId, "삼국지", "나관중", 15000));
        nextId++;
    }

    // 1. 목록 조회
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    @ResponseBody
    public List<Book> list(@RequestParam(value="sort",defaultValue = "id",required=false) String sort) {


        switch (sort) {
            case "id": {
                ArrayList<Book> books = new ArrayList<>(bookStore.values());
                books.sort(Comparator.comparing(Book::getId));
                return books;

            }
            case "price": {

                ArrayList<Book> books = new ArrayList<>(bookStore.values());
                books.sort(Comparator.comparing(Book::getPrice).reversed());
                return books;

            }

            case "title": {

                ArrayList<Book> books = new ArrayList<>(bookStore.values());
                books.sort(Comparator.comparing(Book::getTitle));
                return books;
            }
            default: return new ArrayList<>(bookStore.values());


        }



    }

    //2. 개별 조회
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {

        Book foundBook = bookStore.get(id);

        return foundBook;
    }

    // 2. 도서 생성
    @PostMapping
    public String createBook(String title, String author, int price){
        Book book = new Book(nextId++, title, author, price);

        bookStore.put(book.getId(),book);

        return "redirect:/api/v2-5/book-page";


    }

    // 삭제요청 /api/v2-4/books/
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id){

        if(bookStore.containsKey(id)){
            String removeBook = bookStore.get(id).getTitle();
            bookStore.remove(id);
            return removeBook + "도서가 삭제되었습니다.";
        }else{
            return "존재하지 않는 도서입니다.";
        }

    }

    @PutMapping("/{id}")
    @ResponseBody
    public String updateBook(
            String title,
            String author,
            int price,
            @PathVariable("id") Long id
    ){
        Book book = bookStore.get(id);
        if(book == null){
            return "존재하지 않는 도서입니다.";
        }
        book.updateBookInfo(title,author,price);
        return "수정 완료! id: " + id;

    }

    // 책이 몇권 저장됐는지 알려주기
    @GetMapping("/count")
    @ResponseBody
    public String count(){
        return "현재 저장된 도서의 개수"+ bookStore.size()+" 권";
    }


}








