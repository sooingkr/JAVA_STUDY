package _18_Swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _27_ThreadShow {
	
	static int r,g,b; // 0 ~ 255
	
	public static void main(String[] args) {
		Frame f = new Frame("색상 변경");
		f.setBounds(1000,100,400,400);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		
		f.setBackground(new Color(r,g,b));
		f.setVisible(true);
	
		ChangeR cr = new ChangeR();
		cr.start(); // 쓰레드 시작
		ChangeG cg = new ChangeG();
		cg.start(); // 쓰레드 시작
		ChangeB cb = new ChangeB();
		cb.start(); // 쓰레드 시작
	
		while(true) {
			
			f.setBackground(new Color(r,g,b));
	
		}
		
		
	} // end of main
} // end of class

class ChangeR extends Thread{
	
	int add = 1;
	
	@Override
	public void run() {
		while(true) {
			//_27_ThreadShow.r++; // 범위넘었을 때 얘 수행하다가 아래 수행못하고 수행흐름이 넘어갈 수 있음 : 동기화 신경 써줘야 함
			// 따라서 아래처럼 해주거나 동기화 맞추어 주어야함
			
			int r = _26_Login.r;
			
			r+=add;
			if(r>255){
				r = 255;
				add = -add;
			}else if (r<0){
				r=0;
				add = -add;
			}
			_26_Login.r = r;
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {}
		}
	}
}

class ChangeG extends Thread{
	@Override
	public void run() {
		while(true) {
			
			int g = _26_Login.g;
			g+=2;
			if(g>255)g=0;
			_26_Login.g = g;
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
		}
	}
}

class ChangeB extends Thread{
	@Override
	public void run() {
		while(true) {
			int b = _26_Login.b;
			b+=3;
			if(b>255)b=0;
			_26_Login.b = b;
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
		}
	}
}