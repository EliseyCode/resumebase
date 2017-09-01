package ru.enovikow.resumedatabase;

import ru.enovikow.resumedatabase.model.Resume;
import ru.enovikow.resumedatabase.storage.ListStorage;
import ru.enovikow.resumedatabase.storage.MapStorage;
import ru.enovikow.resumedatabase.storage.Storage;

/**
 * Test for ru.enovikow.resumedatabase.storage.ArrayStorage
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new MapStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("UUID_1");
        Resume r2 = new Resume("UUID_2");
        Resume r3 = new Resume("UUID_3");
        Resume r4 = new Resume("UUID_4");
        Resume r5 = new Resume();
        Resume r6 = new Resume();
        Resume r7 = new Resume();
        Resume r8 = new Resume();

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r3);
//        ARRAY_STORAGE.save(r7);
//        ARRAY_STORAGE.save(r6);
//        ARRAY_STORAGE.save(r8);
//        ARRAY_STORAGE.save(r5);

        ARRAY_STORAGE.get("UUID_1");
        System.out.println(ARRAY_STORAGE.size());
        ARRAY_STORAGE.delete("UUID_2");
        System.out.println(ARRAY_STORAGE.size());
        ARRAY_STORAGE.get("UUID_2");
//        ARRAY_STORAGE.update(r1);
//        System.out.println(ARRAY_STORAGE.size());
//        ARRAY_STORAGE.clear();
//        ARRAY_STORAGE.delete(r1.getUuid());
//        System.out.println(ARRAY_STORAGE.size());
//        System.out.println(ARRAY_STORAGE.getAll());
//        ARRAY_STORAGE.get("UUID_1");
//
//        ARRAY_STORAGE.update(r2);
//
//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
//        System.out.println("Size: " + ARRAY_STORAGE.size());
//
////        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
//        printAll();
//        ARRAY_STORAGE.delete(r1.getUuid());
//        printAll();
//        ARRAY_STORAGE.clear();
//        printAll();
//
//        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}