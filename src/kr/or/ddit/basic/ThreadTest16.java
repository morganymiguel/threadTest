package kr.or.ddit.basic;

//은행의 입출금을 쓰레드로 처리하는 예제

public class ThreadTest16 {
	private int balance; // 잔액이 저장될 변수

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;

	}

	// 입금을 처리하는 메서드
	public void deposit(int money) {
		balance += money;

	}

	// 출금을 처리하는 메서드(반환값: 출금 성공(true), 실패(false)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 안전하다.
//	public synchronized boolean withdraw(int money) {
	public boolean withdraw(int money) {
		synchronized (this) {

			if (balance >= money) {// 출금 가능
				for (int i = 1; i <= 100000000; i++) {

				}

				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				return true;
			} else {
				// 출금 불가
				return false;
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();
		account.setBalance(10000); // 잔액을 10000원으로 설정

		// 익명 구현체로 쓰레드 구현1111111111111111111111111111111111
		Runnable r = new Runnable() {
			@Override
			public void run() {
				boolean result = account.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서 result = " + result + ", balance = " + account.getBalance());
			}
		};
		// 11111111111111111111111111111111111까지가 익명 구현체

		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();

	}

}
