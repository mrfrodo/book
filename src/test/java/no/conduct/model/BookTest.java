
package no.conduct.model;

import org.junit.Assert;
import org.junit.Test;


public class BookTest {

    @Test
    public void testVigerous() {
        Assert.assertTrue(true);
    }

    public void testProperties() {
        Book book = new Book();
        Assert.assertNull(book.getFirstName());
        Assert.assertNull(book.getLastName());
        Assert.assertNull(book.getCreated());
    }
}
