package _20_Network_Chatting.ex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

   private JPanel contentPane;
   private JTextField textField; // ���� �޼��� ���°�

   private String id;
   private String ip;
   private int port;

   JButton sendBtn; // ���۹�ư
   JTextArea textArea; // ���ŵ� �޼����� ��Ÿ�� ����

   private Socket socket; // �������
   private InputStream is;
   private OutputStream os;
   private DataInputStream dis;
   private DataOutputStream dos;

   public MainView(String id, String ip, int port)// ������
   {
      this.id = id;
      this.ip = ip;
      this.port = port;

      init();
      start();

      textArea.append(" ID : " + id + "\n ���� IP : " + ip + "\n ���� PORT : " + port + "\n");

      network();

   }

   public void network() {
      // ������ ����
      try {
         socket = new Socket(ip, port);
         if (socket != null) // socket�� null���� �ƴҶ� ��! ����Ǿ�����
         {
            Connection(); // ���� �޼ҵ带 ȣ��
         }
      } catch (UnknownHostException e) {

      } catch (IOException e) {
         textArea.append("���� ���� ����\n");
      }

   }

   public void Connection() { // ���� ���� �޼ҵ� ����κ�

      try { // ��Ʈ�� ����
         is = socket.getInputStream();
         dis = new DataInputStream(is);

         os = socket.getOutputStream();
         dos = new DataOutputStream(os);

      } catch (IOException e) {
         textArea.append("��Ʈ�� ���� ����\n");
      }

      send_Message(id); // ���������� ����Ǹ� ���� id�� ����

      Thread th = new Thread(new Runnable() { // �����带 ������ �����κ��� �޼����� ����

               
               public void run() {
                  while (true) {

                     try {
                        String msg = dis.readUTF(); // �޼����� �����Ѵ�
                        textArea.append(msg + "\n");
                        
                     } catch (IOException e) {
                        textArea.append("�޼��� ���� ����\n");
                        // ������ ���� ��ſ� ������ ������ ��� ������ �ݴ´�
                        try {
                           os.close();
                           is.close();
                           dos.close();
                           dis.close();
                           socket.close();
                           break; // ���� �߻��ϸ� while�� ����
                        } catch (IOException e1) {

                        }

                     }
                  } // while�� ��

               }// run�޼ҵ� ��
            });

      th.start();

   }

   public void send_Message(String str) { // ������ �޼����� ������ �޼ҵ�
      try {
         dos.writeUTF(str);
      } catch (IOException e) {
         textArea.append("�޼��� �۽� ����\n");
      }
   }

   public void init() { // ȭ�鱸�� �޼ҵ�

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 300, 395);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(7, 7, 270, 300);
      contentPane.add(scrollPane);

      textArea = new JTextArea();
      scrollPane.setViewportView(textArea);

      textField = new JTextField();
      textField.setBounds(10, 310, 160, 40);
      contentPane.add(textField);

      sendBtn = new JButton("������");
      sendBtn.setBounds(170, 310, 110, 40);
      contentPane.add(sendBtn);

      setVisible(true);
      textArea.setEditable(false);
   }

   public void start() { // �׼��̺�Ʈ ���� �޼ҵ�

      sendBtn.addActionListener(new Myaction()); // ����Ŭ������ �׼� �����ʸ� ��ӹ��� Ŭ������
      textField.addKeyListener(new Keyaction());

   }

   class Myaction implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
   {

      
      public void actionPerformed(ActionEvent e) {

         if (e.getSource() == sendBtn) // �׼� �̺�Ʈ�� sendBtn�϶�
         {

            send_Message(textField.getText());
            textField.setText(""); // �޼����� ������ ���� �޼��� ����â�� ����.

         }

      }

   }
   class Keyaction implements KeyListener
   {
   public void keyPressed(KeyEvent e) { 
	      if( e.getKeyCode() == KeyEvent.VK_ENTER ) { 
	         send_Message(textField.getText());
	         textField.setText(""); 
	      }
   }
   @Override
   public void keyReleased(KeyEvent arg0) {
    
   }
   @Override
   public void keyTyped(KeyEvent arg0) {
    
   }}}