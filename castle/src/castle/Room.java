package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> dir = new HashMap<String,Room>();


    public Room(String description) 
    {
        this.description = description;
    }

    public void setExist(String direction,Room room){
    		dir.put(direction,room);    	
    }
    
    public String getDesc(){
    	StringBuffer sb =new StringBuffer();
    	for(String begin : dir.keySet()){
    		sb.append(begin);
    		sb.append(" ");
    	}
    	return sb.toString();
    }
    
    public Room getExist(String direction){
    	Room ret = dir.get(direction);
    	return ret;
    }
    

    @Override
    public String toString()
    {
        return description;
    }
}
