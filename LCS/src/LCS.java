import java.util.ArrayList;
import java.util.Random;

public class LCS {

	public static void main(String[] args) {
		ArrayList<String> dnaList = new ArrayList<>();
		ArrayList<String> lcsList = new ArrayList<>();
		// TODO Auto-generated method stub
		while (true) {
			String name = System.console().readLine();
			switch (name) {
			case "new":
				double length = Math.random() * 100;
				length = length % 20;
				if (length < 6) {
					length = 6;
				}
				String dna1 = randomDNAString((int) length);
				
				length = Math.random() * 100;
				length = length % 20;
				if (length < 6) {
					length = 6;
				}
				String dna2 = randomDNAString((int) length);
				dnaList.add(dna1);
				dnaList.add(dna2);
				System.out.println(dna1);
				System.out.println(dna2);
				break;
			case "quit":
				return;
			case "LCS":
				String lcsString;
				for(int i = 0; i<dnaList.size(); i = i + 2)
				{
					if (dnaList.get(i + 1) != null)
					{
						lcsString = lcs(dnaList.get(i), dnaList.get(i + 1));
						System.out.println("lcsString = " +lcsString);
						lcsList.add(lcsString);
					}
				}
				
				
				break;
			case "print":
				break;
			case "LCS strands.txt":
				break;
			}

		}

	}

	public static String randomDNAString(int dnaLength) {
		Random rand = new Random();
		StringBuilder dna = new StringBuilder();
		for (int i = 0; i < dnaLength; i++) {
			switch (rand.nextInt(4)) {
			case 0:
				dna.append("A");
				break;
			case 1:
				dna.append("C");
				break;
			case 2:
				dna.append("G");
				break;
			case 3:
				dna.append("T");
				break;
			}
		}
		return dna.toString();
	}
	
 
	
	public static String lcs(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
	}
}
