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
public class Brick {
   private Rectangle rect;
private boolean broken = false;


public Brick(int x, int y, int w, int h) {
rect = new Rectangle(x, y, w, h);
}


public void draw(Graphics g) {
if (!broken) {
g.setColor(Color.WHITE);
g.fillRect(rect.x, rect.y, rect.width, rect.height);
g.setColor(Color.BLACK);
g.drawRect(rect.x, rect.y, rect.width, rect.height);
}
}


public Rectangle getRect() { return rect; }
public boolean isBroken() { return broken; }
public void breakBrick() { broken = true; }
}
