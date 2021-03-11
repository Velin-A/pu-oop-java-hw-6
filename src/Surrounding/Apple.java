package Surrounding;
import java.awt.*;

public class Apple extends Surrounding{
    public static final int PIXEL_SIZE = 30;
    public static final int BORDER_OFFSET = 1;
    /*
    Constructor for Apples
    @param row row position
    @param col col position
    @param color tile color
    */
    public Apple (int row, int col, Color color){
        this.row   = row;
        this.col   = col;
        this.color = color;
    }

    /*
        Apple renderer
     */
    public void render(Graphics g){

        int tileX    = this.col * PIXEL_SIZE;
        int tileY    = this.row * PIXEL_SIZE;

        g.setColor(this.color);
        g.fillOval(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
    }
}
