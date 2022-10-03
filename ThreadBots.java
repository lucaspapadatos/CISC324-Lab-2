import java.util.concurrent.TimeUnit;

//The content of this file defines a Java class named 'ThreadBot' 
//This class inherits from the predefined Java class Thread.

public class ThreadBots extends Thread
{
	int Identity; //This integer variable will be the thread identifier
  	char init_char;//This character will be used by each thread as the first letter in the password

	//Here we redefine the default constructor of this class.
	//By default it has no arguments, but in this example
	//We are using two arguments
	public ThreadBots(int id, char c) 
	{
		//Here we retrieve the value of the identity passed by the main class
		Identity = id;
		//Here we retrieve the value of the character passed by the main class
		init_char = c;
	}

	//Returns the hashcode of the concatenated string
	public static int passToHash(String s) {
		String challenge = ThreadAttacker.challenge;
		String tempx = s + challenge; // add challenge string to password attempt
		int r_ = tempx.hashCode(); // create new hash code
		return r_;
	}

	//Compares the hash and recursively 
	public void crack(StringBuilder sb, int n) {
		if (ThreadAttacker.found) return;
		if (n == sb.length()) {
			int r = passToHash(sb.toString());
			if (r == ThreadAttacker.captured) {
				System.out.println("Thread ["+init_char+"] cracked the password!");
				System.out.println("The password is "+sb.toString());
				ThreadAttacker.found = true;
				long duration = System.currentTimeMillis() - ThreadAttacker.START_TIME;
				System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(duration) + "." + duration);
			}
			return;
		}
		for (int i = 0; i < ThreadAttacker.alphabet.length; i++) {
			char letter = ThreadAttacker.alphabet[i];
			sb.setCharAt(n, letter);
			crack(sb, n + 1);
		}
	}

	public void run()
	{
		System.out.println("Thread ["+init_char+"] initiating...");
		StringBuilder pass = new StringBuilder(init_char+"");
		pass.setLength(5);
		crack(pass, 1);
	}

}
