package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.ItemCatalog;

public interface CatalogLoader {

    public void load(ItemCatalog catalog) throws CatalogLoadException;
}
