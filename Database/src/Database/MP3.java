package Database;

public class MP3 extends Item {
    private String singer;
    private int sizeofSong;
 
    public MP3(String title, int playTime, boolean gotIt, String comment, String singer, int sizeofSong) {
        super(title, playTime, gotIt, comment);
        this.singer = singer;
        this.sizeofSong = sizeofSong;
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
        System.out.print("MP3:");
        super.print();
        System.out.println(":" + singer + ":" + sizeofSong);
	}

}
