package Database;

import java.util.ArrayList;

public class Database {
    private ArrayList<Item> listItem = new ArrayList<Item>();
 
    public void add(Item item) {
        listItem.add(item);
    }
 
    public void list() {
        for (Item item : listItem) {
            item.print();
        }
    }
 
    public static void main(String[] args) {
        Database db = new Database();
        db.add(new MP3("AAA", 42, true, "1", "AA", 10));
        db.add(new MP3("BBB", 42, false, "2", "BB", 10));
        db.add(new MP3("CCC", 42, true, "3", "BB", 10));
        db.list();
    }
}
