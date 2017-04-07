/**
 * 		[	List : 목록 보여주는 컴포넌트  ] : (JComboBox, Choice)와 달리 처음부터 펼쳐진 목록 상자
 * 
 */
package _18_Swing;

import java.awt.Frame;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _10_List {

	public static void main(String[] args) {
		Frame f = new Frame("List 활용");
		f.setBounds(600,100,300,400);
		f.setLayout(null);
		List l = new List();
		List l2 = new List(4, true);
		// rows : 처음 보여질 목록 개수(한번에 보여질 수 있는 행의 개수)
		// multipleMode : 다중선택(true) / 단일선택(false)
		l2.setBounds(100,100,100,100);
		l2.add("월mon1");
		l2.add("sun");
		l2.add("tue");
		l2.add("wen");
		l2.add("thu");
		l2.add("fri");
		l2.add("satur");
		
		l2.replaceItem("sat", 3);
		l2.remove(4); // 해당 인덱스 삭제
		// l2.removeAll();
		l2.select(1); // default 선택되어 있도록 설정
		// l2.deselect(1); // 선택취소하기
		l2.getSelectedItem();
		l2.getSelectedIndex();
		String[] selects = l2.getSelectedItems(); // multipleMode = true시 다중 선택한 값들
		int[] indexs = l2.getSelectedIndexes();
		//l2.isSelected(2); // 해당 인덱스 목록이 선택되었는지 리턴
		l2.isIndexSelected(2); // 위에거가 deprecated되어서...
		l2.getRows(); // 한번에 보여지는 행의 수 반환
		
		f.add(l2);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		f.setVisible(true);
	}

}
