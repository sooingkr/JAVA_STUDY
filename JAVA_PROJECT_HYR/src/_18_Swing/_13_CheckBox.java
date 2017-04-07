package _18_Swing;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

/**
 * Checkbox : 하나만 선택(라디오버튼) or 여러개 선택 (체크박스)
 */
public class _13_CheckBox {
	static String title = "";
	public static void main(String[] args) {
		Frame f = new Frame("Checkbox 활용");
		f.setBounds(1000, 100, 1000, 1000);
		f.setLayout(null);
		System.out.println("테스트");
		Checkbox cb1 = new Checkbox("사과");
		Checkbox cb2 = new Checkbox("딸기", false);
		Checkbox cb3 = new Checkbox("수박", true);
		cb1.setBounds(50, 50, 100, 100);
		cb2.setBounds(50, 150, 100, 100);
		cb3.setBounds(50, 250, 100, 100);
		// cb1.getLabel(); // 라벨(문자열) 읽어오기
		// cb1.getState(); // 체크 상태 읽어오기
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);

		//////////////////////////////////////////////////////
		// 단일 선택만 가능하게 => 라디오 버튼
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox cb4 = new Checkbox("해운대", cg, false);
		Checkbox cb5 = new Checkbox("겨울왕국", cg, false);
		Checkbox cb6 = new Checkbox("뽀로로", cg, true);
		cb4.setBounds(150, 50, 100, 100);
		cb5.setBounds(150, 150, 100, 100);
		cb6.setBounds(150, 250, 100, 100);

		f.add(cb4);
		f.add(cb5);
		f.add(cb6);

		JButton j1 = new JButton("선택");
		j1.setBounds(40, 350, 60, 60);
		f.add(j1);

		JButton j2 = new JButton("선택");
		j2.setBounds(120, 350, 60, 60);
		f.add(j2);

		
		// 체크박스 상태가 변경되었을 때
		
		class MyItemEvent implements ItemListener {
			// 재사용위해서...(반복 코드줄이기 위해)
			@Override
			public void itemStateChanged(ItemEvent e) { // 상태변경시 호출되는 콜백 메서드
				Checkbox c = (Checkbox)e.getSource();
				System.out.println(c.getLabel() + " " + c.getState());
			}
		}
		
		MyItemEvent me = new MyItemEvent(); // 이벤트 처리할 객체 생성
		
		cb4.addItemListener(me);
		cb5.addItemListener(me);
		cb6.addItemListener(me);
		/*cb4.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				
					f.setTitle(cb4.getLabel() + " " + cb4.getState());
				
			}
		});
		cb5.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				f.setTitle(cb5.getLabel() + " " + cb5.getState());
				
			}
		});
		cb6.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				f.setTitle(cb6.getLabel() + " " + cb6.getState());
				
			}
		});*/
		
		
		
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				title = "";
				if ( cb1.getState() ){
					title += (cb1.getLabel() + " ");
				}
				if ( cb2.getState() ){
					title += (cb2.getLabel() + " ");
				}
				if ( cb3.getState() ){
					title += (cb3.getLabel() + " ");
				}
				f.setTitle(title);
				
			}
		});
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Checkbox c = cg.getSelectedCheckbox();
				System.out.println("선택한 값 : " + c.getLabel());
				f.setTitle(c.getLabel());
			}
		});

		////////////////////////////////////////////////
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		f.setVisible(true);
	} // end of main
} // end of class
