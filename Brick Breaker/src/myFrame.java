import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame extends JFrame {

    int window_width = 800;
    int window_height = 600;
//
//    int btn_width = 100;
//    int btn_height = 30;

    myFrame(){
    JFrame f = new JFrame("Brick Breaker");
    f.setSize(window_width,window_height);
    f.setLocation(200,50);
//    f.setLayout(null);

    myPanel panel = new myPanel();
//    panel.setBounds(0,0,window_width,window_height);
    panel.setBackground(Color.black);
//
//    JButton start = new JButton("start");
//    JButton option = new JButton("option");
//    JButton exit = new JButton("exit");
//
//    start.setBounds((window_width/2) - (btn_width/2),window_height/3,btn_width,btn_height);
//    option.setBounds((window_width/2) - (btn_width/2),(window_height/3) + 50 ,btn_width,btn_height);
//    exit.setBounds((window_width/2) - (btn_width/2),(window_height/3) + 100,btn_width,btn_height);
//
//    start.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
////            System.out.println("start");
//            f.add(panel);
//
//
//
//        }
//    });
//
//    option.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    });
//
//    exit.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int a = JOptionPane.showConfirmDialog(f,"Really want to exit ?");
//            if(a == JOptionPane.YES_OPTION){
//                System.out.println("yes");
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            }
//        }
//    });
//
//    f.add(start);
//    f.add(option);
//    f.add(exit);

    f.add(panel);
    f.setResizable(false);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setVisible(true);
    }

    public static void main(String[] args) {
        myFrame frame = new myFrame();
    }
}
