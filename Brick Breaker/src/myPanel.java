import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myPanel extends JPanel implements ActionListener, KeyListener{

    int radius = 20;
    int offset_x = 5;
    int offset_y = 5;
    int window_width = 800;
    int window_height = 600;
    int ball_x = window_width/2;
    int ball_y = 500;
    int paddle_length = 100;
    int score = 0;

    int paddle_x = (window_width/2) - (paddle_length/2);
    int paddle_y = window_height - 60;

    boolean play = false;
    int total_bricks;
    Timer timer ;
    int delay = 8;

    public Brick_Genrator bricks;

    @Override
    public void paint(Graphics g){
        super.paint(g);

        // border
        g.setColor(Color.green);
        g.fillRect(0,0,10,window_height);
        g.fillRect(0,0,window_width,10);
        g.fillRect(window_width-25,0,10,window_height);

        //paddle
        g.setColor(Color.yellow);
        g.fillRect(paddle_x,paddle_y,paddle_length,10 );

        //bricks
        bricks.draw((Graphics2D) g);

        // ball
        g.setColor(Color.RED);
        g.fillOval(ball_x,ball_y,radius,radius);

        // Score
        g.setColor(Color.GREEN);
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,20);
        g.setFont(f);
        g.drawString(("Score : "+ score),40,40);

        // Game Over
        if(ball_y > window_height){
            play = false;
            offset_x = 0;
            offset_y = 0;

            g.setColor(Color.red);
            Font font = new Font(Font.SANS_SERIF,Font.BOLD,50);
            g.setFont(font);
            g.drawString(("Game Over!"),window_width/3,window_height/3);

            // restart msg
            Font f2 = new Font(Font.SANS_SERIF,Font.BOLD,20);
            g.setFont(f2);
            g.drawString(("Press ! Enter to RESTART "),window_width/3 + 20,window_height/2-20);

        }

        // win msg
        if(total_bricks == 0){
            play = false;
            offset_x = 0;
            offset_y = 0;
            g.setColor(Color.green);
            Font font1 = new Font(Font.SANS_SERIF,Font.BOLD,50);
            g.setFont(font1);
            g.drawString(("Congratulations , You Won!"),window_width/4,window_height/3);


            Font f4 = new Font(Font.SANS_SERIF,Font.BOLD,20);
            g.setFont(f4);
            g.drawString(("Press ! Enter to RESTART "),window_width/3 + 20,window_height/2-20);
        }


    }

    myPanel(){
        addKeyListener(this);
        setFocusTraversalKeysEnabled(true);
        setFocusable(true);

        timer = new Timer(delay,this);
        timer.start();

        bricks = new Brick_Genrator(5,7);
    }

    public void moveLeft(){
        if(paddle_x > 10) {
            paddle_x -= 30;

        }
    }

    public void moveRight(){
        if(paddle_x < window_width-paddle_length-30)
        paddle_x += 30;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            play  = true;
            moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            play  = true;
            moveRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                score = 0;
                offset_x = 5;
                offset_y = 5;
                ball_x = window_width/2;
                ball_y = 500;
                total_bricks = 5*7;
                paddle_x = window_width/2 -50;

                bricks = new Brick_Genrator(5,7);

            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){
            if(ball_x >= (window_width - 30) - radius){
            offset_x = -(Math.abs(offset_x));
        }else if(ball_x <= 10){
            offset_x = (Math.abs(offset_x));
        }

            Rectangle ballRect = new Rectangle(ball_x,ball_y,radius,radius);
            Rectangle paddelRect = new Rectangle(paddle_x,paddle_y,paddle_length,10);

            if(ballRect.intersects(paddelRect)) {
                offset_y = -(Math.abs(offset_x));
            }
        if(ball_y <= 10){
            offset_y = (Math.abs(offset_x));
        }

        A:for(int i = 0 ; i < bricks.map.length;i++){
            for (int j = 0 ; j < bricks.map[i].length;j++){
                if(bricks.map[i][j]>0){
                    int width = bricks.brick_width;
                    int height = bricks.brick_height;
                    int brick_x = 40+j*width;
                    int brick_y = 50+i*height;

                    Rectangle brick_rect = new Rectangle(brick_x,brick_y,width,height);
                    if(ballRect.intersects(brick_rect)){
                        score += 10;
                        bricks.setBrick(0,i,j);
                        total_bricks--;

                        if(ball_x+20 == brick_x || ball_x == brick_x+width){
                            offset_x = -offset_x;
                        }else{
                            offset_y = -offset_y;
                        }

                        break A;
                    }
                }
            }
        }

            ball_x += offset_x;
            ball_y += offset_y;
//        System.out.println(x +" , "+y);

            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println(e.getKeyCode());
    }
}
