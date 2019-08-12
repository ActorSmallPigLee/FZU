package multiThreads;

public class DeadLockDemo {
	private static Object object;
	private static Object object2;

	public static void main(String[] args) {
		object = new Object();
		object2 = new Object();
		new Thread(()->{
			synchronized(object) {
				System.out.println(Thread.currentThread()+",锁定线程1");
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (object2) {
					System.out.println(Thread.currentThread()+",等待锁定线程2");
				}
			}
		},"线程 1").start() ;
		new Thread(()->{
			synchronized (object2) {
				System.out.println(Thread.currentThread()+",锁定线程2");
				try {
					Thread.sleep(1);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				synchronized (object) {
					System.out.println(Thread.currentThread()+",等待获取线程1");
				}
			}
		},"线程 2").start();;
	}
}
