```java
package testpackage;

class Test{
    public static void main(String[] args) 
    {
	BallGameApp.run();

    }

} //TestApp

class BallGameApp {
    public static void run()
    {
	BallGame.run();
    }
}

class BallGame {
    
    public static void run()
    {
	playGame(5,100);
    }
    
    public static void playGame(int width, int height)
    {
	int starPos = 0;
	boolean starPosFlag = true;
	for (int i = 1; i <= height ; i++){   
	    
	    System.out.print('!');
	    fillWithSpace(0,starPos);
	    System.out.print('*');
	    fillWithSpace(starPos+1,width);
	    System.out.println('!');
	    starPosFlag = getFlag(starPos, width,starPosFlag);
	    starPos = getStarPosition(starPos, width,starPosFlag);
	    
	}
    }
    
    public static int getStarPosition(int starPos,int width,boolean starPosFlag){
	if (width == 1)
	    return starPos;
	
	if (starPosFlag)
	    return ++starPos;
	
	return --starPos;
    }
    public static boolean getFlag(int starPos, int width, boolean starPosFlag)
    {
	if (starPos == width -1)
	    return false;
	if (starPos == 0)
	    return true;
	
	return starPosFlag;
    }
    
    public static void fillWithSpace(int start,int end)
    {
	
	for (int i = start; i < end; i++){
	    System.out.print(' ');
	}
    }
    
}
```
