package org.example.junit5.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false, length = 70)
  private String title;

  @Column(nullable = false, length = 35)
  private String author;

  @Column(nullable = false, length = 25)
  private String genre;

  @Column(nullable = false)
  private int height;

  @Column(length = 25)
  private String publisher;

}
