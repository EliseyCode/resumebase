package ru.enovikow.resumedatabase.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.enovikow.resumedatabase.exception.ResumeNotExistStorageException;
import ru.enovikow.resumedatabase.model.Resume;

public abstract class AbstractArrayStorageTest {
    public static Storage storage;
    private static String UUID_1 = "uuid_1";
    private static String UUID_2 = "uuid_2";
    private static String UUID_3 = "uuid_3";

    public AbstractArrayStorageTest(Storage storage) {
     this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = ResumeNotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

}