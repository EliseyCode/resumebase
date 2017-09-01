package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.exception.ResumeStorageException;
import ru.enovikow.resumedatabase.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    private static final int STORAGE_CAPACITY = 10000;
    final Resume[] storage = new Resume[STORAGE_CAPACITY];
    int size = 0;

    @Override
    protected void saveResume(Resume r, int index) {
        if (size == STORAGE_CAPACITY) {
            throw new ResumeStorageException("Storage overflowed", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }
    @Override
    public void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    public void deleteResume(String uuid, int index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getResume(String uuid, int index) {
        return storage[index];

    }

    @Override
    public Resume[] getAllResume() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    @Override
    public void clearStorage() {
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    @Override
    public int sizeOfStorage() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);
}
