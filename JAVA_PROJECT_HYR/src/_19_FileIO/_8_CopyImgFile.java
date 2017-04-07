package _19_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _8_CopyImgFile {

	public static void main(String[] args) throws IOException {

		FileInputStream fs = null;
		FileInputStream fs2 = null;
		FileOutputStream fo = null;
		FileOutputStream fo2 = null;
		byte[] temp1 = new byte[1024];
		byte[] temp2 = new byte[1024];
		try {

			fs = new FileInputStream("C:\\DEV\\kosta\\Koala.jpg");
			fs2 = new FileInputStream("C:\\DEV\\kosta\\good.txt");
			fo = new FileOutputStream("C:\\DEV\\kosta\\good2.txt");
			fo2 = new FileOutputStream("C:\\DEV\\kosta\\Koala2.jpg");

			int read = fs.read(temp2, 0, temp2.length);
			fo2.write(temp2,0,read);

		} catch (FileNotFoundException e) {

		} finally {
			fs.close();
		}

		while (true) {
			int read2 = fs2.read();
			if (read2 == -1)
				break;
			fo.write(read2);
		}
	}

}
