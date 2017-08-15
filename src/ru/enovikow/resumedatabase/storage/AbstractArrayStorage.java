package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_CAPACITY = 10000;
    protected final Resume[] storage = new Resume[STORAGE_CAPACITY];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " does't exist");
            return null;
        } else {
            return storage[index];
        }
    }

    protected abstract int getIndex(String uuid);
}
