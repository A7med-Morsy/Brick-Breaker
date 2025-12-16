/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author Ahmed Morsy
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball  {
    private int x = 120, y = 350;
private int dx = 2, dy = -3;
private final int size = 20;





public void move() {
x += dx;
y += dy;
}


public void draw(Graphics g) {
g.setColor(Color.YELLOW);
g.fillOval(x, y, size, size);
}


public Rectangle getRect() {
return new Rectangle(x, y, size, size);
}

// ارتدا راسي
public void bounceY() {
dy = -dy;
}

// ارتداد جميع الحواف م عدا الحافة السفلية 
public void checkWallCollision() {
if (x <= 0 || x >= 700) dx = -dx;
if (y <= 0) dy = -dy;
}


public boolean isLost() {
return y > 630;
}


public void reset() {
x = 120; y = 350;
dx = 1; dy = -2;
}

}
