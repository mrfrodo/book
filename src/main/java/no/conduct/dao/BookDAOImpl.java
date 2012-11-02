package no.conduct.dao;

import no.conduct.dao.BookDAO;
import no.conduct.domain.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


public class BookDAOImpl implements BookDAO {

    @Inject
    private EntityManager em;

    @Override
    public void add(Book book) {
        System.out.println("** BookDAOImpl");

        System.out.println("** em = " + em);

    }

    @Override
    public List<Book> listAll() {
        System.out.println("** BookDAOImpl listAll em = " + em);

        // using Hibernate Session and CriteriaQuery via Hibernate Native API
        Session session = (Session) em.getDelegate();
        Criteria cb = session.createCriteria(Book.class);
        cb.addOrder(Order.asc("title"));

        List<Book> list = cb.list();

        return (List<Book>) list;

    }

    @Override
    public Book listBookById(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteBookById(Long userId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
