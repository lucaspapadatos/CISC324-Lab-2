1. Thread t_3 cracked the password as it started with the letter v and the password was virus.
2. Threads are comprised of a program counter, register set, and stack. They share resources with each
thread belonging to the same process such as its code section and operating-system resources, files, 
and signals. In normal circumstances, this process would have a single thread that runs three times,
trying all three starting letters. However, since we have multiple threads, it can perform more than 
one of these tasks at a time and search for the four letter configuration with different starting letters.
3. SingleAttacker.java and SingleBots.java is the single-threaded program. Both the multi- and single-
threaded programs were run 10 times. Below is the average execution time from when the main program starts
and when one of the threads has cracked the password.
Single-threaded: 157ms
Multi-threaded: 66ms
4. The multi-threaded program would still be faster as the single-threaded program has to wait for the
thread that checks for 'i' to start the thread that checks for 'v'. Where in the multi-threaded program,
all three threads start at the same time which would end in a faster execution time.