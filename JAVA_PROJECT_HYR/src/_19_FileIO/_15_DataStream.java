/**
 * 		기본형 타입의 입출력을 지원하는 보조스트림
 * 		DataInputStream
 * 		DataOutputStream
 * 
 */
package _19_FileIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class _15_DataStream {

	public static void main(String[] args) {
		OutputStream os = null;
		DataOutputStream dos = null;
		InputStream is = null;
		DataInputStream dis = null;

		try {
			os = new FileOutputStream("C:\\DEV\\kosta\\one.dat"); // 객체 저장을 위한
																	// 파일 생성
			dos = new DataOutputStream(os);
			try {
				dos.writeUTF("황영롱");
			} catch (IOException e) {
			}
			dos.writeInt(28);
			dos.writeLong(9003171081716l);
			dos.writeBoolean(true);

			is = new FileInputStream("C:\\DEV\\kosta\\one.dat");
			dis = new DataInputStream(is);
			String name = dis.readUTF();
			int age = dis.readInt();
			long jumin = dis.readLong();
			boolean flag = dis.readBoolean();
			System.out.println(name + " : " + age + " : " + jumin + " : " + flag);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {

		} finally {
			if (dos != null) {
				try {
					dos.flush();
					dos.close();
				} catch (IOException e) {
				}
			}
			if (dis != null) {
				try {
					
					dis.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
