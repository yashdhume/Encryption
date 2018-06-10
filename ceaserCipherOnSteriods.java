import java.io.*;
import java.util.Random;
public class ceaserCipherOnSteriods {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new FileReader(new File("File.txt")));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("CeaserCode.txt")));
		BufferedWriter out2 = new BufferedWriter(new FileWriter(new File("CeaserCipher.txt")));
		Random rnd = new Random();
		int r=0;
		char ch ;
		String line = null;
		String s= "";
		try {
			while((line = in.readLine()) != null){
				for(int i = 0; i < line.length(); i++) {
					r = rnd.nextInt(26);
				   	ch = (char)(line.charAt(i));
				    if (ch >= 'A' && ch <= 'Z')   s += (char)((ch - 'A' + r) % 26 + 'A');
				    else if (ch >= 'a' && ch <= 'z') s += (char)((ch - 'a' + r) % 26 + 'a');
				    else s += ch;
					out.write(String.valueOf(r));
					out.write(" ");
				  }
				out2.write(String.valueOf(s));
			}
			
			out2.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	
}
