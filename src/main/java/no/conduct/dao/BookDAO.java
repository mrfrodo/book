package no.conduct.dao;


import no.conduct.domain.Book;

import java.util.List;

public interface BookDAO {

    public void add(Book book);
    public List<Book> listAll();
    public Book listBookById(Long userId);
    public void deleteBookById(Long userId);
}
