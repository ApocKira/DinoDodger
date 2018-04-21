import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class Character extends Pane{
	/**
	 * @author Shrey Mittal
	 * @version 1
	 * @brief Character module creates a Character data type using SpriteAnimation
	 */
	ImageView imageView;
	private static final int COUNT = 2;
	private static final int COLUMNS = 2;
	private static int OFFSET_X = 0; 
	private static int OFFSET_Y = 0;
	private static final int WIDTH = 88;
	private static final int HEIGHT = 100;
	
	int xpos = 30, ypos = 300;
	
	
	static Path path = new Path();
	static PathTransition pathTransition = new PathTransition();
	
	SpriteAnimation animation;
	
	/**
	 * @author Shrey Mittal
	 * @brief Creates Character object
	 * @param imageView ImageView of Character sprite image
	 */
	public Character(ImageView imageView){
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));
		this.imageView.setX(xpos);
		this.imageView.setY(ypos);
		
		animation = new SpriteAnimation(imageView, Duration.millis(200), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
		getChildren().addAll(imageView);
		
		path.getElements().add(new MoveTo(74,350));
    	path.getElements().add(new LineTo(74,150));
    	path.getElements().add(new LineTo(74,350));
		pathTransition.setDuration(Duration.millis(800));
		pathTransition.setCycleCount(1);
		pathTransition.setPath(path);
		pathTransition.setNode(this.imageView);
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief returns ImageView of Character
	 * @return ImageView of Character
	 */
	protected ImageView getImageView(){
		return this.imageView;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief Makes character virtually jump
	 */
	protected void jump(){
		pathTransition.play();
	}	
}
