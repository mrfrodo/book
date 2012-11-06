
package no.conduct.model;

import no.conduct.domain.Book;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;



public class BookTest {

    private static final Logger log = Logger.getLogger("BookTest");

    @Test
    public void testVigerous() {

        log.info("testVigerous");
        log.debug("test debug");

        Assert.assertTrue(true);
    }

    public void testProperties() {
        Book book = new Book();
        Assert.assertNull(book.getFirstName());
        Assert.assertNull(book.getLastName());
        Assert.assertNull(book.getCreated());
    }
}
