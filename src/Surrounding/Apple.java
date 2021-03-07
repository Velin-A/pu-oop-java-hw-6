package Surrounding;

import java.awt.*;

public class Apple extends Surrounding{
    public static final int PIXEL_SIZE = 30;
    public static final int BORDER_OFFSET = 1;
    public Apple (int row, int col, Color color){
        this.row   = row;
        this.col   = col;
        this.color = color;
    }

    public void render(Graphics g){

        int tileX    = this.col * PIXEL_SIZE;
        int tileY    = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        //g.drawRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
        g.fillRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
    }

    public boolean canGoTrough(){
        return true;
    }
}
