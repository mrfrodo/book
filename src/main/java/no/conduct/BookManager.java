package no.conduct;

import no.conduct.model.Book;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class BookManager {

    private EntityManager em;

    public Book add(Book contact) {
        return null;
    }
    public Book delete(Long id) {
        return null;
    }

    public List<Book> list() {
        System.out.println("** BookManager list");

        Session session = (Session) em.getDelegate();

        return null;

    }
}
