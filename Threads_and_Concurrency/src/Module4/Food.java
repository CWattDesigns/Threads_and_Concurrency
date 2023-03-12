package Module4;
import java.util.Random;

public class Food 
{
	public String meal;
	
	public Food() {
	}

	synchronized public void eat() {
		Random r = new Random();
		int sleep;
		if (Thread.currentThread().getName().equals("Hare")) {
			sleep = r.nextInt(0,165);
		} else {
			sleep = r.nextInt(0,165);
		}	
			
		try {
				Thread.sleep(sleep);
				System.out.println(Thread.currentThread().getName() + " started eating.");
				System.out.println(Thread.currentThread().getName() + " is done eating.");
				
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
	