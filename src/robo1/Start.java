package robo1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author BAHARAN1
 */
public class Start extends JFrame {

    JLabel background;
    JLabel back;
    ImageIcon picBack;
    JButton start, option, credits;
    String name;

    public Start() {
        this.setLayout(null);
        this.setLocation(0, 0);
        this.setSize(1000, 750);
        start = new JButton();
        option = new JButton();
        credits = new JButton();
        start.setSize(100, 30);
        start.setLocation(400, 250);
        start.setText("Start");
        start.setBackground(Color.yellow);
        start.setForeground(Color.black);
        option.setSize(100, 30);
        option.setLocation(400, 350);
        option.setText("Option");
        option.setBackground(Color.yellow);
        option.setForeground(Color.black);
        credits.setSize(100, 30);
        credits.setLocation(400, 450);
        credits.setText("credits");
        credits.setBackground(Color.yellow);
        credits.setForeground(Color.black);
        picBack = new ImageIcon("Start.jpg");
        background = new JLabel(picBack);
        background.add(start);
        background.add(option);
        background.add(credits);
        background.setSize(1000, 750);
        background.setLocation(0, 0);
        this.getContentPane().add(background);
        this.setVisible(true);

        credits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                visiblefalse();
                JButton Back = new JButton();
                Back.setLocation(420, 650);
                Back.setSize(80, 30);
                Back.setText("back");
                Back.setBackground(Color.yellow);
                Back.setForeground(Color.black);
                JFrame creditsframe = new JFrame();
                creditsframe.setLayout(null);
                creditsframe.setLocation(0, 0);
                creditsframe.setSize(1000, 750);
                back = new JLabel(picBack);
                back.setSize(1000, 750);
                back.setLocation(0, 0);
                back.add(Back);
                creditsframe.getContentPane().add(back);
                creditsframe.setVisible(true);
                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        visibletrue();
                        creditsframe.setVisible(false);
                    }
                });
            }
        });
        option.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                visiblefalse();
                JButton Back = new JButton();
                Back.setLocation(440, 650);
                Back.setSize(80, 30);
                Back.setText("back");
                Back.setBackground(Color.yellow);
                Back.setForeground(Color.black);
                JFrame optionframe = new JFrame();
                optionframe.setLayout(null);
                optionframe.setLocation(0, 0);
                optionframe.setSize(1000, 750);
                back = new JLabel(picBack);
                back.setSize(1000, 750);
                back.setLocation(0, 0);
                back.add(Back);
                optionframe.getContentPane().add(back);
                optionframe.setVisible(true);
                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        visibletrue();
                        optionframe.setVisible(false);
                    }
                });
            }
        });
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                visiblefalse();
                JButton Back = new JButton();
                Back.setLocation(440, 650);
                Back.setSize(80, 30);
                Back.setBackground(Color.yellow);
                Back.setForeground(Color.black);
                Back.setText("back");
                JButton signin = new JButton();
                signin.setLocation(440, 250);
                signin.setSize(100, 30);
                signin.setText("Sign in");
                signin.setBackground(Color.YELLOW);
                signin.setForeground(Color.black);
                JButton signup = new JButton();
                signup.setLocation(440, 350);
                signup.setSize(100, 30);
                signup.setText("Sign up");
                signup.setBackground(Color.yellow);
                signup.setForeground(Color.black);
                JFrame startframe = new JFrame();
                startframe.setLayout(null);
                startframe.setLocation(0, 0);
                startframe.setSize(1000, 750);
                back = new JLabel(picBack);
                back.setSize(1000, 750);
                back.setLocation(0, 0);
                back.add(Back);
                back.add(signin);
                back.add(signup);
                startframe.getContentPane().add(back);
                startframe.setVisible(true);
                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        visibletrue();
                        startframe.setVisible(false);
                    }
                });
                signin.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        startframe.setVisible(false);
                        JFrame signinframe = new JFrame();
                        signinframe.setLayout(null);
                        signinframe.setLocation(0, 0);
                        signinframe.setSize(1000, 750);
                        JButton Back = new JButton();
                        Back.setLocation(440, 650);
                        Back.setSize(80, 30);
                        Back.setText("back");
                        Back.setBackground(Color.yellow);
                        JButton oneplayer = new JButton();
                        oneplayer.setLocation(440, 250);
                        oneplayer.setSize(150, 30);
                        oneplayer.setText("oneplayer");
                        oneplayer.setBackground(Color.yellow);
                        JButton twoplayer = new JButton();
                        twoplayer.setLocation(440, 350);
                        twoplayer.setSize(150, 30);
                        twoplayer.setText("twoplayer");
                        twoplayer.setBackground(Color.yellow);
                        back = new JLabel(picBack);
                        back.setSize(1000, 750);
                        back.setLocation(0, 0);
                        back.add(Back);
                        back.add(oneplayer);
                        back.add(twoplayer);
                        signinframe.getContentPane().add(back);
                        Back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                signinframe.setVisible(false);
                                startframe.setVisible(true);
                            }
                        });
                        oneplayer.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                signinframe.setVisible(false);
                                JFrame oneplayerframe = new JFrame();
                                JButton Back = new JButton();
                                Back.setLocation(200, 350);
                                Back.setSize(80, 50);
                                Back.setText("back");
                                oneplayerframe.setLayout(null);
                                oneplayerframe.setLocation(0, 0);
                                oneplayerframe.setSize(1000, 750);
                                back = new JLabel(picBack);
                                back.setSize(1000, 750);
                                back.setLocation(0, 0);
                                back.add(Back);
                                JTextField nametextfield = new JTextField();
                                nametextfield.setLocation(10, 10);
                                nametextfield.setSize(200, 100);
                                back.add(nametextfield);
                                oneplayerframe.getContentPane().add(back);
                                oneplayerframe.setVisible(true);
                                Back.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        signinframe.setVisible(true);
                                        oneplayerframe.setVisible(false);
                                    }
                                });
                                nametextfield.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        name = nametextfield.getText();
                                    }
                                });
                            }
                        });
                        twoplayer.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                signinframe.setVisible(false);
                                JFrame oneplayerframe = new JFrame();
                                oneplayerframe.setLayout(null);
                                oneplayerframe.setLocation(0, 0);
                                oneplayerframe.setSize(1000, 750);
                                JButton Back = new JButton();
                                Back.setLocation(440, 650);
                                Back.setSize(80, 30);
                                Back.setText("back");
                                back = new JLabel(picBack);
                                back.setSize(1000, 750);
                                back.setLocation(0, 0);
                                back.add(Back);
                                JTextField nametextfield1 = new JTextField();
                                JTextField nametextfield2 = new JTextField();
                                nametextfield1.setLocation(10, 10);
                                nametextfield1.setSize(200, 100);
                                back.add(nametextfield1);
                                nametextfield2.setLocation(300, 10);
                                nametextfield2.setSize(200, 100);
                                back.add(nametextfield2);
                                oneplayerframe.getContentPane().add(back);
                                oneplayerframe.setVisible(true);
                                Back.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        signinframe.setVisible(true);
                                        oneplayerframe.setVisible(false);
                                    }
                                });
                                nametextfield1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {
                                        name = nametextfield1.getText();
                                    }
                                });
                            }
                        });
                        signinframe.setVisible(true);
                    }
                });
                signup.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try {
                            JFrame mainFrame = new JFrame();
                            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            gamepanel a = new gamepanel();
                            mainFrame.setLocation(0, 0);
                            mainFrame.setSize(1020, 780);
                            mainFrame.setVisible(true);
                            mainFrame.add(a);
                            mainFrame.pack();
                        } catch (IOException ex) {
                            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });
    }

    public void visiblefalse() {
        this.setVisible(false);
    }

    public void visibletrue() {
        this.setVisible(true);
    }
}
