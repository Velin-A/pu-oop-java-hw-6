import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Garden extends JFrame {

    private int sidePixelCount = 15;
    private Object[][]pixels;

    public Garden (){
        this.pixels = new Object[sidePixelCount][sidePixelCount];

        this.setTitle("Smoko");
        this.setSize(550, 460);
        //this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.addMouseListener(this);
    }

    public int[] generateWall(){
        int[] wallCoordinates = new int [2];
        Random Coordinates = new Random();
        //int[][] holder = new int[1][1];
        //int row;
        //int col;
        int rand = Coordinates.nextInt(14);
        for(int i = 0; i < 2; i++){
                wallCoordinates[i] = rand;
            }
        return wallCoordinates;
    }

    public void setWall(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; i < 8; i++){
                //pixels[i][j] =
            }
        }
    }
    //private Color getPixelColor() {
    //
    //}

    public void renderDisplay(Graphics g, int row, int col){
        Color pixelColor =  Color.BLACK;  //this.getPixelColor();
        Pixel pixel = new Pixel(row, col, pixelColor);
        pixel.render(g);
    }

    /*
        Method painting the application
     */
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < sidePixelCount; row++) {
            for (int col = 0; col < sidePixelCount; col++) {
                this.renderDisplay(g, row, col);
            }
        }
    }

}
