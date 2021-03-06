
// A fixed-size queue for characters
class FixedQueue implements ICharQ {
	private char[] q; // this array holds the queue
	private int putloc; // the put index
	private int getloc; // the get index
	
	// Construct an empty queue given its size.
	public FixedQueue(int size) {
		q = new char[size];
		putloc = getloc = 0;
	}
	
	// Put a character into the queue.
	public void put(char ch) {
		if (putloc == q.length) {
			System.out.println(" - Queue is full.");
			return;
		}
		q[putloc++] = ch;
	}
	
	// Get a character from the queue.
	public char get() {
		if (getloc == putloc) {
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}
		return q[getloc++];
	}
	
	// Reset the queue.
	public void reset() {
		putloc = getloc = 0;
	}
}

// A circular queue for characters
class CircularQueue implements ICharQ {
	private char[] q; // this array holds the queue
	private int putloc; // the put index
	private int getloc; // the get index
	
	// Construct an empty queue given its size.
	public CircularQueue(int size) {
		q = new char[size + 1];
		putloc = getloc = 0;
	}
	
	// Put a character into the queue.
	public void put(char ch) {
		/* Queue is full if either putloc is one less than
		   getloc, or if putloc is at the end of the array
		   and getloc is at the beginning. */
		if (putloc + 1 == getloc |
			putloc == q.length - 1 & getloc == 0) {
			System.out.println(" - Queue is full.");
			return;
		}
		q[putloc++] = ch;
		if (putloc == q.length) {
			putloc = 0; // loop back
		}
	}
	
	// Get a character from the queue.
	public char get() {
		if (getloc == putloc) {
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}
		char ch = q[getloc++];
		if (getloc == q.length) {
			getloc = 0; // loop back
		}
		return ch;
	}
	
	// Reset the queue.
	public void reset() {
		putloc = getloc = 0;
	}
}


// A dynamic queue for characters
class DynQueue implements ICharQ {
	private char[] q; // this array holds the queue
	private int putloc; // the put index
	private int getloc; // the get index
	
	// Construct an empty queue given its size.
	public DynQueue(int size) {
		q = new char[size];
		putloc = getloc = 0;
	}
	
	// Put a character into the queue.
	public void put(char ch) {
		if (putloc == q.length) {
			// increase queue size
			char[] t = new char[q.length * 2];
			// copy elements into new queue
			for (int i = 0; i < q.length; i++) {
				t[i] = q[i];
			}
			q = t;
		}
		q[putloc++] = ch;
	}
	
	// Get a character from the queue.
	public char get() {
		if (getloc == putloc) {
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}
		return q[getloc++];
	}
	
	// Reset the queue.
	public void reset() {
		putloc = getloc = 0;
	}
}


// A circular dynamic queue for characters
class CircularDynQueue implements ICharQ {
	private char[] q; // this array holds the queue
	private int putloc; // the put index
	private int getloc; // the get index
	
	// Construct an empty queue given its size.
	public CircularDynQueue(int size) {
		q = new char[size + 1];
		putloc = getloc = 0;
	}
	
	// Put a character into the queue.
	public void put(char ch) {
		/* Queue is full if either putloc is one less than
		   getloc, or if putloc is at the end of the array
		   and getloc is at the beginning. */
		if (putloc + 1 == getloc |
			putloc == q.length - 1 & getloc == 0) {
			// increase queue size
			char[] t = new char[q.length * 2];
			// copy elements into new queue
			int k = 0;
			for (int i = getloc; i < q.length & i != putloc; i++) {
				t[k++] = q[i];
			}
			if (putloc + 1 != q.length) {
				for (int i = 0; i < putloc; i++) {
					t[k++] = q[i];
				}
			}
			putloc = q.length - 1;
			getloc = 0;
			q = t;
		}	
		q[putloc++] = ch;
		if (putloc == q.length) {
			putloc = 0; // loop back
		}
	}
	
	// Get a character from the queue.
	public char get() {
		if (getloc == putloc) {
			System.out.println(" - Queue is empty.");
			return (char) 0;
		}
		char ch = q[getloc++];
		if (getloc == q.length) {
			getloc = 0; // loop back
		}
		return ch;
	}
	
	// Reset the queue.
	public void reset() {
		putloc = getloc = 0;
	}
}



// Demonstrate the ICharQ interface.
class IQDemo {
	public static void main(String[] args) {
		FixedQueue fq = new FixedQueue(10);
		DynQueue dq = new DynQueue(5);
		CircularQueue cq = new CircularQueue(10);
		
		ICharQ iQ;
		char ch;
		int i;
		
		iQ = fq;
		
		// Put some characters into fixed queue.
		for (i = 0; i < 10; i++) {
			iQ.put((char) ('A' + i));
		}
		
		// Show the queue.
		System.out.print("Content of fixed queue: ");
		for (i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();
		
		iQ = dq;
		
		// Put some characters into dynamic queue.
		for (i = 0; i < 10; i++) {
			iQ.put((char) ('Z' - i));
		}
		
		// Show the queue.
		System.out.print("Content of dynamic queue: ");
		for (i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();
		
		iQ = cq;
		
		// Put some characters into circular queue.
		for (i = 0; i < 10; i++) {
			iQ.put((char) ('A' + i));
		}
		
		// Show the queue.
		System.out.print("Content of circular queue: ");
		for (i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println();
		
		// Put more characters into circular queue.
		for (i = 0; i < 20; i++) {
			iQ.put((char) ('A' + i));
		}
		
		// Show the queue.
		System.out.print("Content of circular queue: ");
		for (i = 0; i < 10; i++) {
			ch = iQ.get();
			System.out.print(ch);
		}
		System.out.println("\nStore and consume from" +
							" circular queue.");
		
		// Store and consume from circular queue.
		for (i = 0; i < 20; i++) {
			iQ.put((char) ('A' + i));
			ch = iQ.get();
			System.out.print(ch);
		}
	}
}