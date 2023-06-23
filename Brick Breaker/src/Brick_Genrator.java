import java.awt.*;

public class Brick_Genrator {

    public int map[][] ;
    public int brick_width ;
    public int brick_height ;
    public int brick_number ;

    public Brick_Genrator(int row,int col){
        map = new int[row][col];
        for (int i = 0 ; i<row; i++){
            for (int j = 0; j< col;j++){
                map[i][j]=1;
            }
        }
        brick_width = 700/col;
        brick_height = 250/row;
    }

    public void setBrick(int value,int r, int c){
        map[r][c] = value;
    }

    public void draw(Graphics2D g){
        for(int i = 0;i<map.length;i++){
            for (int j = 0 ; j< map[i].length;j++){
                if(map[i][j] > 0){
                    g.setColor(Color.white);
                    g.fillRect(j*brick_width+40,i*brick_height+50,brick_width,brick_height);
                    g.setColor(Color.black);
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brick_width+40,i*brick_height+50,brick_width,brick_height);
                }
            }
        }
    }
}
