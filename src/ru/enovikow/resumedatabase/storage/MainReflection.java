package ru.enovikow.resumedatabase.storage;

import ru.enovikow.resumedatabase.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {

    public static void main(String[] args) throws Exception {
        Resume r = new Resume();

        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        System.out.println(r);

        Class mc = Class.forName("ru.enovikow.resumedatabase.model.Resume");
        System.out.println(mc.toGenericString());
    }
}
