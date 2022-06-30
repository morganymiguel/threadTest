package kr.or.ddit.basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//데몬 쓰레드로 설정하기
		//  => 반드시 start()메서드를 호출하기 전에 설정한다.
		autoSave.setDaemon(true);
		
		autoSave.start();
		try {
			for(int i = 1; i<=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			
		}catch(InterruptedException e ) {
			
		}
		System.out.println("main 쓰레드 종료...");
		
	}

}
class AutoSaveThread extends Thread{
	//자동 저장하는 메서드
	private void save() {
		System.out.println("작업 내용을 저장합니다...");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				
			}
			save();
		}
	}
}
