package org.example;

import java.util.HashMap;

public class StringStorage
{
    private final HashMap<Integer,String> storage=new HashMap<>();
    private int freeId=0;

    public void add(String str)
    {
        storage.put(freeId,str);
        System.out.println("String saved with id = "+ freeId);
        freeId++;
    }

    public String get(Integer id) throws IllegalArgumentException
    {
        if(storage.containsKey(id))
        {
            String str=storage.get(id);
            System.out.println(str);
            return str;
        }
        throw new IllegalArgumentException("There is no string with id "+id+" in the storage!!!");
    }

    public HashMap<Integer,String> getAll()
    {
        if(storage.size()==0)
        {
            System.out.println("The storage is Empty!");
            return null;
        }
        for(Integer i:storage.keySet())
        {
            System.out.println("String "+i+" : "+storage.get(i));
        }
        return storage;
    }

    public void update(Integer id,String str) throws IllegalArgumentException
    {
        if(storage.containsKey(id))
        {
            storage.put(id,str);
            System.out.println("String with id " + id + " was updated");
        }
        else
            throw new IllegalArgumentException("There is no string with id "+id+" in the storage!!!");
    }

    public void delete(Integer id)  throws IllegalArgumentException
    {
        if(storage.containsKey(id))
        {
            storage.remove(id);
            System.out.println("String with id " + id + " was deleted");
            return;
        }
        throw new IllegalArgumentException("There is no string with id "+id+" in the storage!!!");
    }
}
