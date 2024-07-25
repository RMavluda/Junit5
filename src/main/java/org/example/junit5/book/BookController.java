package org.example.junit5.book;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

  private final BookService service;

  @GetMapping
  public List<BookEntity> getList(@RequestParam(required = false) String genre){
    if(genre != null){
      return service.getAllByGenre(genre);
    }
    return service.getAll();
  }
}
