package willStudyContent;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UserData {
	
	String m_Name;
	int m_Number;
	double m_Korean,m_English,m_Total,m_Average;
	
	UserData(String inname, int innum,  double inkor,  double ineng) {
		m_Name = inname;
		m_Number = innum;
		m_Korean = inkor;
		m_English = ineng;
	}
		void setTotal() {
			m_Total = m_Korean+m_English;
		}
		double getTotal() {
			return m_Total;
		}
		void setAverage() {
			m_Average = (m_Korean+m_English)/2;
		}
		double getAverage() {
			return m_Average;
		}
}

public class Sungjuk implements ActionListener{
	
	JTextField text = null;
	JTextField text1 = null;
	JTextField text2 = null;
	JTextField text3 = null;
	JTextField text4 = null;
	JTextField text5 = null;
	JTextField text6 = null;
	JTextField text7 = null;
	JTextField text8 = null;
	JTextField text9 = null;
	JPanel verp = new JPanel();
	JPanel ver2p = new JPanel();
	JPanel ver3p = new JPanel();
	JPanel ver4p = new JPanel();
	JPanel totalp = new JPanel();
	JPanel resultp = new JPanel();
	JLabel resultl = new JLabel();
	JLabel result2l = new JLabel();
	JLabel showl = new JLabel();
	JLabel show2l = new JLabel();
	JLabel printl = new JLabel();
	JLabel print2l = new JLabel();
	JLabel print3l = new JLabel();
	JLabel print4l = new JLabel();
	
	String inname = null;
	int innum, index;
	int cnt = 0;
	double inkor,ineng;
	
	UserData data[] =new UserData[10];
	
