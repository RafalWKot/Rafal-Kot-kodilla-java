package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Book book1 = new Book("Book1","Author1", LocalDate.of(2018, 1, 7));
        Book book2 = new Book("Book2","Author2", LocalDate.of(2014, 5, 21));
        Book book3 = new Book("Book3","Author3", LocalDate.of(2002, 11, 2));

        Library library = new Library("School library");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Faculty library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedlibrary = null;
        try {
            deepClonedlibrary = library.deepCopy();
            deepClonedlibrary.setName("Academic library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }


        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedlibrary);

        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedlibrary.getBooks().size());
        Assert.assertEquals(shallowClonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedlibrary.getBooks(), library.getBooks());


    }
}
