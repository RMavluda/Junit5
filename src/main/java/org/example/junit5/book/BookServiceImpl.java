package org.example.junit5.book;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository repository;


  @Override
  public List<BookEntity> getAll() {
    return repository.findAll();
  }

  @Override
  public List<BookEntity> getAllByGenre(String genre) {
    return repository.findAll().stream()
        .filter(book -> genre.equals(book.getGenre()))
        .toList();
  }
}
