// Return where?
class NumberExpDemo {
	public static void main(String[] args) {
		int temp = 0;
		if (args.length > 0) {
			try {
				temp = Integer.parseInt(args[0]);
			}
			catch (NumberFormatException exc) {
				System.out.println("1st argument must be integer.");
				return;
			}
		}
		else {
			System.out.println("1st argument must be temperature.");
			return;
		}
	}
}
