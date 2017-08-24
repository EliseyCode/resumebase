package ru.enovikow.resumedatabase.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.enovikow.resumedatabase.exception.ResumeExistStorageException;
import ru.enovikow.resumedatabase.exception.ResumeNotExistStorageException;
import ru.enovikow.resumedatabase.exception.ResumeStorageException;
import ru.enovikow.resumedatabase.model.Resume;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final int STORAGE_LIMIT = 10000;

    private static String UUID_1 = "uuid_1";
    private static String UUID_2 = "uuid_2";
    private static String UUID_3 = "uuid_3";
    private static String UUID_4 = "uuid_4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);


    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertGet(RESUME_4);
    }

    @Test(expected = ResumeExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test
    public void update() throws Exception {
        Resume updateResume = new Resume(UUID_2);
        storage.update(updateResume);
        assertTrue(updateResume == storage.get(UUID_2));
    }

    @Test(expected = ResumeNotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume updateResume = new Resume("Test Resume");
        storage.update(updateResume);
        assertTrue(updateResume == storage.get("Test Resume"));
    }

    @Test(expected = ResumeNotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertSize(2);
        storage.get(UUID_2);
    }

    @Test(expected = ResumeNotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        storage.get(UUID_2);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] testArray = storage.getAll();
        assertEquals(3, testArray.length);
        assertEquals(testArray[0], RESUME_1);
        assertEquals(testArray[1], RESUME_2);
        assertEquals(testArray[2], RESUME_3);

    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = ResumeNotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = ResumeStorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 3; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch(Exception e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

}