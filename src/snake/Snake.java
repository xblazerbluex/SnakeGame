package snake;

public class Snake {
	private int  MOVESPEED = 20;
	
	private int[] px = {39,39,39,39,39,39,39};
	private int[] py = {39,39,39,39,39,39,39};
	private char direction = 'd';
	
	public void update(){
		for(int i=6;i>0;i--){
			py[i]=py[i-1];
			px[i]=px[i-1];
		}
		System.out.println(direction);
		switch (direction){
		case 'd':
			py[0]+=MOVESPEED;
			break;
		case 'u':
			py[0]-=MOVESPEED;
			break;
		case 'r':
			px[0]+=MOVESPEED;
			break;
		case 'l':
			px[0]-=MOVESPEED;
			break;
		}
		
	}

	public int getPx(int i) {
		return px[i];
	}

	public int getPy(int i) {
		return py[i];
	}

	public char getDirection() {
		return direction;
	}

	public void setPx(int value,int i) {
		this.px[i] = value;
	}

	public void setPy(int value, int i) {
		this.py[i] = value;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
}
