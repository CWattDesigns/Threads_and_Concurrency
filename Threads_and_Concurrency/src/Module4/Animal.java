package Module4;

public class Animal implements Runnable{
	public String name;
	public int position;
	public int speed;
	public int restMax;
	static boolean winner = false;
	public Food meal;
	
	//constructor
	public Animal(String name, int speed, int restMax, Food meal) {
		super();
		this.name = name;
		this.speed = speed;
		this.restMax = restMax;
		this.meal = meal;
	}
	
	//main
	public static void main(String[] args) {
		//Creates a meal
		Food meal = new Food();
		
		//Creates Hare and Tortoise Animals
		Thread animal1 = new Thread(
				new Animal("Hare", 9, 220, new Food()));
		Thread animal2 = new Thread(
				new Animal("Tortoise", 5, 165, new Food()));
		
		//Starts the threads
		animal1.start();
		animal2.start();
		animal1.setName("Hare");
		animal2.setName("Tortoise");
		
	}

	@Override
	public void run() {
		while(position <= 120 && winner == false) {									//While position is less than 120 & winner is false...
			System.out.println(name+" advances to "+position);						//Print the animal name and position.
			position += speed;														//Increment the animal position by the animal speed.
			long max = restMax;
			long random = (long)(max * Math.random());								//Create a random variable between min and max
			try {
				Thread.sleep(random);												//Sleep thread for a random time.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			meal.eat();
			
			//If the position crosses 120, set the winner to true and print out the winner!
			if (position >= 120) {
				winner = true;
				System.out.println("THE WINNER IS: "+name+"! CONGRATULATIONS!!");
				break;
			}
		}
	}

}
