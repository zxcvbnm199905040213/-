
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {


    private Container cp;
    private int dirFlag = 1 , objx = 0 , objy = 0 , objw = 220 , objh = 230 ;
    private JLabel jlb = new JLabel();
    private ImageIcon imag = new ImageIcon("02.png");
    private ImageIcon imag3 = new ImageIcon("01.png");
    private Timer T1;

    public MainFrame() {
        init();
    }


    private void init() {
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setBounds(50, 50, 490, 680);
        cp = this.getContentPane();
        cp.setLayout(null);

        jlb.setIcon(imag);
        cp.add(jlb);
        jlb.setBounds(objx, objy,objw,objh);

        T1 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag) {
                    case 1:
                        if (objy - 2 > 0) {
                            objy -= 1;
                        }else {
                            dirFlag = 2 ;
                        }
                        break;
                    case 2:
                        if (objy < 600 - objh) {
                            objy += 1;
                        }else {
                            dirFlag = 1 ;
                        }
                        break;
                    case 3:
                        if (objx-2>0){
                            objx-=1;
                        }else {
                            dirFlag = 4 ;
                        }
                        break;
                    case 4:
                        if (objx<425-objw){
                            objx+=1;
                        }else {
                            dirFlag = 3 ;
                        }
                        break;
                }
                jlb.setLocation(objx, objy);
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {


                    case KeyEvent.VK_LEFT:
                        jlb.setIcon(imag);
                        jlb.setLocation(jlb.getX() - 5, jlb.getY());
                        dirFlag = 3;
                        break;


                    case KeyEvent.VK_RIGHT:
                        jlb.setIcon(imag3);
                        jlb.setLocation(jlb.getX() + 5, jlb.getY());
                        dirFlag = 4;
                        break;


                   case KeyEvent.VK_UP:
                       jlb.setIcon(imag3);
                       jlb.setLocation(jlb.getX() , jlb.getY()-5);
                       dirFlag = 1 ;
                       break;

                    case KeyEvent.VK_DOWN:
                       jlb.setIcon(imag3);
                       jlb.setLocation(jlb.getX() , jlb.getY()+5);
                        dirFlag = 2;
                       break;

                    case KeyEvent.VK_SPACE:
                        jlb.setIcon(imag3);
                        T1.start();

                }
            }
        });
    }
}