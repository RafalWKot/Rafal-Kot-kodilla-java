package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTest {

    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Adam Mickiewicz","Dziady" ,1998 , "ISBN334343" ));
        bookSet.add(new Book("Aleksander Fredro","Zemsta" ,2006 , "ISBN356343" ));
        bookSet.add(new Book("Juliusz Słowacki","Balladyna" ,2000 , "ISBN7784343"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int medianYear = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2000, medianYear);
    }
}