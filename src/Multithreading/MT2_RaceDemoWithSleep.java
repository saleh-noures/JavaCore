package Multithreading;

public class MT2_RaceDemoWithSleep
	{
		public static void main(String[] args)
		{
			Racer2 racer = new Racer2();
		    Thread tortoiseThread = new Thread(racer, "Tortoise");
		    Thread hareThread = new Thread(racer, "Hare");

		    //Race to start. tell threads to start
		    tortoiseThread.start();
		    hareThread.start();
		}
	}


class Racer2 implements Runnable {

    public String winner;

    public void run()
		{
			for(int distance=1;distance<=100;distance++)
			{
				if (Thread.currentThread().getName().equalsIgnoreCase("Hare") && distance == 50 )
				{
					System.out.println(Thread.currentThread().getName() + " is at distance " + distance);
					try {
						System.out.println("*************Hare is sleepy and he will sleep 5 seconds************");
						Thread.sleep(1000*5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println("Distance Covered by "+Thread.currentThread().getName()+ " is: "+distance +"meters");

				//Check if race is complete if some one has already won
				if (winner == null )
				{
					isRaceWon(distance);
				}
			}
		}

    private void isRaceWon(int totalDistanceCovered)
		{
			if(totalDistanceCovered == 100)
			{
				String winnerName = Thread.currentThread().getName();
				winner = winnerName;
				System.out.println("Winner is :"+winner);
			}
		}
	}
