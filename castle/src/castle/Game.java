package castle;

import java.util.HashMap;
import java.util.Scanner;


public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlerMap =new HashMap<String, Handler>();
    
    class Handler{
    	public void doCmd(String cmd){}
    	public boolean isBye(){
    		return false; 		
    	}
    }
    
    class HandlerHelp extends Handler{
    	public void doCmd(String cmd){
            System.out.print("迷路了吗？你可以做的命令有：go bye help");
            System.out.println("如：\tgo east");
    	}
    }
    
    class HandlerBye extends Handler{
    	public void doCmd(String cmd){
    		System.out.println("感谢您的光临。再见！");
    	}
    	public boolean isBye(){
    		return true;
    	}
    }
    
    class HandlerGo extends Handler{
    	public void doCmd(String cmd){
    		goRoom(cmd);
    	}
    }
    
    public Game() 
    {
        createRooms();
        createCmds();
    }

    private void createCmds() {
		Handler handlerHelp =new HandlerHelp();
		Handler handlerBye =new HandlerBye();
		Handler handlerGo =new HandlerGo();
		handlerMap.put("help", handlerHelp);
		handlerMap.put("bye", handlerBye);
		handlerMap.put("go", handlerGo);
	}

	private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExist("west",pub);
        outside.setExist("east",lobby);
        outside.setExist("south",study);
        lobby.setExist("west",outside);
        pub.setExist("east", outside);
        study.setExist("north",outside);
        study.setExist("east", bedroom);
        bedroom.setExist("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showWord();
    }


    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExist(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showWord();
        }
    }
//    
    public void showWord(){
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.print(currentRoom.getDesc());
        System.out.println();
    }
	
    public void go(){
		Scanner in = new Scanner(System.in);
    	while(true){
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		Handler handler =handlerMap.get(words[0]);
    		String tmp ="";
    		if(words.length >1){
    			tmp = words[1];
    		}
    		if (handler !=null){
	    		handler.doCmd(tmp);
	    		if(handler.isBye()){
	    			break;
	    		}
    		} else if(line.length() !=0){
    			System.out.println("很抱歉，你可以做的命令只有：go bye help");
    		}
    	}
        in.close();
    }
    
	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
		game.go();
	}

}
