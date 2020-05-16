package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;


//lab 6 ex 6-3-1
public class CatalogFileLoader implements CatalogLoader {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        File f = new File(fileName);
        FileInputStream fis;
        String line;
        try {
            fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // ex 6-3-2
            Scanner s = new Scanner(isr);

            while(s.hasNextLine()) {
                line = s.nextLine();
                if(line.length() == 0) {
                    break;
                }
                String[] item_fld = line.split(";");
                String name = item_fld[0];
                float price = Float.parseFloat(item_fld[1]);
                short expires = Short.parseShort(item_fld[2]);
                FoodItem item = new FoodItem(name, price, null, new Date(), expires);
                catalog.addItem(item);
            }
            fis.close();
        } catch (ItemAlreadyExistsException | IOException e) {
            throw new CatalogLoadException(e);
        }
    }
}
