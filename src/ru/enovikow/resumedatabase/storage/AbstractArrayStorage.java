package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.exception.ResumeExistStorageException;
import ru.enovikow.resumedatabase.exception.ResumeNotExistStorageException;
import ru.enovikow.resumedatabase.exception.ResumeStorageException;
import ru.enovikow.resumedatabase.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_CAPACITY = 10000;
    final Resume[] storage = new Resume[STORAGE_CAPACITY];
    int size = 0;

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ResumeExistStorageException(r.getUuid());
        } else if (size == STORAGE_CAPACITY) {
            throw new ResumeStorageException("Storage overflowed", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
           throw new ResumeNotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new ResumeNotExistStorageException(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new ResumeNotExistStorageException(uuid);
        } else {
            return storage[index];
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    public void clear() {
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);
}
