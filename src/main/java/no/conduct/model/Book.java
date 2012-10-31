package no.conduct.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    private static final long serialVersionUID = -8767337896773261247L;

    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private Date created;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}