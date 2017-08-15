package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    public void clear() {
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size == STORAGE_CAPACITY) {
            System.out.println("Storage overflowed");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r) {
        if (getIndex(r.getUuid()) == -1) {
            System.out.println("Resume " + r.getUuid() + " does't exist");
        } else {
            storage[getIndex(r.getUuid())] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " does't exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}