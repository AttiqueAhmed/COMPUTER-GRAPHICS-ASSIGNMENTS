package PS_2_22_9;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.security.SecureRandom;

public class PS_2_22_9_Controller {
    @FXML Pane pane;
    private SecureRandom random = new SecureRandom();
    private int n;
    private int[] dx;
    private int[] dy;
    public void initialize() {
        n = random.nextInt(100) + 21;
        dx = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            Circle circle = new Circle();
            circle.setCenterX(random.nextInt(500) + 201);
            circle.setCenterY(random.nextInt(300) + 201);
            circle.setRadius(random.nextInt(100));
            circle.setFill(randomColor());
            circle.setStrokeWidth(random.nextInt(50));
            circle.setStroke(randomColor());
            pane.getChildren().add(circle);
            dx[i] = 1 + random.nextInt(10);
            dy[i] = 1 + random.nextInt(10);
            int temp = i;
            Timeline timelineAnimation = new Timeline(
                new KeyFrame(Duration.millis(10), e -> moveCircles(circle, temp))
            );
            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
            timelineAnimation.play();
        }
    }
    private void moveCircles(Circle c, int i) {
        c.setCenterX(c.getCenterX() + dx[i]);
        c.setCenterY(c.getCenterY() + dy[i]);
        if (c.getCenterX() + c.getRadius() > pane.getWidth() || c.getCenterX() - c.getRadius() < 0) dx[i] = -dx[i];
        if (c.getCenterY() + c.getRadius() > pane.getHeight() || c.getCenterY() - c.getRadius() < 0) dy[i] = -dy[i];
    }
    private Color randomColor(){
        return Color.rgb(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256),
            (double) random.nextInt(101) / 100);
    }
}