package Surrounding;

import java.awt.*;

public class Wall extends Surrounding {
    /*
        Constructor fot ImpassableTile
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

    public void render(Graphics g){

        int tileX    = this.col * PIXEL_SIZE;
        int tileY    = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        //g.drawRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
        g.fillRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
    }

    public boolean canGoTrough(){
        return false;
    }
}
