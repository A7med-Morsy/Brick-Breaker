/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author Ahmed Morsy
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer = new Timer(1, this);
    private Ball ball = new Ball();
    private BrickManager bricks = new BrickManager(3, 7);

    private JButton startBtn = new JButton("Start");
    private JButton restartBtn = new JButton("Restart");
    private JButton select_color = new JButton("select_color");
    
    private Color backgroundColor = Color.BLACK;

    private boolean running = false;
    private int score = 0;

    // متغيرات البادل جوه الـ GamePanel
    private int paddleX = 300, paddleY = 540, paddleWidth = 100, paddleHeight = 10;

    public GamePanel() {
        this.setLayout(null);

        startBtn.setBounds(200, 580, 120, 30);
        restartBtn.setBounds(380, 580, 120, 30);
        select_color.setBounds(5, 5, 120, 30);
        startBtn.setBackground(Color.LIGHT_GRAY);
        restartBtn.setBackground(Color.LIGHT_GRAY);
        select_color.setBackground(Color.LIGHT_GRAY);
        add(startBtn);
        add(select_color);
        add(restartBtn);
        select_color.addActionListener(this);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        requestFocusInWindow();

        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                running = true;
                timer.start();
                requestFocusInWindow(); 
            }
        });

        restartBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resetGame();
                requestFocusInWindow();
            }
        });
    }

    private void resetGame() {
        running = false;
        score = 0;
        ball.reset();
        resetPaddle();
        bricks.reset();
        repaint();
    }

    // دالة لإرجاع مستطيل البادل للكوليجن
    public Rectangle getPaddleRect() {
        return new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    // دالة لإعادة البادل لمكانه الأصلي
    public void resetPaddle() {
        paddleX = 300;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(backgroundColor); // اللون عبارة عن متغير

        bricks.draw(g);

        // رسم البادل
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        // رسم الكرة
        ball.draw(g);

        // رسم النتيجة
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 550, 30);

        if (bricks.isCleared()) {
            g.setColor(Color.GREEN);
            g.drawString("YOU WON!", 300, 300);
            running = false;
        }

        if (ball.isLost()) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 290, 300);
            running = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==timer){
        if (!running) return;

        ball.move();
        ball.checkWallCollision();

        // التصادم مع البادل
        if (ball.getRect().intersects(getPaddleRect())) {
            ball.bounceY();
        }

        // التصادم مع الطوب
        for (Brick b : bricks.getBricks()) {
            if (!b.isBroken() && ball.getRect().intersects(b.getRect())) {
                b.breakBrick();
                ball.bounceY();
                score += 5;
                break;
            }
        }

        repaint();
       }
        // هنعمل ربط باذن الله هنغير لون الخلفية 
        if(e.getSource()==select_color)
        {
            JColorChooser c = new JColorChooser();
            Color colorback =c.showDialog(null, "Select color for background", backgroundColor);
            backgroundColor = colorback;
            
            this.setBackground(backgroundColor);
        }
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                paddleX += 15;
                if (paddleX + paddleWidth > 720) paddleX = 720 - paddleWidth;
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                paddleX -= 15;
                if (paddleX < 0) paddleX = 0;
                repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

