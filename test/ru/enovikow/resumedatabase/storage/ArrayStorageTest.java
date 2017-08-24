package ru.enovikow.resumedatabase.storage;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Елисей on 23.08.2017.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

//    @Test
//    public void setUp() {
//        Assert.assertEquals(3, storage.size());
////        System.out.println("Готово");
//    }

}