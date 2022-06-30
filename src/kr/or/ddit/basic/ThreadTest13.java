package kr.or.ddit.basic;

import java.util.ArrayList;

/* 
	10마리의 말들이 경주하는 경마 프로그램 작성하기
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 이쓴 내부 정렬 기준이 있다.
	(comparable인터페이스 구현)
	
	경기 구간은 1~50구간으로 되어 있다.
	말의 현재 위치는 현재 말이 달리고 있는 현재 구간 값이 저장된다.
	
 	경기가 진행되는 동안에는 중간 중간에 각 말들의 위치를 나타내시오.
 	예)
 	말이름1: ---->-------------------------------
 	말이름1: ------->----------------------------
 	...
 	말이름10: -->---------------------------------
*/


public class ThreadTest13 {

	public static void main(String[] args) {
		ArrayList<Horse> arr = new ArrayList<>();
		
		
		
		
	}

}
class Horse extends Thread{
	String name;
	int rank;
	int addr;
	
	
	@Override
	public void run() {
		
	}
}