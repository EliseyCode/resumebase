package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListStorage extends AbstractStorage {

    final Collection<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Resume r, int index) {
        storage.add(r);
        System.out.println("List add Resume: " + r.getUuid());
    }

    @Override
    protected Resume[] getAllResume() {
        Resume[] array = new Resume[sizeOfStorage()];
        array =  storage.toArray(array);
        return array;
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        Iterator<Resume> iterator = storage.iterator();
        while(iterator.hasNext()) {
            Resume r = iterator.next();
            if(r.getUuid().equals(uuid)) {
                iterator.remove();
            }
        }

    }

    @Override
    protected int sizeOfStorage() {
        return storage.size();
    }

    @Override
    protected void clearStorage() {
        storage.removeAll(storage);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        for(Resume resume : storage) {
            if(resume.getUuid().equals(r.getUuid())) {
                System.out.println("List update Resume: " + r.getUuid());
                resume = r;
            }
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                System.out.println("List get Resume: " + uuid);
                return resume;
            }
        }
        return null;
    }
}

