package robo1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author BAHARAN1
 */
public class gamepanel extends JPanel implements KeyListener, Runnable, MouseMotionListener, MouseListener {

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
    InputStream input;
    OutputStream output;
    ServerSocket ss;
    int win=0;
    int[] t=new int[10];
    int[] enhedam=new int[10];
    int check;
    int lives=3;
    int level=1;
    int kkk=0;

    public gamepanel() throws IOException {
        ss = new ServerSocket(4000);
        Socket client = ss.accept();
        input = client.getInputStream();
        output = client.getOutputStream();
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
        
    }

    @Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        BufferedImage bufferedImage1 = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = bufferedImage1.createGraphics();
        if (sX - x > 0) {
            g1.rotate(Math.atan((sY - y) / (sX - x)), 30, 30);
        }
        if (sX - x < 0) {
            g1.rotate(Math.atan((sY - y) / (sX - x)) + Math.toRadians(180), 30, 30);
        }
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
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (x < 940 && numback == 1) {
                x += 5;
            }
            if (x < 600 && numback == 2) {
                x += 5;
            }
             if (numback == 3 || numback==4) {
                x += 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (x > 430 && numback == 1) {
                x -= 5;
            }
            if (x > 430 && numback == 2) {
                x -= 5;
            }
             if (numback == 3 || numback==4) {
                x -= 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println(numback);
            if (y > 55 && numback == 1) {
                y -= 5;
            }
            if (y > 30 && numback == 2) {
                y -= 5;
            }
            if (numback == 3 || numback==4) {
                y -= 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (y < 700 && numback == 1) {
                y += 5;
            }
            if (y < 680 && numback == 2) {
                y += 5;
            }
           if (numback == 3 || numback==4) {
                y += 5;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            //bere marhale bad az 1 be 2
            if ((x > 470 && x < 570 && y < 88 && numback == 1 && win==1 && numback==level)){
                x = 500;
                y = 700;
                enemy3.xE = 550;enemy3.yE = 120;
                enemy4.xE = 460;enemy4.yE = 70;
                enemy5.xE = 490;enemy5.yE = 100;
                back = backgrounds.get(2);
                numback = 2;
                level=2;
                icon = new ImageIcon(back);
                image.setIcon(icon);
                this.add(image);
                win=0;
                for(int i=0;i<10;i++)
                 t[i]=0;
            }
            //bere marhale bad az 2 be 3
             if ((x > 470 && x < 570 && y < 88 && numback == 2 && win==1 && numback==level)){
                x = 500;
                y = 650;
               enemy6.xE = 20;enemy6.yE = 120;
               enemy7.xE = 660;enemy7.yE = 70;
               enemy8.xE = 800;enemy8.yE = 300;
               enemy9.xE = 20;enemy9.yE = 20;
               enemy10.xE = 200;enemy10.yE = 300;
                back = backgrounds.get(3);
                numback = 3;
                level=3;
                icon = new ImageIcon(back);
                image.setIcon(icon);
                this.add(image);
                win=0;
                for(int i=0;i<10;i++)
                 t[i]=0;
            }
             // az 3 bere 4
              if ((x > 470 && x < 570 && y < 88 && numback == 3 && win==1 && numback==level)){
                x = 500;
                y = 650;
               enemy11.xE = 20;enemy11.yE = 120;
               enemy12.xE = 660;enemy12.yE = 70;
               enemy13.xE = 800;enemy13.yE = 300;
               enemy14.xE = 20;enemy14.yE = 20;
               enemy15.xE = 200;enemy15.yE = 300;
                back = backgrounds.get(4);
                numback = 4;
                level=4;
                icon = new ImageIcon(back);
                image.setIcon(icon);
                this.add(image);
                win=0;
                for(int i=0;i<10;i++)
                 t[i]=0;
            }
             //bere badi
             if(x > 470 && x < 570 && y < 88  && level>numback)
            {
               
                numback++;
                back = backgrounds.get(numback);
                icon = new ImageIcon(back);
                image.setIcon(icon);
                this.add(image);
                y=650;
                x=500;
            }
             //biad ghabli
            
            if (x > 470 && x < 570 && y >660 && win==1) {
               numback --;
               back = backgrounds.get(numback);
                icon = new ImageIcon(back);
                image.setIcon(icon);
                this.add(image);
                x=500;
                y=90;
            }
             
            // az 1 bere 2
//            if(x > 470 && x < 570 && y < 88  && level>numback && numback==1)
//            {
//                 back = back2;
//                numback = 2;
//                icon = new ImageIcon(back);
//                image.setIcon(icon);
//                this.add(image);
//                y=650;
//                x=500;
//                
//            }
//            // az 2 bere 3
//            if(x > 470 && x < 570 && y < 88  && level>numback && numback==2)
//            {
//                 back = back3;
//                numback = 3;
//                icon = new ImageIcon(back);
//                image.setIcon(icon);
//                this.add(image);
//                y=650;
//                x=500;
//                
//            }
//           // az 2 bere 1
//            if (x > 470 && x < 570 && y >660 && numback==2 && win==1) {
//               numback = 1;
//               back = back1;
//                icon = new ImageIcon(back);
//                image.setIcon(icon);
//                this.add(image);
//                x=500;
//                y=90;
//            }
//            // az 3 bere 2
//            if (x > 470 && x < 570 && y >660 && numback==3 && win==1) {
//               numback = 2;
//               back = back2;
//                icon = new ImageIcon(back);
//                image.setIcon(icon);
//                this.add(image);
//                x=500;
//                y=90;
//            }
            //age shelik kard
            if (shelik == 1) {
                
                if (x - sx >= 10 && y - sy >= 0) {
                    xt = xt - 5;
                    yt = (a * xt) + b;
                    if (xt < 0 && yt < 0) {
                        shelik = 0;
                    }
                }
                if (x - sx <= -10 && y - sy >= 0) {
                    xt = xt + 5;
                    yt = (a * xt) + b;
                    if (xt > 1000 && yt < 0) {
                        shelik = 0;
                    }
                }
                if (x - sx >= 10 && y - sy < 0) {
                    xt = xt - 5;
                    yt = (a * xt) + b;
                    if (xt < 0 && yt > 750) {
                        shelik = 0;
                    }
                }
                if (x - sx <= -10 && y - sy < 0) {
                    xt = xt + 5;
                    yt = (a * xt) + b;
                    if (xt > 1000 && yt > 750) {
                        shelik = 0;
                    }
                }
                if (x - sx > -10 && x - sx < 10) {
                    if (y - sy > 0) {
                        a=1;
                        System.out.println("salam");
                        yt = yt +5;
                    }
                    if (y - sy < 0) {
                        a=1;
                        yt = yt - 5;
                    }
                
                    if (yt > 1000 || yt < 0) {
                        shelik = 0;
                    }
                }
            }
            
           for (int i = 0; i < levelenemys.get(numback - 1).size(); i++) {
               //barkhord kard khoon bepashe
                if(levelenemys.get(numback - 1).get(i).xE==x &&  levelenemys.get(numback - 1).get(i).yE==y && enhedam[i]==0)
                {
                    lives--;
                    enhedam[i]=1;
                   levelenemys.get(numback - 1).get(i).enemy=levelenemys.get(numback - 1).get(i).enemy22;
                   levelenemys.get(numback - 1).get(i).lives=0;
                }
                //doshman mord khoon bepashe
                if(levelenemys.get(numback - 1).get(i).lives<=0)
                    levelenemys.get(numback - 1).get(i).enemy=levelenemys.get(numback - 1).get(i).enemy22;
                //khoodesh mord khoon bepashe
                if(lives==0)
                    bb3=bb2;
                //harekate randome doshmana
                int random = r.nextInt(2);
                if (random == 1 &&  levelenemys.get(numback - 1).get(i).enemy==levelenemys.get(numback - 1).get(i).enemy11) {
                    if (x > levelenemys.get(numback - 1).get(i).xE) {
                        levelenemys.get(numback - 1).get(i).xE = levelenemys.get(numback - 1).get(i).xE + 0.5;
                       
                    }
                    if (x < levelenemys.get(numback - 1).get(i).xE) {
                        levelenemys.get(numback - 1).get(i).xE = levelenemys.get(numback - 1).get(i).xE - 0.5;
                       
                    }
                }

                if (random == 0 && levelenemys.get(numback - 1).get(i).enemy==levelenemys.get(numback - 1).get(i).enemy11) {
                    if (y > levelenemys.get(numback - 1).get(i).yE) {
                        levelenemys.get(numback - 1).get(i).yE = levelenemys.get(numback - 1).get(i).yE + 0.5;
                    }
                    if (y < levelenemys.get(numback - 1).get(i).yE) {
                        levelenemys.get(numback - 1).get(i).yE = levelenemys.get(numback - 1).get(i).yE - 0.5;
                    }
                }
            }
              
            
            //age tir khord joonesh kam she
            for (int i = 0; i < levelenemys.get(numback - 1).size(); i++)
            {
                if(xt>levelenemys.get(numback - 1).get(i).xE-50 && xt<levelenemys.get(numback - 1).get(i).xE+50 && t[i]==0 && yt>levelenemys.get(numback - 1).get(i).yE-50 && yt<levelenemys.get(numback - 1).get(i).yE+50)
                {levelenemys.get(numback - 1).get(i).lives--;
                t[i]=1;}
            }
           //check kone bebine morde ya na
            
            int counter=0;
              for (int i = 0; i < levelenemys.get(numback - 1).size(); i++)
              {
                  System.out.println(levelenemys.get(numback - 1).get(i).lives);
                  if(levelenemys.get(numback - 1).get(i).lives<=0)
                    counter++;  
              }
              //age hame morde bodan berim marhale bad
              if(counter==levelenemys.get(numback - 1).size())
                  win=1;
              
            try {
                            String s1 = Double.toString(xt);
                            String s2 = Double.toString(yt);
                            String s3 = Double.toString(x);
                            String s4 = Double.toString(y);
                            String s5 = Double.toString(sX);
                            String s6 = Double.toString(sY);
                            String s7=Integer.toString(numback);
                            String s8 = Double.toString(enemy1.xE);
                            String s9 = Double.toString(enemy1.yE);
                            
                            String s= s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8+","+s9+",";
                            output.write((s).getBytes());
                        } catch (IOException ex){
                            Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                        }   
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        xt = x;
        yt = y;
        System.out.println(point);
        sX = point.x;
        sY = point.y;
        sx = sX;
        sy = sY;
        makhraj = x - sx;
        a = (y - sy) / (x - sx);
        b = y - a * x;
        shelik = 1;
        for(int i=0;i<10;i++)
        t[i]=0;
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

    @Override
    public void mouseMoved(MouseEvent e) {
        Point point = e.getPoint();
        sX = point.x;
        sY = point.y;
    }

}
