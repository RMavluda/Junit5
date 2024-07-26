package org.example.junit5.book;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookServiceImpl bookService;

  /*
    @BeforeEach
    public void setup() {
      bookRepository = Mockito.mock(BookRepository.class);
      bookService = new BookServiceImpl(bookRepository);
    }*/

  @Test
  public void shouldReturnBookByGenre() {
    String genre = "data_science";
    List<BookEntity> books = getBooks();

    Mockito.when(bookRepository.findAll()).thenReturn(books);

    List<BookEntity> result = bookService.getAllByGenre(genre);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(1, result.size());
    Assertions.assertEquals(books.get(1), result.get(0));
  }

  private List<BookEntity> getBooks(){
    BookEntity firstBook = new BookEntity();
    BookEntity secondBook = new BookEntity();

    firstBook.setId(1L);
    firstBook.setAuthor("Goswami, Jaidewa");
    firstBook.setGenre("signal_processing");
    firstBook.setTitle("Fundamentals of Wavelets");
    firstBook.setPublisher("Wiley");
    firstBook.setHeight(228);

    secondBook.setId(2L);
    secondBook.setAuthor("Foreman, John");
    secondBook.setGenre("data_science");
    secondBook.setTitle("Data Smart");
    secondBook.setPublisher("Wiley");
    secondBook.setHeight(235);

    return List.of(firstBook, secondBook);
  }


}
