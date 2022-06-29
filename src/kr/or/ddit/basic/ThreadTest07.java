package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {

	public static void main(String[] args) {
/*
		 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
		 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
		 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
		 입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
		 5초안에 입력이 없으면 게임에 진것으로 처리한다.
		 5초안에 입력이 있으면 승패를 구해서 출력한다.
		 실행예시) --> 5초안에 입력을 못햇을 경구
		 -----결과-------
		 시간초과로 당신이 졌습니다.
		 
		 실행예시) --> 5초안에 입력을 했을 경우
		 ---결과---
		 시간초과로 당신이 졌습니다. 
		 
		 ---결과---
		 컴퓨터: 가위
		 사용자: 바위
		 결과: 당신이 이겼습니다. 
 */
		Thread th1 = new DataInput01();
		Thread th2 = new CountDown01();
		th1.start();
		th2.start();
	}

}

class DataInput01 extends Thread{
	public static boolean inputCheck = false;
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위 바위 보");
		System.out.println("입력한 값: "+ str);
		inputCheck = true;
	}
}

class CountDown01 extends Thread{
	@Override
	public void run() {
		for(int i = 5; i>=1; i--) {
			if(DataInput01.inputCheck ==true	) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
		System.out.println("---결과---");
		System.out.println("시간초과로 졌습니다.");
		System.exit(0);
	}
}