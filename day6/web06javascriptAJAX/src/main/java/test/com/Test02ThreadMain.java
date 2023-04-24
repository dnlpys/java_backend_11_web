package test.com;

public class Test02ThreadMain {

	public static void main(String[] args) {
		System.out.println("start main Thread...");
		
		System.out.println(0);
		System.out.println(1);
		System.out.println(2);
		
		
		//무명 내부클래스(익명내부클래스)
		Thread t = new Thread() {
			//클래스 영역
			@Override
			public void run() {
				for (int i = 10; i < 20; i++) {
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		
		new Thread() {
			//클래스 영역
			@Override
			public void run() {
				for (int i = 110; i < 120; i++) {
					System.out.println(i);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		System.out.println(3);
		System.out.println(4);
		
		Test02ThreadMain tm = new Test02ThreadMain();
		tm.new Inner().start();

		new Test02ThreadMain().new Inner().start();
		
		
		System.out.println(5);
		
		new StaticInner().start();
		
		System.out.println(6);
		
		//local inner class : 상속불가
		class LocalInner{
			public void sleep() {
				System.out.println("sleep()...");
			}
		}
		new LocalInner().sleep();
		
		RunnableImpl r =  new Test02ThreadMain().new RunnableImpl();
		new Thread(r).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1111110; i < 1111120; i++) {
					System.out.println(i);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		System.out.println("end main....");
	}//end main
	
	
	class RunnableImpl implements Runnable{
		@Override
		public void run() {
			for (int i = 111110; i < 111120; i++) {
				System.out.println(i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	//static inner class
	static class StaticInner extends Thread{
		@Override
		public void run() {
			for (int i = 11110; i < 11120; i++) {
				System.out.println(i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//Member inner class
	class Inner extends Thread{
		
		@Override
		public void run() {
			for (int i = 1110; i < 1120; i++) {
				System.out.println(i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}//end Inner class
	

}
