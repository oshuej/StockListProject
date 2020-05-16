package ru.billing.stocklist;


import ru.billing.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {

    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.get(item.getID()) == null) {
            catalog.put(item.getID(), item); // Добавляем товар в HashMap
            ALCatalog.add(item); // Добавляем тот же товар в ArrayList
        } else {
            // TODO Auto-generated catch block
            throw new ItemAlreadyExistsException(item);
        }
    }

    public void printItems() {
        for(GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id) {
        for(GenericItem i : ALCatalog) {
            if(i.getID() == id) {
                return i;
            }
        }
        return null;
    }

}
