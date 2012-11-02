package no.conduct.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import no.conduct.dao.BookDAO;
import no.conduct.dao.BookDAOImpl;
import no.conduct.domain.Book;
import org.apache.struts2.ServletActionContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class BookAction extends ActionSupport {

    private static final long serialVersionUID = 9149826260758390091L;
    private Book book;
    private List<Book> bookList = new ArrayList<Book>();

    @Inject
    private BookDAO bookDAO;

    public String execute() {
        System.out.println("** BookAction execute");

        return SUCCESS;
    }

    public String add() {

        bookDAO.add(book);

        return SUCCESS;
    }

    public String list() {
        System.out.println("** list");


        this.bookList = bookDAO.listAll();

        return SUCCESS;
    }

    public String delete() {
        bookDAO.deleteBookById(book.getId());
        return SUCCESS;
    }

    public Book getBook() {
        return book;
    }


    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }


    public void setBookList(List<Book> booksList) {
        this.bookList = booksList;
    }

}