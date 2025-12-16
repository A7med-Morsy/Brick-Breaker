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
import java.util.*;

public class BrickManager {
    private java.util.List<Brick> bricks = new ArrayList<>();


public BrickManager(int rows, int cols) {
int w = 540 / cols;
int h = 150 / rows;
for (int r = 0; r < rows; r++)
for (int c = 0; c < cols; c++)
bricks.add(new Brick(c * w + 80, r * h + 50, w, h));
}


public void draw(Graphics g) {
for (Brick b : bricks) b.draw(g);
}


public java.util.List<Brick> getBricks() { return bricks; }


public boolean isCleared() {
return bricks.stream().allMatch(Brick::isBroken);
}


public void reset() {
bricks.clear();
bricks.addAll(new BrickManager(3,7).bricks);
}
}
