import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class brick extends JFrame implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 20;
    private static final int BALL_SIZE = 20;
    private static final int BRICK_WIDTH = 80;
    private static final int BRICK_HEIGHT = 30;
    private static final int NUM_BRICKS = 40;

    private int paddleX;
    private int ballX, ballY, ballSpeedX, ballSpeedY;
    private boolean ballMoving;

    private boolean[] bricks;

    public brick() {
        setTitle("Brick Breaker");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT - PADDLE_HEIGHT - BALL_SIZE - 5;
        ballSpeedX = 2;
        ballSpeedY = -2;
        ballMoving = false;

        bricks = new boolean[NUM_BRICKS];
        for (int i = 0; i < NUM_BRICKS; i++) {
            bricks[i] = true;
        }

        Timer timer = new Timer(10, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (ballMoving) {
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            // Check for collisions with walls
            if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
                ballSpeedX = -ballSpeedX;
            }
            if (ballY <= 0) {
                ballSpeedY = -ballSpeedY;
            }

            // Check for collisions with paddle
            if (ballY + BALL_SIZE >= HEIGHT - PADDLE_HEIGHT &&
                    ballX + BALL_SIZE >= paddleX && ballX <= paddleX + PADDLE_WIDTH) {
                ballSpeedY = -ballSpeedY;
            }

            // Check for collisions with bricks
            for (int i = 0; i < NUM_BRICKS; i++) {
                if (bricks[i]) {
                    int brickX = i % 8 * BRICK_WIDTH;
                    int brickY = i / 8 * BRICK_HEIGHT;
                    if (ballX + BALL_SIZE >= brickX && ballX <= brickX + BRICK_WIDTH &&
                            ballY + BALL_SIZE >= brickY && ballY <= brickY + BRICK_HEIGHT) {
                        ballSpeedY = -ballSpeedY;
                        bricks[i] = false;
                    }
                }
            }

            // Check for game over
            if (ballY >= HEIGHT) {
                ballMoving = false;
                JOptionPane.showMessageDialog(this, "Game Over!");
                System.exit(0);
            }
        }

        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);

        // Draw paddle
        g.fillRect(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw ball
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // Draw bricks
        for (int i = 0; i < NUM_BRICKS; i++) {
            if (bricks[i]) {
                int brickX = i % 8 * BRICK_WIDTH;
                int brickY = i / 8 * BRICK_HEIGHT;
                g.fillRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (paddleX > 0) {
                paddleX -= 20;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddleX < WIDTH - PADDLE_WIDTH) {
                paddleX += 20;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            ballMoving = true;
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            brick game = new brick();
            game.setVisible(true);
        });
    }
}
