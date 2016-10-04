package dev.wolveringer.sync;

public class TaskTimeLimiter {
	private Thread handleThread;
	private Thread timeOutThread;
	private int timeout;
	private long startTime;
	private boolean done;
	
	public TaskTimeLimiter(int timeout) {
		this(timeout,Thread.currentThread());
	}
	public TaskTimeLimiter(int timeout, Thread currentThread) {
		this.handleThread = currentThread;
		this.timeout = timeout;
		this.timeOutThread = new Thread(()->{
			try {
				Thread.sleep(timeout);
			} catch (Exception e) {}
			if(Math.abs(System.currentTimeMillis()-(startTime+timeout)) > 10){
				System.err.println("thread sleep interupted.");
			}
			else
			{
				done = true;
				handleThread.stop();
			}
		});
	}
	
	public void done(){
		done = true;
	}
	public void start(){
		startTime = System.currentTimeMillis();
		timeOutThread.start();
	}
	
	public static void main(String[] args) {
		TaskTimeLimiter lim = new TaskTimeLimiter(500);
		System.out.println("Start");
		lim.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		lim.done();
		System.out.println("Done");
	}
}