	Sungjuk() {
		
		text = new JTextField(10);
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		text3 = new JTextField(10);
		text4 = new JTextField(10);
		text5 = new JTextField(10);
		text6 = new JTextField(10);
		text7 = new JTextField(10);
		text8 = new JTextField(10);
		text9 = new JTextField(10);
		
		JFrame frame = new JFrame(""
				+ ";klkk��� ���α׷�");
		
		frame.setPreferredSize(new Dimension(300,400));
		
		JPanel titlep = new JPanel();
		JPanel inp = new JPanel();
		JPanel changep = new JPanel();
		JPanel printp = new JPanel();
		JPanel exitp = new JPanel();
		JPanel title2p = new JPanel();
		JPanel namep = new JPanel();
		JPanel nump = new JPanel();
		JPanel korp = new JPanel();
		JPanel engp = new JPanel();
		JPanel resultp = new JPanel();
		JPanel title3p = new JPanel();
		JPanel num2p = new JPanel();
		JPanel searchp = new JPanel();
		JPanel showp = new JPanel();
		JPanel name2p = new JPanel();
		JPanel num3p = new JPanel();
		JPanel kor2p = new JPanel();
		JPanel eng2p = new JPanel();
		JPanel keyp = new JPanel();
		JPanel title4p = new JPanel();
		JPanel num4p = new JPanel();
		JPanel search2p = new JPanel();
		JPanel name3p = new JPanel();
		JPanel num5p = new JPanel();
		JPanel kor3p = new JPanel();
		JPanel eng3p = new JPanel();
		JPanel back3p = new JPanel();
		JPanel result2p = new JPanel();
			
		Container contentPane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(contentPane,BoxLayout.Y_AXIS);
		BoxLayout layout2 = new BoxLayout(verp,BoxLayout.Y_AXIS);
		BoxLayout layout3 = new BoxLayout(ver2p,BoxLayout.Y_AXIS);
		BoxLayout layout4 = new BoxLayout(resultp,BoxLayout.X_AXIS);
		BoxLayout layout5 = new BoxLayout(ver3p,BoxLayout.Y_AXIS);
		BoxLayout layout6 = new BoxLayout(ver4p,BoxLayout.Y_AXIS);
		BoxLayout layout7 = new BoxLayout(result2p,BoxLayout.X_AXIS);
		
		contentPane.setLayout(layout);
		verp.setLayout(layout2);
		ver2p.setLayout(layout3);
		resultp.setLayout(layout4);
		ver3p.setLayout(layout5);
		ver4p.setLayout(layout6);
		result2p.setLayout(layout7);
		
		JButton inb = new JButton("����� �� ���� �Է�");
		JButton changeb = new JButton("����� �� ���� ����");
		JButton printb = new JButton("����� �� ���� ���");
		JButton exitb = new JButton("����");
		JButton in2b = new JButton("�Է�");
		JButton backb = new JButton("BACK");
		JButton searchb = new JButton("ã��");
		JButton saveb = new JButton("����");
		JButton back2b = new JButton("BACK");
		JButton search2b = new JButton("�˻�");
		JButton back3b = new JButton("BACK");
		JButton calb = new JButton("����");
		
		inb.addActionListener(this);
		changeb.addActionListener(this);
		printb.addActionListener(this);
		in2b.addActionListener(this);
		backb.addActionListener(this);
		back2b.addActionListener(this);
		back3b.addActionListener(this);
		exitb.addActionListener(this);
		searchb.addActionListener(this);
		search2b.addActionListener(this);
		saveb.addActionListener(this);
		calb.addActionListener(this);
		
		titlep.add(new JLabel("�޴����� �����ϼ���",SwingConstants.CENTER));
		titlep.setPreferredSize(new Dimension(300,50));
		inp.add(inb);
		inp.setPreferredSize(new Dimension(300,70));
		changep.add(changeb);
		changep.setPreferredSize(new Dimension(300,70));
		printp.add(printb);
		printp.setPreferredSize(new Dimension(300,70));
		exitp.add(exitb);
		exitp.setPreferredSize(new Dimension(300,70));
		
		verp.add(titlep);
		verp.add(inp);
		verp.add(changep);
		verp.add(printp);
		verp.add(exitp);
		
		title2p.add(new JLabel("����� �� ���� �Է�"));
		title2p.setPreferredSize(new Dimension(300,50));
		
		namep.add(new JLabel("�̸� : "));
		namep.add(text);
		namep.setPreferredSize(new Dimension(300,50));
		
		nump.add(new JLabel("�й� : "));
		nump.add(text1);
		nump.setPreferredSize(new Dimension(300,50));
		
		korp.add(new JLabel("���� : "));
		korp.add(text2);
		korp.setPreferredSize(new Dimension(300,50));
		
		engp.add(new JLabel("���� : "));
		engp.add(text3);
		engp.setPreferredSize(new Dimension(300,50));

		resultp.add(new JLabel("��ü : "));
		resultp.add(resultl);
		resultp.add(new JLabel("                          "));
		resultp.add(new JLabel("��� : "));
		resultp.add(result2l);
		resultp.setPreferredSize(new Dimension(300,50));
		
		result2p.add(in2b);
		result2p.add(new JLabel("                        "));
		result2p.add(backb);
		
		ver2p.add(title2p);
		ver2p.add(namep);
		ver2p.add(nump);
		ver2p.add(korp);
		ver2p.add(engp);
		ver2p.add(resultp);
		ver2p.add(result2p);
		
		title3p.add(new JLabel("����� �� ���� ����"));
		title3p.setPreferredSize(new Dimension(300,50));
		
		num2p.add(new JLabel("�й� : "));
		num2p.add(text4);
		num2p.setPreferredSize(new Dimension(300,50));
		
		searchp.add(searchb);
		
		showp.add(new JLabel("�̸� : "));
		showp.add(showl);
		showp.add(new JLabel("�й� : "));
		showp.add(show2l);

		name2p.add(new JLabel("�̸� : "));
		name2p.add(text5);
		
		num3p.add(new JLabel("�й� : "));
		num3p.add(text6);
		
		kor2p.add(new JLabel("���� : "));
		kor2p.add(text7);
		
		eng2p.add(new JLabel("���� : "));
		eng2p.add(text8);
		
		keyp.add(saveb);
		keyp.add(new JLabel("                        "));
		keyp.add(back2b);

		ver3p.add(title3p);
		ver3p.add(num2p);
		ver3p.add(searchp);
		ver3p.add(showp);
		ver3p.add(name2p);
		ver3p.add(num3p);
		ver3p.add(kor2p);
		ver3p.add(eng2p);
		ver3p.add(keyp);
				
		title4p.add(new JLabel("����� �� ���� ���"));
		title4p.setPreferredSize(new Dimension(300,50));
		
		num4p.add(new JLabel("�й� : "));
		num4p.add(text9);
		
		search2p.add(search2b);
		
		name3p.add(new JLabel("�̸� : "));
		name3p.add(printl);
		num5p.add(new JLabel("�й� : "));
		num5p.add(print2l);
		kor3p.add(new JLabel("���� : "));
		kor3p.add(print3l);
		eng3p.add(new JLabel("���� : "));
		eng3p.add(print4l);
		eng3p.setPreferredSize(new Dimension(300,50));
		
		back3p.add(back3b);
		
		ver4p.add(title4p);
		ver4p.add(num4p);
		ver4p.add(search2p);
		ver4p.add(name3p);
		ver4p.add(num5p);
		ver4p.add(kor3p);
		ver4p.add(eng3p);
		ver4p.add(back3p);
		
		totalp.add(verp);
		contentPane.add(totalp);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
			Sungjuk a = new Sungjuk();
	}
	
