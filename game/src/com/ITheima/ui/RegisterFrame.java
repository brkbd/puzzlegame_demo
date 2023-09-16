package com.ITheima.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterFrame extends JFrame implements MouseListener {
    JButton register=new JButton();
    JButton reset=new JButton();
    String registerIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\注册按钮.png";
    String resetIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\重置按钮.png";

    public RegisterFrame(){
        initJFrame();
        initImage();
        this.setVisible(true);
    }

    private void initImage() {
        this.getContentPane().removeAll();

        JLabel nameImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\register\\注册用户名.png"));
        nameImage.setBounds(120,185,79,17);
        this.getContentPane().add(nameImage);

        JTextField username=new JTextField();
        username.setBounds(220,175,220,40);
        this.getContentPane().add(username);

        JLabel passwordImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\register\\注册密码.png"));
        passwordImage.setBounds(120,240,64,16);
        this.getContentPane().add(passwordImage);

        JPasswordField password=new JPasswordField();
        password.setBounds(220,230,220,40);
        this.getContentPane().add(password);

        JLabel reInputImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\register\\再次输入密码.png"));
        reInputImage.setBounds(120,295,96,17);
        this.getContentPane().add(reInputImage);

        JPasswordField reInput=new JPasswordField();
        reInput.setBounds(220,290,220,40);
        this.getContentPane().add(reInput);

        register.setIcon(new ImageIcon(registerIconPath));
        register.setBounds(160,350,128,47);
        register.addMouseListener(this);
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        reset.setIcon(new ImageIcon(resetIconPath));
        reset.setBounds(320,350,128,47);
        reset.addMouseListener(this);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        this.getContentPane().add(reset);

        JLabel background=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\register\\background.png"));
        background.setBounds(60,20,470,390);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initJFrame() {
        this.setSize(600,500);
        this.setTitle("拼图 v1.0注册");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==register)
        {
            registerIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\注册按下.png";
            initImage();
        } else if (ob==reset) {
            resetIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\重置按下.png";
            initImage();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==register)
        {
            registerIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\注册按钮.png";
            initImage();
        } else if (ob==reset) {
            resetIconPath="C:\\exercise\\puzzlegame\\game\\image\\register\\重置按钮.png";
            initImage();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
