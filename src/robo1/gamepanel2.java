
package robo1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author BAHARAN1
 */
public class gamepanel2 extends JFrame implements KeyListener, Runnable, MouseMotionListener, MouseListener  {
    InputStream input;
    OutputStream output;
    Socket socket;
    String a1 = "1";
    double aDouble = 0;
    ImageIcon enemy = new ImageIcon("Enemy1.png");
    double x = 502, y = 365, sX, sY, xt, yt, a, b, makhraj, sx, sy;
    ImageIcon icon;
    JButton aa = new JButton();
    JLabel image = new JLabel(icon);
    ImageIcon bb1 = new ImageIcon("robo.png");
    ImageIcon bb2 = new ImageIcon("tir.png");
    ImageIcon bb3 = bb1;
    ImageIcon c = new ImageIcon("tir.png");
    int shelik = 0;
    ArrayList<String> backgrounds;
    String back1 = "background1.jpg";
    String back2 = "background2.jpg";
    String back3 ="background4.jpg";
    String back4;
    String back;
    int numback = 1;
    Random r = new Random();
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;
    Enemy enemy7;
    Enemy enemy8;
    Enemy enemy9;
    Enemy enemy10;
    Enemy enemy11;
    Enemy enemy12;
    Enemy enemy13;
    Enemy enemy14;
    Enemy enemy15;
    ArrayList<Enemy> enemysl1;
    ArrayList<Enemy> enemysl2;
    ArrayList<Enemy> enemysl3;
    ArrayList<Enemy> enemysl4;
    ArrayList<ArrayList<Enemy>> levelenemys;
    int win=0;
    int shelikcounter;
    int[] t=new int[10];
    int[] enhedam=new int[10];
    int check;
    int lives=3;
    int level=1;
    String[] sep;
    public gamepanel2() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 4000);
        input = socket.getInputStream();
        output = socket.getOutputStream();
         backgrounds = new ArrayList<String>();
         backgrounds.add("  ");
         backgrounds.add("background1.jpg");
         backgrounds.add("background2.jpg");
         backgrounds.add("background3.png");
         backgrounds.add("background4.jpg");
        icon = new ImageIcon("background1.jpg");
        image.setIcon(icon);
        aa.addKeyListener(this);
        image.addMouseListener(this);
        image.addMouseMotionListener(this);
        this.add(aa);
        this.add(image);
        aa.setSize(0, 0);
        enemysl1 = new ArrayList<Enemy>();
        enemysl2 = new ArrayList<Enemy>();
        enemysl3 = new ArrayList<Enemy>();
        enemysl4 = new ArrayList<Enemy>();
        levelenemys = new ArrayList<ArrayList<Enemy>>();
        (new Thread(this)).start();
        enemy1 = new Enemy();
        enemy2 = new Enemy();
        enemy3 = new Enemy();
        enemy4 = new Enemy();
        enemy5 = new Enemy();
        enemy6 = new Enemy();
        enemy7 = new Enemy();
        enemy8 = new Enemy();
        enemy9 = new Enemy();
        enemy10 = new Enemy();
        enemy11 = new Enemy();
        enemy12 = new Enemy();
        enemy13 = new Enemy();
        enemy14 = new Enemy();
        enemy15 = new Enemy();
        enemy1.xE = 550;
        enemy1.yE = 120;
        enemy2.xE = 460;
        enemy2.yE = 70;
        enemysl1.add(enemy1);
        enemysl1.add(enemy2);
        enemysl2.add(enemy3);
        enemysl2.add(enemy4);
        enemysl2.add(enemy5);
        enemysl3.add(enemy6);
        enemysl3.add(enemy7);
        enemysl3.add(enemy8);
        enemysl3.add(enemy9);
        enemysl3.add(enemy10);
        enemysl4.add(enemy11);
        enemysl4.add(enemy12);
        enemysl4.add(enemy13);
        enemysl4.add(enemy14);
        enemysl4.add(enemy15);
        levelenemys.add(enemysl1);
        levelenemys.add(enemysl2);
        levelenemys.add(enemysl3);
        levelenemys.add(enemysl4);
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        (new Thread(new gamepanel2())).start();
    }

    @Override
    public void paint(Graphics arg0) {
       super.paint(arg0);
       xt = Double.parseDouble(sep[0]);
       yt = Double.parseDouble(sep[1]);
        x = Double.parseDouble(sep[2]);
       y = Double.parseDouble(sep[3]);
       enemy1.xE=Double.parseDouble(sep[7]);
       enemy1.yE=Double.parseDouble(sep[8]);       
        BufferedImage bufferedImage1 = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = bufferedImage1.createGraphics();
//        if (sX - x > 0) {
//            g1.rotate(Math.atan((sY - y) / (sX - x)), 30, 30);
//        }
//        if (sX - x < 0) {
//            g1.rotate(Math.atan((sY - y) / (sX - x)) + Math.toRadians(180), 30, 30);
//        }
        g1.drawImage(bb3.getImage(), 0, 0, 60, 60, null);
        arg0.drawImage(bufferedImage1, (int) x, (int) y, null);
        BufferedImage bufferedImage2 = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage2.createGraphics();
        g2.drawImage(c.getImage(), 0, 0, 20, 20, null);
        arg0.drawImage(bufferedImage2, (int) xt, (int) yt, null);
        //age back 1 dashtim
        if (numback == 1) {
            arg0.drawImage(enemy1.enemy.getImage(), (int) enemy1.xE, (int) enemy1.yE, null);
            arg0.drawImage(enemy2.enemy.getImage(), (int) enemy2.xE, (int) enemy2.yE, null);
        }
       //age back 2 dashtim
        if (numback == 2) {
            arg0.drawImage(enemy3.enemy.getImage(), (int) enemy3.xE, (int) enemy3.yE, null);
            arg0.drawImage(enemy4.enemy.getImage(), (int) enemy4.xE, (int) enemy4.yE, null);
            arg0.drawImage(enemy5.enemy.getImage(), (int) enemy5.xE, (int) enemy5.yE, null);
        }
         if (numback == 3) {
            arg0.drawImage(enemy6.enemy.getImage(), (int) enemy6.xE, (int) enemy6.yE, null);
            arg0.drawImage(enemy7.enemy.getImage(), (int) enemy7.xE, (int) enemy7.yE, null);
            arg0.drawImage(enemy8.enemy.getImage(), (int) enemy8.xE, (int) enemy8.yE, null);
            arg0.drawImage(enemy9.enemy.getImage(), (int) enemy9.xE, (int) enemy9.yE, null);
            arg0.drawImage(enemy10.enemy.getImage(), (int) enemy10.xE, (int) enemy10.yE, null);
        }
           if (numback == 4) {
            arg0.drawImage(enemy11.enemy.getImage(), (int) enemy11.xE, (int) enemy11.yE, null);
            arg0.drawImage(enemy12.enemy.getImage(), (int) enemy12.xE, (int) enemy12.yE, null);
            arg0.drawImage(enemy13.enemy.getImage(), (int) enemy13.xE, (int) enemy13.yE, null);
            arg0.drawImage(enemy14.enemy.getImage(), (int) enemy14.xE, (int) enemy14.yE, null);
            arg0.drawImage(enemy15.enemy.getImage(), (int) enemy15.xE, (int) enemy15.yE, null);
        }
        
       
    }

    @Override
    public void run() {
        int i = 0;
        while (i != -1) {
            byte[] b = new byte[200];
            try {
                i = input.read(b);
                if (i != -1) {
                    a1 = new String(b);
                   sep=a1.split(",");
                   
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
