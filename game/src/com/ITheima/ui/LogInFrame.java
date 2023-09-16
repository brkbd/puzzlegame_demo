package com.ITheima.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class LogInFrame extends JFrame implements MouseListener {
    static ArrayList<User> list=new ArrayList<>();
    static {
        list.add(new User("张三","zhangsan"));
        list.add(new User("李四","lisi"));
    }
    String validationCode=generateValidationCode();
    JButton login=new JButton();
    JButton register=new JButton();
    String loginIconPath="C:\\exercise\\puzzlegame\\game\\image\\login\\登录按钮.png";
    String registerIconPath="C:\\exercise\\puzzlegame\\game\\image\\login\\注册按钮.png";
    JTextField code=new JTextField();
    JLabel vcode=new JLabel();
    JPasswordField password=new JPasswordField();
    JTextField username=new JTextField();
    public LogInFrame() {
        initFrame();
        initImage();

        this.setVisible(true);
    }

    private void initImage() {
        //this.getContentPane().removeAll();

        JLabel nameImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\用户名.png"));
        nameImage.setBounds(140,185,47,17);
        this.getContentPane().add(nameImage);


        username.setBounds(200,175,220,40);
        this.getContentPane().add(username);

        JLabel passwordImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\密码.png"));
        passwordImage.setBounds(140,240,32,16);
        this.getContentPane().add(passwordImage);


        password.setBounds(200,230,220,40);
        this.getContentPane().add(password);

        JLabel codeImage=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\验证码.png"));
        codeImage.setBounds(140,295,56,21);
        this.getContentPane().add(codeImage);


        code.setBounds(200,290,150,40);
        this.getContentPane().add(code);


        vcode.setText(validationCode);
        vcode.setBounds(360,295,60,30);
        this.getContentPane().add(vcode);


        login.setIcon(new ImageIcon(loginIconPath));
        login.setBounds(160,350,128,47);
        login.addMouseListener(this);
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);


        register.setIcon(new ImageIcon(registerIconPath));
        register.setBounds(320,350,128,47);
        register.addMouseListener(this);
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        JLabel background=new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\background.png"));
        background.setBounds(60,20,470,390);
        this.getContentPane().add(background);

        //this.getContentPane().repaint();
    }

    private void initFrame() {
        this.setSize(600, 500);
        this.setTitle("拼图 v1.0登录");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
    public static String generateValidationCode()
    {
        char[] ch=new char[52];
        for(int i=0;i<26;i++)
            ch[i]=(char)('a'+i);
        for(int i=26;i<52;i++)
            ch[i]=(char)('A'+i-26);
        Random r=new Random();
        int numidx=r.nextInt(5);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<5;i++)
        {
            if(i==numidx)
            {
                int k=r.nextInt(10);
                sb.append(k);
            }
            else
            {
                int k=r.nextInt(52);
                sb.append(ch[k]);
            }
        }
        return sb.toString();
    }
    public static int contains(String name,ArrayList<User> users)
    {
        for(int i=0;i<users.size();i++)
        {
            User u=users.get(i);
            if(name.equals(u.getName()))    return i;
        }
        return -1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==login)
        {
            String inputCode = code.getText();
            if (!inputCode.equals(validationCode)) {

                validationCode = generateValidationCode();
                vcode.setText(validationCode);
                showJDialog("验证码错误！");
            }else {
                String name = username.getText();
                char[] temp = password.getPassword();
                StringBuilder sb=new StringBuilder();
                for (char c : temp) {
                    sb.append(c);
                }
                String getPassword=sb.toString();
                if (name.isEmpty() || getPassword.isEmpty()) {

                    validationCode = generateValidationCode();
                    vcode.setText(validationCode);
                    showJDialog("用户名或密码为空！");
                    return;
                }
                int idx = contains(name, list);
                if (idx == -1) {

                    validationCode = generateValidationCode();
                    vcode.setText(validationCode);
                    showJDialog("用户名不存在！");
                    return;
                }
                User u = list.get(idx);
                if (getPassword.equals(u.getPassword())) {
                    this.setVisible(false);
                    new GameJFrame();
                } else {
                    validationCode = generateValidationCode();
                    vcode.setText(validationCode);
                    showJDialog("用户名或密码错误，请重新输入！");
                }
            }
        } else if (ob==register) {
            new RegisterFrame();
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==login)
        {
            login.setIcon(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\登录按下.png"));
        } else if (ob==register) {
            register.setIcon(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==login)
        {
            login.setIcon(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\登录按钮.png"));

        } else if (ob==register) {
            register.setIcon(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\login\\注册按钮.png"));

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }
}
