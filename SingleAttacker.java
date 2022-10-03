//The content of this file defines a Java main class named 'SingleAttacker' 
//This class contains the main method from where the whole program (project) 
//starts its execution

public class SingleAttacker {
	//This is the challenge value, you can modify the value if you want
	public static String challenge = "challenge_sequence";
	//This is the password. It is here to help us compute the correct response that corresponds to the challenge
	public static String password = "virus"; 
	//This is the variable that represents the captured response
	public static int captured;
	//This is the variable that will be used by the thread to inform each other that the password has been cracked
	//For instance, if a thread cracks the password, it update the value of this variable to true
	public static boolean found = false;
	//This is the variable that holds all letters of the alphabet for comparison
	public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	//This is the variable that holds the current time when the program starts
	public static long START_TIME = System.currentTimeMillis();

	//The main method, here starts the execution	
	public static void main(String[] args) throws InterruptedException
	{
		//tempx is a temporary string variable that we are using to create the concatenation of the password with the challenge 
		String tempx = password + challenge;
		//Here we create the response by computing the hash of the previously computed string object
		captured = tempx.hashCode();

		//Thread creation and instantiation (three threads are created)
		//Thread triggering (starting the threads)
		SingleBots t_1 = new SingleBots(1, 'i');
		t_1.start();
		t_1.join();
		SingleBots t_2 = new SingleBots(2, 't');
		t_2.start();
		t_2.join();
		SingleBots t_3 = new SingleBots(3, 'v');
		t_3.start();
		t_3.join();
	}

}
