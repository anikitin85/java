// A character queue interface.
public interface ICharQ {
	
	// Put a character into the queue.
	void put(char ch);
	// Get a character from the queue.
	char get();
	// Reset the queue.
	void reset();
	// Copy a queue of any type.
}