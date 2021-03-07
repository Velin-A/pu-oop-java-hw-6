 import java.awt.*;

    public class Pixel {
        public static final int PIXEL_SIZE = 30;
        public static final int BORDER_OFFSET = 1;
        private int row;
        private int col;
        private Color color;

        /*
            Constructor for Pixels
            @param row row coordinate
            @param col col coordinate
            @param color tile color
         */
        public Pixel(int row, int col, Color color){
            this.row      = row;
            this.col      = col;
            this.color    = color;
        }

        /*
            Method rendering the Pixels
         */
        public void render(Graphics g){

            int tileX    = this.col * PIXEL_SIZE;
            int tileY    = this.row * PIXEL_SIZE;

            g.setColor(this.color);
            g.drawRect(tileX, tileY, PIXEL_SIZE, PIXEL_SIZE);
            g.fillRect(tileX, tileY, PIXEL_SIZE-BORDER_OFFSET,  PIXEL_SIZE-BORDER_OFFSET);
        }
    }

