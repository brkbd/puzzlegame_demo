package com.ITheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] arr = new int[4][4];
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    int x = 0;
    int y = 0;
    int step = 0;
    String path = "game\\image\\girl\\girl8\\";
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenu changeTypeItem = new JMenu("更换种类");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame() {
        //初始化窗体
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //打乱数字
        initArr();
        //添加图片
        initImage();
        //显示
        this.setVisible(true);
    }

    private void initArr() {
        Random r = new Random();
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < 16; i++) {
            int index = r.nextInt(16);
            int k = temp[i];
            temp[i] = temp[index];
            temp[index] = k;
        }
        for (int i = 0; i < 16; i++) {
            if (temp[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arr[i / 4][i % 4] = temp[i];
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel jLabel = new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\win.png"));
            jLabel.setBounds(250, 350, 197, 73);
            this.getContentPane().add(jLabel);
        }
        JLabel stepCounter = new JLabel("步数：" + step);
        stepCounter.setBounds(100, 50, 100, 70);
        this.getContentPane().add(stepCounter);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = arr[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                jLabel.setBounds(105 * j + 135, 105 * i + 180, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane().add(jLabel);
            }
        }
        JLabel background = new JLabel(new ImageIcon("game\\image\\background.png"));
        background.setBounds(91, 86, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);

        accountItem.addActionListener(this);

        changeTypeItem.add(girl);
        changeTypeItem.add(animal);
        changeTypeItem.add(sport);

        functionJMenu.add(changeTypeItem);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);


        aboutJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(700, 800);
        this.setTitle("拼图 单机v1.0");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(135, 180, 420, 420);
            all.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.getContentPane().add(all);
            JLabel background = new JLabel(new ImageIcon("game\\image\\background.png"));
            background.setBounds(91, 86, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) return;
        int code = e.getKeyCode();
        if (code == 38)//上移
        {
            if (x + 1 < 4) {
                arr[x][y] = arr[x + 1][y];
                arr[x + 1][y] = 0;
                x++;
            }
            step++;
            initImage();
        } else if (code == 40) {//下移
            if (x - 1 >= 0) {
                arr[x][y] = arr[x - 1][y];
                arr[x - 1][y] = 0;
                x--;
            }
            step++;
            initImage();
        } else if (code == 37) {//左移
            if (y + 1 < 4) {
                arr[x][y] = arr[x][y + 1];
                arr[x][y + 1] = 0;
                y++;
            }
            step++;
            initImage();
        } else if (code == 39) {//右移
            if (y - 1 >= 0) {
                arr[x][y] = arr[x][y - 1];
                arr[x][y - 1] = 0;
                y--;
            }
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            arr = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    private boolean victory() {
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if (win[i][i1] != arr[i][i1]) return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob == replayItem) {
            initArr();
            step = 0;
            initImage();
        } else if (ob == reLoginItem) {
            this.setVisible(false);
            new LogInFrame();
        } else if (ob == accountItem) {
            JFrame account = new JFrame();
            account.setTitle("公众号二维码");
            account.setLayout(null);
            account.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            account.setSize(295, 325);
            account.setAlwaysOnTop(true);
            account.setLocationRelativeTo(null);
            JLabel about = new JLabel(new ImageIcon("C:\\exercise\\puzzlegame\\game\\image\\about.png"));
            about.setBounds(10, 10, 258, 258);
            account.getContentPane().add(about);
            account.setVisible(true);
        } else if (ob == closeItem) {
            System.exit(0);
        } else if (ob == girl) {
            Random r = new Random();
            int num = r.nextInt(13);
            num++;
            path = "game\\image\\girl\\girl" + num + "\\";
            initArr();
            step = 0;
            initImage();
        } else if (ob == animal) {
            Random r = new Random();
            int num = r.nextInt(8);
            num++;
            path = "game\\image\\animal\\animal" + num + "\\";
            initArr();
            step = 0;
            initImage();
        } else if (ob == sport) {
            Random r = new Random();
            int num = r.nextInt(10);
            num++;
            path = "game\\image\\sport\\sport" + num + "\\";
            initArr();
            step = 0;
            initImage();
        }
    }
}
