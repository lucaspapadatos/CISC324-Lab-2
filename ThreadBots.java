import java.text.BreakIterator;

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
	
	public static int passToHash(String s) {
		String challenge = ThreadAttacker.challenge;
		String tempx = s + challenge; // add challenge string to password attempt
		int r_ = tempx.hashCode(); // create new hash code
		return r_;
	}

	public static void compareHash(int r_) {
		//Returns true if both hash values are the same
		int r = ThreadAttacker.captured;
		if (r == r_) {
			ThreadAttacker.found = true;
		}
		else {
			ThreadAttacker.found = false;
		}
	}

	public static void crack(StringBuilder sb, int n) {
		if (ThreadAttacker.found) return;
		if (n == sb.length()) {
			int r = passToHash(sb.toString());
			compareHash(r);
			return;
		}
		for (int i = 0; i < ThreadAttacker.alphabet.length; i++) {
			char letter = ThreadAttacker.alphabet[i];
			sb.setCharAt(n, letter);
			System.out.println(sb);
			ThreadAttacker.attempts++;
			crack(sb, n + 1);
		}
	}

	public void run()
	{
		System.out.println("Thread ["+init_char+"] initiating...");
		StringBuilder pass = new StringBuilder(init_char+"");
		System.out.println(pass);
		pass.setLength(5);
		crack(pass, 1);
		System.out.println(ThreadAttacker.attempts);
	}

}
