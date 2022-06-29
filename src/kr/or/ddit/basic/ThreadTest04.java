package kr.or.ddit.basic;

public class ThreadTest04 {

	public static void main(String[] args) {
		//단독으로 처리하는 쓰레드
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		//여럿이 협력해서 처리하는 쓰레드
		SumThread[] smArr = new SumThread[] {
				new SumThread(		      1L, 2_000_000_000L),
				new SumThread(  500_000_001L, 2_000_000_000L),
				new SumThread(1_000_000_001L, 2_000_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L)
		};
		long startTime = System.currentTimeMillis();
		sm.start();//쓰레드 실행
		try {
			sm.join();
		}catch(InterruptedException e ) {
			
		}
		long endTime = System.currentTimeMillis();
		
//		System.out.println("단독으로 철리했을 때 경과 시간: "+ (endTime - startTime));
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		//여러 쓰레드가 협력해서 처리하는 경우
		
		startTime = System.currentTimeMillis();
		for(SumThread s: smArr) {
			s.start();
		}
		for(int i = 0; i<smArr.length; i++) {
			try {
				smArr[i].join();
				
			}catch(InterruptedException e) {
				
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("협력해서 처리한 경과 시간: "+(endTime - startTime));
	}
	
	
	

}


class SumThread extends Thread{
	//합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언
	
	private long startNum;
	private long endNum;
	
	public SumThread(long startNum, long endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = startNum; i<=endNum; i++) {
			sum += i;
		}
		System.out.println(startNum +"부터 "+endNum + "까지의 합계 : "+ sum);
	}
	
}