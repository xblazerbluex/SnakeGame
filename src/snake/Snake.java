package snake;

import java.util.ArrayList;

public class Snake {
	private int  MOVESPEED = 30;
	private int length = 0;
	private ArrayList<Integer> px = new ArrayList<Integer>();
	private ArrayList<Integer> py = new ArrayList<Integer>();
	private char direction = 'd';
	
	public Snake(){
		length = 7;
		for (int i=0; i<length; i++){
			px.add(i, 0);
			py.add(i, 0);
		}
	}
	
	public void update(){
		for(int i=6;i>0;i--){
			px.set(i, px.get(i-1));
			py.set(i, py.get(i-1));
		}
		System.out.println(direction);
		switch (direction){
		case 'd':
			py.set(0, py.get(0) + MOVESPEED);
			break;
		case 'u':
			py.set(0, py.get(0) - MOVESPEED);
			break;
		case 'r':
			px.set(0, px.get(0) + MOVESPEED);
			break;
		case 'l':
			px.set(0, px.get(0) - MOVESPEED);
			break;
		}
	}
	
	public int getLength() {
		return length;
	}

	public int getPx(int i) {
		return px.get(i);
	}

	public int getPy(int i) {
		return py.get(i);
	}

	public char getDirection() {
		return direction;
	}

	public void setPx(int value,int i) {
		px.set(i, value);
	}

	public void setPy(int value, int i) {
		py.set(i, value);
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
