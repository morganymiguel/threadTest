package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	public static boolean inputCheck = false;

	public static void main(String[] args) {
		/*
		 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
		 * 
		 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고, 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
		 * 
		 * 입력 시간은 5초로 제한하고 카운트 다운을 진행한다. 5초안에 입력이 없으면 게임에 진것으로 처리한다.
		 * 
		 * 5초안에 입력이 있으면 승패를 구해서 출력한다. ------------------- 실행예시) --> 5초안에 입력을 못했을 경우
		 * 
		 * -- 결과 -- 시간초과로 당신이 졌습니다.
		 * 
		 * 실행예시) --> 5초안에 입력을 했을 경우 -- 결 과 -- 컴퓨터 : 가위 사용자 : 바위 결과 : 당신이 이겼습니다.
		 */
		Thread th1 = new DataInput1();
		Thread th2 = new CountDown1();

		th1.start();
		th2.start();

	}

}

// 1.사용자로부터 데이터 입력받기
class DataInput1 extends Thread {
	// 컴퓨터의 난수생성
	String[] random = { "가위", "바위", "보" };
	int index = (int) (Math.random() * 3);
	String computer = random[index];

	@Override
	public void run() {
		// 입력받기
		String str = JOptionPane.showInputDialog("가위, 바위, 보를 입력하세요.");
		ThreadTest07.inputCheck = true;

		System.out.println("사용자 : " + str);

		System.out.println(computer);

		if (str.equals(computer)) {
			System.out.println("비겼다");
		} else if (str.equals("가위") && computer.equals("보") || str.equals("바위") && computer.equals("가위")
				|| str.equals("보") && computer.equals("바위")) {
			System.out.println("이김");
		} else {
			System.out.println("짐");
		}

	}
}

// 2.카운트다운을 진행하는 쓰레드
class CountDown1 extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {

			if (ThreadTest07.inputCheck == true) {
				return;
			}
			System.out.println("카운트 다운 5초 : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		System.out.println(" 시간초과로 당신이 졌습니다.");
		System.exit(0);

	}
}