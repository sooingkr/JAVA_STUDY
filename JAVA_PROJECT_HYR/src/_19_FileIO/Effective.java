package _19_FileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * 성능향상 보조스트림
 */
public class Effective {

   public static void main(String[] args) throws Exception {
      
      InputStream is = new FileInputStream("C:\\DEV\\kosta\\Koala.jpg");
      BufferedInputStream bis = new BufferedInputStream(is); // 
      OutputStream os = new FileOutputStream("C:\\DEV\\kosta\\Koala3.jpg");
      
      long startTime = System.currentTimeMillis();
      while(true){
         int readCnt = bis.read();
         if(readCnt == -1) break;
         os.write(readCnt);
      }
      System.out.println(System.currentTimeMillis() - startTime + "ms");
      
      
      os.flush();
      os.close();
      
      bis.close(); // close 가장 나중에 열었던거 먼저 닫아준다. 개발권장사항 익센션발생을 줄이기 위하여
      is.close();
      
      ////////////////////////////////
      // 성능향상 보조스트림을 사용하기
      
      InputStream is2 = new FileInputStream("C:\\DEV\\kosta\\Koala.jpg");
      BufferedInputStream bis2 = new BufferedInputStream(is2); // 
      OutputStream os2 = new FileOutputStream("C:\\DEV\\kosta\\Koala32.jpg");
      BufferedOutputStream bos2 = new BufferedOutputStream(os2); // 성능향상 보조스트림
      long startTime2 = System.currentTimeMillis();
      while(true){
         int readCnt = bis2.read();
         if(readCnt == -1) break;
         bos2.write(readCnt);
      }
      System.out.println(System.currentTimeMillis() - startTime2 + "ms");
      
      
      bos2.flush();
      bos2.close();
      os2.close();
      bis2.close(); // close 가장 나중에 열었던거 먼저 닫아준다. 개발권장사항 익센션발생을 줄이기 위하여
      is2.close();
      
      ////////////////////////////////////////////////////
      
      long start = System.currentTimeMillis();
         FileInputStream fis = null;
         FileOutputStream fos = null;

         FileChannel in = null;
         FileChannel out = null;
         try {
            fis = new FileInputStream("C:\\DEV\\kosta\\Koala.jpg");
            fos = new FileOutputStream("C:\\DEV\\kosta\\Koala5.jpg");

            in = fis.getChannel();
            out = fos.getChannel();
            in.transferTo(0, in.size(), out);

         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            // 클로즈들..........
            out.close();
            in.close();
         }
         System.out.println(System.currentTimeMillis() - start + "ms");
      
      
      
      
   } // end of main
   
} // end of class