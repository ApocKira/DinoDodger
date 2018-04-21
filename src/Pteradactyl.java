import java.util.Random;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Pteradactyl extends Pane{
	/**
	 * @author Shrey Mittal
	 * @brief Pteradactyl module ceates pteradactyl data type using SpriteAnimation
	 */
	ImageView imageView;
	int COUNT = 2;
	int COLUMNS = 2;
	int OFFSET_X = 0; 
	int OFFSET_Y = 0;
	int WIDTH = 92;
	int HEIGHT = 100;
	
	Random r;
	
	SpriteAnimation animation;
	
	/**
	 * @author Shrey Mittal
	 * @brief creates Pteradactyl object
	 * @param imageView Takes ImageView of pterdactyl
	 */
	public Pteradactyl(ImageView imageView){
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));
		
		animation = new SpriteAnimation(imageView, Duration.millis(400), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
		getChildren().addAll(imageView);
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief returns ImageView of pteradactyl object
	 * @return ImageView of pteradactyl object
	 */
	public ImageView getImageView(){
		return this.imageView;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief generates random height for pteradactyl
	 * @return generated random height
	 */
	public int getRandomHeight(){
		int[] h = {250, 350}; 
		return h[r.nextInt(1)];
	}
	
	
}
