
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class xorEncyption {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file you want to encrypt: ");
		String fName = scan.nextLine();
		String[] tokens = fName.split(".")
		String fNameOut = tokens[0] + "_encrypted." + tokens[tokens.length-1];
		
		FileInputStream inputStream = new FileInputStream(fName);
		//byte size = (byte) inputStream.getChannel().size();
		byte[] bufferIn = new byte[1000000];
		int total = 0;
		int nRead = 0;
		while ((nRead = inputStream.read(bufferIn)) != -1) {
			System.out.println(new String(bufferIn));
			total += nRead;
		}

		inputStream.close();
		System.out.println("Enter a key ");
		char[] key = scan.next().toCharArray();
		String bytes = (encrpty(bufferIn, total, key));
		byte[] buffer = bytes.getBytes();

		FileOutputStream outputStream = new FileOutputStream(fNameOut);
		outputStream.write(buffer);

		outputStream.close();

		System.out.println("Wrote " + buffer.length + " bytes");

	}

	private static String encrpty(byte[] bufferIn, int total, char[] key) {
		StringBuilder cipher = new StringBuilder();
		for (int i = 0; i < total; i++) {
			cipher.append((char) (bufferIn[i] ^ key[i % key.length]));
		}
		return cipher.toString();

	}

}
