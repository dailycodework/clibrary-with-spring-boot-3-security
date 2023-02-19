package com.dailycodework.clibrary.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/all")
    public ResponseEntity<List<BookRecord>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        return new ResponseEntity<>(bookService.add(book), CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book theBook){
        return new ResponseEntity<>(bookService.update(theBook), OK);
    }
    @GetMapping("/book/{id}")
    public Optional<Book> getById(@PathVariable("id") Long bookId){
        return bookService.findById(bookId);
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable("id") Long bookId){
        bookService.delete(bookId);
    }
}
