package no.conduct;

import com.opensymphony.xwork2.ActionSupport;
import no.conduct.model.Book;

import java.util.List;

public class BookAction extends ActionSupport {

    private static final long serialVersionUID = 9149826260758390091L;
    private Book book;
    private List<Book> bookList;
    private Long id;

    private BookManager bookManager;

    public BookAction() {
        bookManager = new BookManager();
    }

    public String execute() {
        System.out.println("** BookAction execute");
        this.bookList = bookManager.list();
        System.out.println("execute called");
        return SUCCESS;
    }

    public String add() {
        System.out.println(getBook());
        try {
            bookManager.add(getBook());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.bookList = bookManager.list();
        return SUCCESS;
    }

    public String delete() {
        bookManager.delete(getId());
        return SUCCESS;
    }

    public Book getBook() {
        return book;
    }

    public List<Book> getContactList() {
        return bookList;
    }

    public void setContact(Book contact) {
        this.book = contact;
    }

    public void setContactList(List<Book> contactsList) {
        this.bookList = contactsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}