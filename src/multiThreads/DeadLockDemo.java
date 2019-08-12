package multiThreads;

public class DeadLockDemo {
	private static Object object;
	private static Object object2;

	public static void main(String[] args) {
		object = new Object();
		object2 = new Object();
		new Thread(()->{
			synchronized(object) {
				System.out.println(Thread.currentThread()+",�����߳�1");
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (object2) {
					System.out.println(Thread.currentThread()+",�ȴ������߳�2");
				}
			}
		},"�߳� 1").start() ;
		new Thread(()->{
			synchronized (object2) {
				System.out.println(Thread.currentThread()+",�����߳�2");
				try {
					Thread.sleep(1);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				synchronized (object) {
					System.out.println(Thread.currentThread()+",�ȴ���ȡ�߳�1");
				}
			}
		},"�߳� 2").start();;
	}
}
