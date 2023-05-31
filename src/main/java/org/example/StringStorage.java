package org.example;

import java.util.HashMap;

public class StringStorage {
    private final HashMap<Integer, String> storage = new HashMap<>();
    private int freeId = 0;

    public int add(String str) {//returns rhe id of added string
        storage.put(freeId, str);
        return freeId++;
    }

    public String get(Integer id) {
        if (storage.containsKey(id)) {
            return storage.get(id);
        }
        throw new IllegalArgumentException("There is no string with id " + id + " in the storage!!!");
    }

    public HashMap<Integer, String> getAll() {
        if (storage.size() == 0) {
            throw new IllegalArgumentException("The storage is empty!");
        }
        return storage;
    }

    public void update(Integer id, String str)  {
        if (storage.replace(id, str) == null)
            throw new IllegalArgumentException("There is no string with id " + id + " in the storage!!!");
    }

    public void delete(Integer id) {
        if (storage.remove(id) == null)
            throw new IllegalArgumentException("There is no string with id " + id + " in the storage!!!");
    }
}
