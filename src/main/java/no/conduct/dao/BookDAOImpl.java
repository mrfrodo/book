package no.conduct.dao;

import no.conduct.dao.BookDAO;
import no.conduct.domain.Book;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


public class BookDAOImpl implements BookDAO {

    @Inject
    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<Book> memberEventSrc;

    @Inject
    private UserTransaction userTransaction;


    @Override
    public void add(Book book) {

        //Session session = (Session) em.getDelegate();

        try {
            userTransaction.begin();

            em.joinTransaction();

            em.persist(book);

            userTransaction.commit();



        }  catch (RollbackException e) {
            // We tried to commit the transaction but it has already been rolled back (adding duplicate keys would
            // generate this condition although the example does check for duplicates).
            Throwable t = e.getCause();

            System.out.println(t != null ? t.getMessage() :  e.getMessage());


        } catch (Exception e) {
            /*
             * An application cannot handle any of the other exceptions raised by begin and commit so we just
             * catch the generic exception. The meaning of the other exceptions is:
             *
             * NotSupportedException - the thread is already associated with a transaction
             * HeuristicRollbackException - should not happen since the example is interacting with a single database
             * HeuristicMixedException -  should not happen since the example is interacting with a single database
             * SystemException - the TM raised an unexpected error. There is no standard way of handling this error
             *  (another reason why CMT are preferable to managing them ourselves)
             */
            System.out.println(e.getMessage());


        } finally {
            /*
             * Since the EM is transaction scoped it will not detach its objects even when calling close on it
             * until the transaction completes. Therefore we must roll back any active transaction before returning.
             */
            try {
                if (userTransaction.getStatus() == Status.STATUS_ACTIVE)
                    userTransaction.rollback();
            } catch (Throwable e) {
                // ignore
            }
        }


    }

    @Override
    public List<Book> listAll() {



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
    public void deleteBookById(Long bookId) {
        try {

            userTransaction.begin();

            em.joinTransaction();

            Book book = (Book) em.find(Book.class, bookId);

            em.remove(book);

            userTransaction.commit();
        } catch (RollbackException e) {
            // We tried to commit the transaction but it has already been rolled back (adding duplicate keys would
            // generate this condition although the example does check for duplicates).
            Throwable t = e.getCause();

            System.out.println(t != null ? t.getMessage() :  e.getMessage());


        } catch (Exception e) {
            /*
             * An application cannot handle any of the other exceptions raised by begin and commit so we just
             * catch the generic exception. The meaning of the other exceptions is:
             *
             * NotSupportedException - the thread is already associated with a transaction
             * HeuristicRollbackException - should not happen since the example is interacting with a single database
             * HeuristicMixedException -  should not happen since the example is interacting with a single database
             * SystemException - the TM raised an unexpected error. There is no standard way of handling this error
             *  (another reason why CMT are preferable to managing them ourselves)
             */
            System.out.println(e.getMessage());


        } finally {
            /*
             * Since the EM is transaction scoped it will not detach its objects even when calling close on it
             * until the transaction completes. Therefore we must roll back any active transaction before returning.
             */
            try {
                if (userTransaction.getStatus() == Status.STATUS_ACTIVE)
                    userTransaction.rollback();
            } catch (Throwable e) {
                // ignore
            }
        }
    }
}
