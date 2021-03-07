import Surrounding.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Garden extends JFrame implements MouseListener {
    private int sideTileCount = 15;
    private int counter       = 0;
    private int wallCount     = 10;
    private int appleCount    = 1;
    private Surrounding[][]figures;
    private Surrounding selected;

    /*
        Method, creating and constructing the field(board)
     */
    public Garden (){

        this.figures = new Surrounding[sideTileCount][sideTileCount];

        //Payer
        this.figures[7][0] = (new Snake(7,0,Color.YELLOW));
        //CantGoTrough
        while(counter < wallCount) {
            int[] wallCoordinates = Environment();
            int row = wallCoordinates[0]; //TODO can save some lines from here
            int col = wallCoordinates[1]; //TODO can save some lines from here
            if (figures[row][col] == null) {
                figures[row][col] = (new Wall(row, col, Color.GRAY));
                counter++;
            }
        }
            int[] wallCoordinates = Environment();
            int row = wallCoordinates[0];
            int col = wallCoordinates[1];
            if (figures[row][col] == null) {
                figures[row][col] = (new Apple(row, col, Color.RED));
            }

        this.setSize(510, 460);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    /*
        Method, resposible for moving the player around the field
        @param mouseEvent listener for action
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int col = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getX());
        int row = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getY());

        if(this.selected != null) {
            Surrounding gps = this.selected;

            if (gps.isMoveValid(row, col) && !hasImpassableTile(row, col)) {

                movePlayer(col, row, gps);
                this.repaint();
                return;
            }

        }
        if (this.hasGPS(row, col)) {
            this.selected = this.getFigurePosition(row, col);
        }
    }
    /*
        Empty necessary method
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    /*
        Method respnsible for moving the player and asaigning its ne coordinates
     */
    private void movePlayer(int col, int row, Surrounding gps) {
        int startingRow = gps.getRow();
        int startingCol = gps.getCol();

        gps.move(row, col);

        this.figures[gps.getRow()][gps.getCol()] = this.selected;
        this.figures[startingRow][startingCol] = null;
        this.selected = null;
    }
    /*
        Method setting the color of the empty spaces on the field(board)
     */
    private Color getTileColor() {

        return Color.BLACK;

    }

    public int[] Environment(){
        int[] coordinates = new int[2];
        Random rand = new Random();
        int col = rand.nextInt(14);
        int row = rand.nextInt(14);
        coordinates[0] = row;
        coordinates[1] = col;
        return coordinates;
    }

    /*
        Method rendering the field(board)
     */
    public void renderField(Graphics g, int row, int col){
        Color tileColor = this.getTileColor();
        Pixel tile = new Pixel(row, col, tileColor);
        tile.render(g);
    }
    /*
        Method responsible for getting the coordinates of the figures
     */
    private Surrounding getFigurePosition(int row, int col){
        return this.figures[row][col];
    }
    /*
        Method checking if the GPS is on the field
     */
    private boolean hasGPS(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method checking if the GPSCoordinates
     */
    private boolean hasGPSCoordinates(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method checking if there are ImpassibleTile-s on the field
     */
    private boolean hasImpassableTile(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method rendering the PayerTile(GPS)
     */
    public void renderGPS(Graphics g, int row, int col) {

        if (this.hasGPS(row, col)) {
            Surrounding gps = this.getFigurePosition(row, col);
            gps.render(g);
        }
    }
    /*
        Method painting everything
     */
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < sideTileCount; row++) {
            for (int col = 0; col < sideTileCount; col++) {

                this.renderField(g, row, col);
                this.renderGPS  (g, row, col);
            }
        }
    }

    /*
        Method getting the coordinates for moving the player and placing the Environment
     */
    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Pixel.PIXEL_SIZE;
    }

    //private boolean isBabaYagaHere(int row, int col){
    //    return this.getImpassableTile(row, col) != null;
    //}
}