	public void actionPerformed(ActionEvent b) {
		
		String menu = b.getActionCommand();
		
		if (menu.equals("����� �� ���� �Է�")){
			totalp.removeAll();
			totalp.add(ver2p);
			totalp.updateUI();
		}
		if (menu.equals("����� �� ���� ����")){
			totalp.removeAll();
			totalp.add(ver3p);
			totalp.updateUI();
		}
		if (menu.equals("����� �� ���� ���")) { 
			totalp.removeAll();
			totalp.add(ver4p);
			totalp.updateUI();
		}
		if (menu.equals("����")) {
			System.exit(0);
		}
		if (menu.equals("BACK")) {
			totalp.removeAll();
			totalp.add(verp);
			totalp.updateUI();
			resultl.setText("");
			result2l.setText("");
			printl.setText("");
			print2l.setText("");
			print3l.setText("");
			print4l.setText("");			
		}
		if (menu.equals("�Է�")) {
			if(cnt<10){
				inname = text.getText();
				innum = Integer.parseInt(text1.getText());				
				inkor = Double.parseDouble(text2.getText());				
				ineng = Double.parseDouble(text3.getText());
				
				data[cnt] = new UserData(inname,innum,inkor,ineng);
				data[cnt].setTotal();
				data[cnt].setAverage();
				
				double temp = data[cnt].getTotal();
				double temp2=data[cnt].getAverage();
				String s = Double.toString(temp);
				String t = Double.toString(temp2); 
				
				resultl.setText(s);
				result2l.setText(t);
				
				cnt++;
			}
			
			text.setText("");
			text1.setText("");
			text2.setText("");
			text3.setText("");
		}
		
		if (menu.equals("ã��")) {
			
			for(int i = 0;i<cnt;i++) {
				if(data[i].m_Number == Integer.parseInt(text4.getText())) {
					showl.setText(data[i].m_Name);
					int show = data[i].m_Number;
					String sshow = Integer.toString(show);
					show2l.setText(sshow);
					index = i;
				}
			}
			
			text4.setText("");
		}	
		if (menu.equals("����")) {
			data[index].m_Name = text5.getText();
			data[index].m_Number = Integer.parseInt(text6.getText());
			data[index].m_Korean = Double.parseDouble(text7.getText());
			data[index].m_English = Double.parseDouble(text8.getText());
			text5.setText("");
			text6.setText("");
			text7.setText("");
			text8.setText("");
		}

		if (menu.equals("�˻�")) {
//			int num2 = Integer.parseInt(text9.getText());
			for(int k = 0;k<cnt;k++) {
				if (data[k].m_Number==Integer.parseInt(text9.getText())) {
					printl.setText(data[k].m_Name);
					int print2 = data[k].m_Number;
					String sprint2 =	Integer.toString(print2);
					print2l.setText(sprint2);
					double print3 = data[k].m_Korean;
					String sprint3 = Double.toString(print3);
					print3l.setText(sprint3);
					double print4 = data[k].m_English;
					String sprint4 = Double.toString(print4);
					print4l.setText(sprint4);
				}
			}
			text9.setText("");
		}
	}
}