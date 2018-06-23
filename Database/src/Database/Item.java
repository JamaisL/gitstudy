package Database;

public class Item {
    private String title;
    private int playTime;
    private boolean gotIt = false;
    private String comment;
 
    public Item(String title, int playTime, boolean gotIt, String comment) {
        super();
        this.title = title;
        this.playTime = playTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }
 
    public void print() {
        System.out.print(title + ":" + playTime + ":" + gotIt + ":" + comment);
    }

}
