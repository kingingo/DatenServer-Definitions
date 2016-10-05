package eu.epicpvp.datenserver.definitions.sync;

import eu.epicpvp.datenserver.definitions.unsave.ReflectUnsave;
import lombok.Getter;

public class WaitForObject {
	public static class TimeOutException extends Exception{
		public TimeOutException() {
			super();
		}

		public TimeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public TimeOutException(String message, Throwable cause) {
			super(message, cause);
		}

		public TimeOutException(String message) {
			super(message);
		}

		public TimeOutException(Throwable cause) {
			super(cause);
		}
	}
	
	private static final int steps = 5;
	private int startDeep = 1;
	@Getter
	private int doneDeep = startDeep;
	
	public WaitForObject() {
		this(1);
	}
	
	public WaitForObject(int startDeep) {
		this.startDeep = startDeep;
	}
	
	public void reset(){
		doneDeep = startDeep;
	}
	
	public void done(){
		doneDeep--;
	}
	
	public void waitFor(){
		waitFor(5000);
	}
	public void waitFor(int timeout){
		waitFor(timeout, true);
	}
	public void waitFor(int timeout,boolean throwException){
		waitFor(timeout, throwException, steps);
	}
	public void waitFor(int timeout,boolean throwException,int steps){
		long start = System.currentTimeMillis();
		while (!(doneDeep <= 0) && System.currentTimeMillis()-start < timeout) {
			try {
				Thread.sleep(Math.min(timeout, steps));
			} catch (InterruptedException e) {
				if(throwException)
					ReflectUnsave.getUnsafe().throwException(e);
			}
		}
		if(!(doneDeep <= 0) && throwException){
			ReflectUnsave.getUnsafe().throwException(new TimeOutException("Waited more than "+timeout+"ms"));
		}
	}
	
	public void waitForThrows(int timeout,boolean throwException,int steps) throws InterruptedException, TimeOutException{
		try{
			waitFor(timeout, throwException, steps);
			
			//Compiler fix
			if(false)
				throw new InterruptedException();
			if(false)
				throw new TimeOutException();
			//Compiler fix end
		}catch(InterruptedException e){
			throw e;
		}catch(TimeOutException e){
			throw e;
		}
	}
}
