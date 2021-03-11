package Surrounding;

import java.awt.*;

public class Wall extends Surrounding {
    /*
        Constructor fot Wall
        @param row row position
        @param col col position
        @param color tile color
     */
    public static final int PIXEL_SIZE = 30;
    public static final int BORDER_OFFSET = 1;
    public Wall (int row, int col, Color color){
        this.row   = row;
        this.col   = col;
        this.color = color;
    }


    /*
        Wall renderer
     */
    public void render(Graphics g){

        int tileX    = this.col * PIXEL_SIZE;
        int tileY    = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
    }
}
