package org.example.junit5.book;

import java.util.List;

public interface BookService {

  List<BookEntity> getAll();

  List<BookEntity> getAllByGenre(String genre);
}
