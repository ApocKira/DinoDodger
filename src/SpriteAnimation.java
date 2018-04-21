import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition{
	/**
	 * @author Shrey Mittal
	 * @version 1
	 * @brief SpriteAnimation animates a sprite image at particular frequency
	 */
	private final ImageView imageView;
	private final int COUNT;
	private final int COLUMNS;
	private int OFFSET_X, OFFSET_Y;
	private final int WIDTH, HEIGHT;
	
	/**
	 * @author Shrey Mittal
	 * @brief creates SpriteAnimation object
	 * @param imageView ImageView of Sprite image
	 * @param duration Duration of repetition of animation
	 * @param count Number of Images to iterate through
	 * @param columns Number of columns in image
	 * @param offSetX Column offset
	 * @param offSetY Row offset
	 * @param width width of image unit in sprite
	 * @param height height of image unit in sprite
	 */
	public SpriteAnimation(ImageView imageView, Duration duration, int count, int columns, int offSetX, int offSetY, int width, int height){
		this.imageView = imageView;
		this.COUNT = count;
		this.COLUMNS = columns;
		this.OFFSET_X = offSetX;
		this.OFFSET_Y = offSetY;
		this.WIDTH = width;
		this.HEIGHT = height;
		setCycleDuration(duration);
		setCycleCount(Animation.INDEFINITE);
		setInterpolator(Interpolator.LINEAR);
		this.imageView.setViewport(new Rectangle2D(offSetX, offSetY, width, height));
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief Mutates offsetX
	 * @param x ffSet factor
	 */
	protected void setOffSetX(int x){
		this.OFFSET_X = x;
	}
	/**
	 * @author Shrey Mittal
	 * @brief Mutates offsetY
	 * @param y offset factor
	 */
	protected void setOffSetY(int y){
		this.OFFSET_Y = y;
	}

	/**
	 * @author Shrey Mittal
	 * @brief interpolates image
	 * @param frac factor required to interpolate sprite
	 */
	@Override
	protected void interpolate(double frac) {
		final int index = Math.min((int)Math.floor(COUNT*frac), COUNT-1);
		final int x = (index%COLUMNS)*WIDTH+OFFSET_X;
		final int y = (index/COLUMNS)*HEIGHT+OFFSET_Y;
		imageView.setViewport(new Rectangle2D(x, y, WIDTH, HEIGHT));
		
	}
}