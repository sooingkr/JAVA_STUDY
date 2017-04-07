package _20_Network_Chatting.ex;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server extends JFrame {

   private JPanel contentPane;
   private JTextField textField; // ����� PORT��ȣ �Է�
   private JButton Start; // ������ �����Ų ��ư
   JTextArea textArea; // Ŭ���̾�Ʈ �� ���� �޽��� ���

   private ServerSocket socket; //��������
   private Socket soc; // ������� 
   private int Port; // ��Ʈ��ȣ

   private Vector vc = new Vector(); // ����� ����ڸ� ������ ����

   public static void main(String[] args)
   {
   
               Server frame = new Server();
               frame.setVisible(true);
         
   }

   public Server() {

      init();

   }

   private void init() { // GUI�� �����ϴ� �޼ҵ�
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 280, 400);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      
      JScrollPane js = new JScrollPane();
            
      textArea = new JTextArea();
      js.setBounds(0, 0, 264, 254);
      contentPane.add(js);
      js.setViewportView(textArea);

      textField = new JTextField();
      textField.setBounds(98, 264, 154, 37);
      contentPane.add(textField);

      JLabel lblNewLabel = new JLabel("Port Number");
      lblNewLabel.setBounds(12, 264, 98, 37);
      contentPane.add(lblNewLabel);
      
     
      Start = new JButton("���� ����");
      Start.addActionListener(new ActionListener() { // �͸� Ŭ������ Ŭ�� �̺�Ʈ ó��
         
         public void actionPerformed(ActionEvent e) {
                        

            
               try
               {
               Port = Integer.parseInt(textField.getText()); // ���ڷ� �Է����� ������ ���� �߻� ��Ʈ�� ���� ����.
               
               server_start(); // ����ڰ� ����ε� ��Ʈ��ȣ�� �־����� ���� ���������� �޼ҵ� ȣ��
               
            
               
               }
               catch(Exception er)
               {
                  //����ڰ� ���ڷ� �Է����� �ʾ����ÿ��� ���Է��� �䱸�Ѵ�
                  textField.setText("���ڷ� �Է����ּ���");
                  textField.requestFocus();
               }
      
               
            

         }
      }); // Ŭ�� �̺�Ʈ 
      


      Start.setBounds(0, 325, 265, 35);
      contentPane.add(Start);
      
      
      textArea.setEditable(false);
      
   }

   private void server_start() {

      

      try {
         socket = new ServerSocket(Port); // ������ ��Ʈ ���ºκ�
         Start.setText("���� ���� ��");
         Start.setEnabled(false); // ������ ���̻� �����Ű�� �� �ϰ� ���´�
         textField.setEnabled(false); // ���̻� ��Ʈ��ȣ ������ �ϰ� ���´�
         
         if(socket!=null) // socket �� ���������� ��������
         {
         Connection();
         }
         
      } catch (IOException e) {
         textArea.append("������ �̹� ������Դϴ�.\n");

      }

   }

   private void Connection() {

      Thread th = new Thread(new Runnable() { // ����� ������ ���� ������

         @Override
         public void run() {
            while (true) { // ����� ������ ����ؼ� �ޱ� ���� while��
               try {
                  textArea.append("[����� ���� �����]\n");
                  soc = socket.accept(); // accept�� �Ͼ�� �������� ���� �����
                  textArea.append("[����� ����]\n");

                  UserInfo user = new UserInfo(soc, vc); // ����� ���� ������ �ݹ� ������Ƿ�, user Ŭ���� ���·� ��ü ����
                                                                       // �Ű������� ���� ����� ���ϰ�, ���͸� ��Ƶд�

                  vc.add(user); // �ش� ���Ϳ� ����� ��ü�� �߰�

                  user.start(); // ���� ��ü�� ������ ����

               } catch (IOException e) {
                  textArea.append("���� �߻�\n");
               } 

            }

         }
      });

      th.start();

   }

   class UserInfo extends Thread {

      private InputStream is;
      private OutputStream os;
      private DataInputStream dis;
      private DataOutputStream dos;

      private Socket user_socket;
      private Vector user_vc;

      private String Nickname = "";

      public UserInfo(Socket soc, Vector vc) // �����ڸ޼ҵ�
      {
         // �Ű������� �Ѿ�� �ڷ� ����
         this.user_socket = soc;
         this.user_vc = vc;

         User_network();

      }

      public void User_network() {
         try {
            is = user_socket.getInputStream();
            dis = new DataInputStream(is);
            os = user_socket.getOutputStream();
            dos = new DataOutputStream(os);

            Nickname = dis.readUTF(); // ������� �г��� �޴ºκ�
            textArea.append("������ ID : " +Nickname+"\n");
            
            send_Message("*ȯ���մϴ�! ���������а� �޽���*"); // ����� ����ڿ��� ���������� �˸�

         } catch (Exception e) {
            textArea.append("��Ʈ�� ���� ����\n");
         }

      }

      public void InMessage(String str) {
         textArea.append("����� : " + str+"\n");
         // ����� �޼��� ó��
        community(str);

      }

      public void community(String str) { //����ڰ� ������ ������ ��� ����ڿ��� �����ִ� �κ�!
       for (int i = 0; i < user_vc.size(); i++) {
           UserInfo temp = (UserInfo) user_vc.elementAt(i);
           temp.send_Message(Nickname+" : "+str ); //temp �κ��� ����� ȥ�ڼ� ��ȭ�ϴ� ���� 

        }

      }

      public void send_Message(String str) {
         try {
            dos.writeUTF(str);
         } 
         catch (IOException e) {
            textArea.append("�޽��� �۽� ���� �߻�\n");   
         }
      }

      public void run() // ������ ����
      {

         while (true) {
            try {
               
               // ����ڿ��� �޴� �޼���
               String msg = dis.readUTF();
               InMessage(msg);
             
            } 
            catch (IOException e) 
            {
               
               try {
                  dos.close();
                  dis.close();
                  user_socket.close();
                  vc.removeElement( this ); // �������� ���� ��ü�� ���Ϳ��� �����
                  textArea.append( " : ���� ������ �� : " + vc.size()+"\n");
                  textArea.append(" ����ڰ� �����Ͽ����ϴ� !\n ");
                  break;
               
               } catch (Exception ee) {
               
               }// catch�� ��
            }// �ٱ� catch����

         }
         
         
         
      }// run�޼ҵ� ��

      }
    	     } // ���� userinfoŬ������

