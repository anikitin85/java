// On when to use exceptions
import java.io.*;
class ExDemo9b {
	public static void main(String[] args)
		throws IOException {
		if (args.length == 0) {
			System.out.println("Must give filename as first arg.");
			return;
		}
		
		FileInputStream fin;
		try {
			fin = new FileInputStream(args[0]);
		}
		catch (FileNotFoundException e) {
			System.out.println("Can't find the file: " + args[0]);
			return;
		}
		
		DataInputStream din = new DataInputStream(fin);
		try {
			int i;
			for (;;) {
				i = din.readInt();
				System.out.println(i);
			}
		}
		catch (EOFException e) {
			System.out.println("EOF reached.");
		}
		fin.close();
	}
}
