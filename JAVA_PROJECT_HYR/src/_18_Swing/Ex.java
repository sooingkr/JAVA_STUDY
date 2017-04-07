package _18_Swing;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 * 회원가입 프로그램
 */
public class Ex {
   // 가입한 회원 정보 저장
   static ArrayList<Member> al = new ArrayList<Member>();

   public static void main(String[] args) {
      // Frame 생성
      Frame f = new Frame("회원가입");
      f.setBounds(50, 50, 600, 600);
      f.setLayout(null);
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) { // 닫기 버튼 누를시
            f.dispose();
         }
      });
      //////////////////////////////////////////////////////////////////////
      Font font = new Font("바탕", Font.BOLD, 40);// 폰트 객체 생성
      // title 설정
      Label title = new Label("NAVER");
      title.setBounds(120, 50, 350, 50);
      title.setAlignment(1);
      title.setForeground(Color.GREEN);
      title.setFont(font);
      f.add(title);
      // ID
      TextField idField = new TextField("아이디");
      idField.setBounds(120, 100, 350, 50);
      idField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
            
         }
         
         @Override
         public void focusGained(FocusEvent e) {
            idField.setText("");
            
         }
      });
      f.add(idField);
      
      // PWD
      TextField pwdField = new TextField("비밀번호");
      pwdField.setBounds(120, 150, 350, 50);
      pwdField.setEchoChar('*');
      
      pwdField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
         }
         
         @Override
         public void focusGained(FocusEvent e) {
            pwdField.setText("");
            
         }
      });
      f.add(pwdField);
      // PWD reCheck
      TextField pwdReField = new TextField("비밀번호 재확인");
      pwdReField.setBounds(120, 200, 350, 50);
      pwdReField.setEchoChar('*');
      pwdReField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
            
         }
         
         @Override
         public void focusGained(FocusEvent e) {
            pwdReField.setText("");
            
         }
      });
      f.add(pwdReField);
      // 이름
      TextField nameField = new TextField("이름");
      nameField.setBounds(120, 280, 350, 50);
      nameField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
            
         }
         
         @Override
         public void focusGained(FocusEvent e) {
            nameField.setText("");
            
         }
      });
      f.add(nameField);
      // 성별
      ButtonGroup bg = new ButtonGroup();
      JRadioButton radio1 = new JRadioButton("남자", true);
      radio1.setBounds(120, 330, 180, 50);
      radio1.setHorizontalAlignment(SwingConstants.CENTER);
      bg.add(radio1);
      f.add(radio1);

      JRadioButton radio2 = new JRadioButton("여자");
      radio2.setBounds(300, 330, 170, 50);
      radio2.setHorizontalAlignment(SwingConstants.LEFT);
      bg.add(radio2);
      f.add(radio2);
      /////////////////////////////////////////////////////////////////
      // 생일
      Label birthLabel = new Label("생일", Label.CENTER);
      birthLabel.setBounds(120, 390, 50, 40);
      f.add(birthLabel);
      // 년(4자)
      TextField year = new TextField();
      year.setBounds(170, 390, 100, 40);
      year.setText("년(4자리)");
      year.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
         }
         
         @Override
         public void focusGained(FocusEvent e) {
            year.setText("");
            
         }
      });
      f.add(year);
      // 월(JComboBox) or Choice
      final JComboBox month = new JComboBox();
      month.setBounds(270, 390, 100, 40);
      month.addItem("월");
      for (int i = 1; i <= 12; i++) {
         month.addItem(i + "");
      }
      f.add(month);
      // 일 (JComboBox) or Choice
      JComboBox day = new JComboBox();
      day.setBounds(370, 390, 100, 40);
      // day.setBackground(Color.YELLOW);
      day.addItem("일");
      for (int i = 1; i <= 31; i++) {
         day.addItem(i + "");
      }
      f.add(day);
      /////////////////////////////////////////////////////////
      // 회원가입하기 버튼을 눌렀을 경우 다이얼로그 생성
      Label msg = new Label("회원가입하시겠습니까?", Label.CENTER);
      final Dialog reCheck = new Dialog(f, "회원가입 확인", true);
      reCheck.setSize(200, 120);
      reCheck.setLocation(250, 250);
      reCheck.setLayout(new FlowLayout());
      reCheck.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {// 다이얼로그 닫기 버튼 누를시
            reCheck.dispose();
         }
      });

      // 다이얼로그에서 ok누름
      JButton ok = new JButton("OK");
      ok.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // 아이디가 비어있거나 아이디라고 써있을 경우
            if ("".equals(idField.getText()) || "아이디".equals(idField.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "아이디를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 비밀번호가 비어있거나 비밀번호라고 써있을 경우
            if ("".equals(pwdField.getText()) || "비밀번호".equals(pwdField.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "비밀번호를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 비밀번호 재확인란이 비어있거나 비밀번호 재확인이라고 써있을 경우
            if ("".equals(pwdReField.getText()) || "비밀번호 재확인".equals(pwdReField.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "비밀번호 재확인란에 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 처음 입력한 비밀번호와 재 입력한 비밀번호가 다를경우
            if (!pwdField.getText().equals(pwdReField.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "비밀번호가 일치하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 이름이 비어있거나 이름이라고 써있을 경우
            if ("".equals(nameField.getText()) || "이름".equals(nameField.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "이름을 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 태어난 년도가 비어있거나 년(4자리)라고 써있을 경우
            if ("".equals(year.getText()) || "년(4자리)".equals(year.getText())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "태어난 년도를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 태어난 달이 비어있거나 월이라고 써있을 경우
            if ("".equals(month.getSelectedItem()) || "월".equals(month.getSelectedItem())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "태어난 달을 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }
            // 태어날 날짜가 비어있거나 일이라고 써있을 경우
            if ("".equals(day.getSelectedItem()) || "일".equals(day.getSelectedItem())) {
               // 경고창 출력
               JOptionPane.showMessageDialog(f, "태어난 날짜를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
               reCheck.dispose();
               return;
            }

            Enumeration enums = bg.getElements();
            String str = "";
            while (enums.hasMoreElements()) {
               JRadioButton jb = (JRadioButton) enums.nextElement();
               if (jb.isSelected()) { // 성별란에서 선택되어 있는 경우
                  str = jb.getText();
               }
            }
            String id = idField.getText();
            String pwd = pwdField.getText();
            String name = nameField.getText();
            String yearData = year.getText();
            String monthData = (String) month.getSelectedItem();
            String dayData = (String) day.getSelectedItem();

            al.add(new Member(id, pwd, name, str, yearData, monthData, dayData));

            String s = "ID: " + id + "\nPW: " + pwd + "\nName: " + name + "\n성별: " + str + "\nYY / MM / DD: "
                  + yearData + " / " + monthData + " / " + dayData;
            JOptionPane.showMessageDialog(f, s + "\n회원가입을 완료하였습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);

            reCheck.dispose();// 다이얼로그 닫기
         }
      });
      ////////////////////////////////////////////////////////////
      // 가입하기 버튼
      JButton subscribe = new JButton("가입하기");
      subscribe.setBounds(120, 450, 350, 40);
      subscribe.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            reCheck.add(msg);
            reCheck.add(ok);
            reCheck.setVisible(true);
         }
      });
      f.add(subscribe);

      JButton result = new JButton("가입한 회원 목록");
      result.setBounds(120, 490, 350, 40);
      f.add(result);
      result.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            if (al.size() == 0) {
               JOptionPane.showMessageDialog(f, "가입한 회원 목록이 없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
               reCheck.dispose();
            }
            for (int i = 0; i < al.size(); i++) {
               Member temp = al.get(i);
               System.out.println(temp.id + " " + temp.pwd + " " + temp.name + " " + temp.sex + " " + temp.year
                     + " " + temp.month + " " + temp.day);
            }
         }
      });

      f.setVisible(true);

   }// end of main
}// end of class

class Member { // 회원가입한 정보 저장 객체
   String id = "";
   String pwd = "";
   String name = "";
   String sex = "";
   String year;
   String month;
   String day;

   public Member(String id, String pwd, String name, String sex, String year, String month, String day) {
      super();
      this.id = id;
      this.pwd = pwd;
      this.name = name;
      this.sex = sex;
      this.year = year;
      this.month = month;
      this.day = day;
   }

   public Member() {
   }

}