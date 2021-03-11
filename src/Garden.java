import Surrounding.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Garden extends JFrame implements MouseListener {
    private int sideTileCount = 15;
    private int screenWidth   = 510;
    private int screenHeight  = 460;
    private int counter       = 0;
    private int wallCount     = 10;
    private Surrounding[][]figures;
    private Surrounding selected;
    private int wallRow;
    private int wallCol;
    private int snakeRow;
    private int snakeCol;
    Random random;

    /*
        Method, creating and constructing the field(board)
     */
    public Garden (){
        random = new Random();
        this.figures = new Surrounding[sideTileCount][sideTileCount];

        while(counter < wallCount) {
            int[] wallCoordinates = Environment();
            wallRow = wallCoordinates[0]; //TODO can save some lines from here
            wallCol = wallCoordinates[1]; //TODO can save some lines from here
            if (figures[wallRow][wallCol] == null) {
                figures[wallRow][wallCol] = (new Wall(wallRow, wallCol, Color.GRAY));
                counter++;

            }
        }
            int[] AppleCoordinates = Environment();
            if (figures[AppleCoordinates[0]][AppleCoordinates[1]] == null) {
                figures[AppleCoordinates[0]][AppleCoordinates[1]] = (new Apple(AppleCoordinates[0], AppleCoordinates[1], Color.RED));
            }

            int[] snakeCoordinates = Environment();
            snakeRow = snakeCoordinates [0];
            snakeCol = snakeCoordinates [1];
            if(figures[snakeRow][snakeCol] == null){
                figures[snakeRow][snakeCol] = (new Snake(snakeRow, snakeCol, Color.GREEN));
            }


        this.setSize(screenWidth, screenHeight);
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
            Surrounding Snake = this.selected;

            if (Snake.isMoveValid(row, col) && figures[wallRow][wallCol] == figures[snakeRow][snakeCol]
                    || figures[row][col] == null){

                movePlayer(col, row, Snake);
                this.repaint();
                return;
            }
            else{
                Modal.render(this, "Внимание", "Game Over");
            }

        }
        if (this.hasSnake(row, col)) {
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

    public void paint(Graphics g) {

        super.paint(g);
            for (int row = 0; row < sideTileCount; row++) {
                for (int col = 0; col < sideTileCount; col++) {
                    this.renderField(g, row, col);
                    this.renderSnake(g, row, col);
                }
            }
        }

    /*
        Method respnsible for moving the player and asaigning its ne coordinates
     */
    private void movePlayer(int col, int row, Surrounding Snake) {
        int startingRow = Snake.getRow();
        int startingCol = Snake.getCol();

        Snake.move(row, col);

        this.figures[Snake.getRow()][Snake.getCol()] = this.selected;
        this.figures[startingRow][startingCol] = null;
        this.selected = null;

    }


    /*
        Method setting the color of the empty spaces on the field(board)
     */
    private Color getTileColor() {

        return Color.BLACK;

    }
    /*
        Method giving coordinates for the Environment(Snake, Walls, Apples)
     */
    public int[] Environment(){
        int[] coordinates = new int[2];
        int col = random.nextInt(14);
        int row = random.nextInt(14);
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
        Method checking if the Snake is on the field
     */
    private boolean hasSnake(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }

    /*
        Method rendering the PayerTile(Snake)
     */
    public void renderSnake(Graphics g, int row, int col) {

        if (this.hasSnake(row, col)) {
            Surrounding Snake = this.getFigurePosition(row, col);
            Snake.render(g);
        }
    }

    /*
        Method getting the coordinates for moving the player and placing the Environment
     */
    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Pixel.PIXEL_SIZE;
    }
}
