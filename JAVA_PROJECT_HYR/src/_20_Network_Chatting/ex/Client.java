package _20_Network_Chatting.ex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

   private JPanel contentPane;
   private JTextField tf_ID; // ID�� �Է¹�����
   private JTextField tf_IP; // IP�� �Է¹�����
   private JTextField tf_PORT; //PORT�� �Է¹�����

   public Client() // ������
   {

      init();
      start();

   }

   public void init() // ȭ�� ����
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ũ��
      setBounds(100, 100, 288, 392);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblNewLabel = new JLabel("ID");
      lblNewLabel.setBounds(50, 60, 90, 30);
      contentPane.add(lblNewLabel); //id

      tf_ID = new JTextField();
      tf_ID.setBounds(90, 60, 150, 20);
      contentPane.add(tf_ID); //id�� �ؽ�Ʈ�ʵ�

      JLabel lblServerIp = new JLabel("Server IP");
      lblServerIp.setBounds(10, 110, 90, 30);
      contentPane.add(lblServerIp);

      tf_IP = new JTextField();
      tf_IP.setBounds(90, 120, 150, 20);
      contentPane.add(tf_IP);

      JLabel lblPort = new JLabel("Port");
      lblPort.setBounds(40, 180, 90, 30);
      contentPane.add(lblPort);

      tf_PORT = new JTextField();
      tf_PORT.setBounds(90, 190, 150, 20);
      contentPane.add(tf_PORT);

      JButton btnNewButton = new JButton("�����ϱ�");
      btnNewButton.setBounds(40, 270, 210, 50);
      contentPane.add(btnNewButton); //�����ϱ� ��ư���� 
      
      btnNewButton.addActionListener(new ActionListener() {
         
         
                     public void actionPerformed(ActionEvent arg0) {

            String _id = tf_ID.getText();
            String _ip= tf_IP.getText(); 
            int _port=Integer.parseInt(tf_PORT.getText());
            
            MainView view = new MainView(_id,_ip,_port);
            setVisible(false);
            
            
         }
      });
      
      
   }

   public void start() // �̺�Ʈ ó��
   {

   }

}