/**AWT   -> Swing
 * 	Choice -> JComboBox
 * Button -> JButton
 * 
 */
package _18_Swing;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class _8_Swing {

	static boolean gyungFlag = false;
	static boolean GuFlag = false;

	public static void main(String[] args) {
		Frame f = new Frame("JComboBox");
		f.setBounds(1000, 100, 600, 300);

		f.setLayout(null);
		// awt 의 choice(목록 상자)
		/*
		 * Choice c = new Choice(); c.setBounds(10,50,100,50);
		 * c.add("월 Monday 1"); c.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) {
		 * 
		 * } }); f.add(c);
		 */

		// swing 의 JChoice
		/*
		 * JComboBox jcb = new JComboBox(); jcb.setBounds(10,150,100,50);
		 * jcb.addItem("월 Monday 1"); jcb.addItem("화 Tuesday 2");
		 * jcb.removeItem("월 Monday 1"); System.out.println(jcb.getItemAt(0));
		 * jcb.addItemListener(new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) {
		 * 
		 * } }); f.add(jcb);
		 */

		final JComboBox city = new JComboBox();
		city.setBounds(10, 150, 100, 50);
		city.addItem("서울 특별시");
		city.addItem("경기도");

		final JComboBox gu = new JComboBox();
		gu.setBounds(100, 150, 100, 50);
		gu.addItem("도봉구");
		gu.addItem("강남구");
		gu.addItem("강북구");
		gu.addItem("강서구");
		gu.setVisible(true);
		
		gu.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ( e.getStateChange() == ItemEvent.SELECTED ){
					GuFlag = true;
				}else {
					GuFlag = false;
				}
			}
		});
		f.add(gu);
		
		

		final JComboBox gyung = new JComboBox();
		gyung.setBounds(100, 150, 100, 50);
		gyung.addItem("용인시");
		gyung.addItem("화성시");
		gyung.setVisible(false);
		gyung.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ( e.getStateChange() == ItemEvent.SELECTED ){
					gyungFlag = true;
				}else {
					gyungFlag = false;
				}
			}
		});
		f.add(gyung);
		

		city.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				
				if ("서울 특별시".equals(e.getItem())) {
					gyung.setVisible(false);
					gu.setVisible(true);

				} else if ("경기도".equals(e.getItem())) {
					gu.setVisible(false);
					gyung.setVisible(true);

				}
				// 중복 호출 문제
				// 하나는 선택상태지만 하나는 선택이 해제되는 상태도 상태가 변경된 것으로 인식
				// 따라서 두번 출력됨 따라서 상태가 SELECTED인 경우만 출력되도록 해야함!!
				if (e.getStateChange() == ItemEvent.SELECTED) {

					JComboBox sel = (JComboBox) e.getSource();
					System.out.println(sel.getSelectedItem());
					
				}

			}
		});
		f.add(city);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});

		f.setVisible(true);

		
		JButton jb = new JButton("선택주소확인");
		
		jb.setBounds(200,200,100,100);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gu.isVisible() == true){
					
					System.out.println("선택 주소 : " + city.getSelectedItem() + " " + gu.getSelectedItem());					
				}else if ( gyung.isVisible() == true){
					System.out.println("선택 주소 : " + city.getSelectedItem() + " " + gyung.getSelectedItem());					
					
				}
			}
		});
		f.add(jb);
	
	
	
	} // end of main

}
