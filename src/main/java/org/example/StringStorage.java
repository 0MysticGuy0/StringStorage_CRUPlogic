package org.example;

import java.util.HashMap;

public class StringStorage
{
    private static HashMap<Integer,String> storage=new HashMap<>();

    private static Integer getFreeId()
    {
        Integer lastId=0;
        for(Integer id:storage.keySet())
        {
            if(id>lastId) return lastId;
            if (storage.get(id) == null)    return id;
            lastId++;
        }
        return lastId;
    }

    public static void add(String str)
    {
        Integer id=getFreeId();
        storage.put(id,str);
        System.out.println("String saved with id = "+ id);
    }

    public static String get(Integer id)
    {
        if(storage.containsKey(id))
        {
            String str=storage.get(id);
            System.out.println(str);
            return str;
        }
        System.out.println("There is no string with id "+id+" in the storage!!!");
        return null;
    }

    public static void update(Integer id,String str)
    {
        if(storage.containsKey(id))
        {
            storage.put(id,str);
            System.out.println("String with id " + id + " was updated");
            return;
        }
        System.out.println("There is no string with id "+id+" in the storage!!!");
    }

    public static void delete(Integer id)
    {
        if(storage.containsKey(id))
        {
            storage.remove(id);
            System.out.println("String with id " + id + " was deleted");
            return;
        }
        System.out.println("There is no string with id "+id+" in the storage!!!");
    }
}
