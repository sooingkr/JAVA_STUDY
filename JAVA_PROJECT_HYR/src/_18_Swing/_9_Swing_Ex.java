package _18_Swing;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Choice => JComboBox
 */
public class _9_Swing_Ex {
   static String str = "";

   public static void main(String[] args) {
      Frame f = new Frame("JComboBox");
      f.setBounds(100, 100, 600, 300);
      f.setLayout(null);

      final JComboBox jcb = new JComboBox();
      jcb.setBounds(10, 50, 100, 50);
      f.add(jcb);

      final JComboBox jcb2 = new JComboBox();
      jcb2.setBounds(150, 50, 100, 50);
      f.add(jcb2);

      final JComboBox jcb3 = new JComboBox();
      jcb3.setBounds(300, 50, 100, 50);
      f.add(jcb3);

      String si[] = { "서울시", "인천시", "부산시" };
      String gu[][] = { { "강남구", "강북구" }, { "동구", "서구" }, { "남구", "북구" } };
      String dong[][][] = { { { "1동", "2동" }, { "3동", "4동" } }, { { "5동", "6동" }, { "7동", "8동" } },
            { { "9동", "a동", "b동" }, { "c동", "d동", "e동", "f동" } } };

      for (int i = 0; i < si.length; i++) {
         jcb.addItem(si[i]);
      }
      
//      for (int i = 0; i < gu[0].length; i++) {
//         jcb2.addItem(gu[0][i]);
//      }
//      for (int i = 0; i < dong[0][0].length; i++) {
//         jcb3.addItem(dong[0][0][i]);
//      }
//      for (int i = 0; i < si.length; i++) {
//         jcb.addItem(si[i]);
//      }
      
      jcb.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            int siIndex = jcb.getSelectedIndex();
            // si에 해당되는 구를 jcb2의 목록으로 등록
            jcb2.removeAllItems();
            for (int i = 0; i < gu[siIndex].length; i++) {
               jcb2.addItem(gu[siIndex][i]);
            }
         }
      });

//      jcb.addItemListener(new ItemListener() {
//         @Override
//         public void itemStateChanged(ItemEvent e) {
//            if (e.getStateChange() == ItemEvent.SELECTED) {// 선택됐을때
//               // 선택한 si의 index를 얻어오기
//               int siIndex = jcb.getSelectedIndex();
//               // si에 해당되는 구를 jcb2의 목록으로 등록
//               jcb2.removeAllItems();
//               for (int i = 0; i < gu[siIndex].length; i++) {
//                  jcb2.addItem(gu[siIndex][i]);
//               }
//            }
//
//         }
//      });

      jcb2.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               // 시, 구 선택항목의 index를 얻어오기
               int siIndex = jcb.getSelectedIndex();
               int guIndex = jcb2.getSelectedIndex();
               // 동의 목록을 jcb3에 등록하기
               jcb3.removeAllItems();
               for (int i = 0; i < dong[siIndex][guIndex].length; i++) {
                  jcb3.addItem(dong[siIndex][guIndex][i]);
               }
            }
         }
      });

      JButton jb = new JButton("선택완료");
      jb.setBounds(100, 150, 100, 50);
      f.add(jb);
      jb.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            int siIndex = jcb.getSelectedIndex();
            int guIndex = jcb2.getSelectedIndex();
            int dongIndex = jcb3.getSelectedIndex();

            if (guIndex == -1 || dongIndex == -1) {
               System.out.println("주소를 선택하세요");
               return;
            }
            System.out.println("선택한 주소\n" + si[siIndex] + " " + gu[siIndex][guIndex] + " "
                  + dong[siIndex][guIndex][dongIndex]);

         }
      });

      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            f.dispose();
         }
      });

      f.setVisible(true);
   }// end of main
}// end of class