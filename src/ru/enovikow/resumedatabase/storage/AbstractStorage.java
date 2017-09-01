package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.exception.ResumeExistStorageException;
import ru.enovikow.resumedatabase.exception.ResumeNotExistStorageException;
import ru.enovikow.resumedatabase.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void clear() {
        clearStorage();
    }

    @Override
    public void save(Resume r) {
        System.out.println("Try to save to MapStorage: " + r.getUuid());
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ResumeExistStorageException(r.getUuid());
        } else {
            saveResume(r, index);
        }
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new ResumeNotExistStorageException(r.getUuid());
        } else {
            updateResume(r, index);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new ResumeNotExistStorageException(uuid);
        } else {
            return getResume(uuid, index);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new ResumeNotExistStorageException(uuid);
        } else {
            deleteResume(uuid, index);
        }
    }

    @Override
    public Resume[] getAll() {
        return getAllResume();
    }

    protected abstract Resume[] getAllResume();

    @Override
    public int size() {
        return sizeOfStorage();
    }

    protected abstract void deleteResume(String uuid, int index);

    protected abstract int sizeOfStorage();

    protected abstract void clearStorage();

    protected abstract void updateResume(Resume r, int index);

    protected abstract Resume getResume(String uuid, int index);

    protected abstract void saveResume(Resume r, int index);

    protected abstract int getIndex(String uuid);
}
