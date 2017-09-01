package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume[] getAllResume() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        storage.remove(uuid);
    }

    @Override
    protected int sizeOfStorage() {
        return storage.size();
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        System.out.println("Map get: " + uuid);
        return storage.get(uuid);
    }

    @Override
    protected void saveResume(Resume r, int index) {
        System.out.println("Map save: " + r.getUuid());
        storage.put(r.getUuid(), r);
    }

    @Override
    protected int getIndex(String uuid) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            String key = entry.getKey();
            if (uuid.equals(key)) {
                return 1;
            }
        }
        return -1;
    }
}
