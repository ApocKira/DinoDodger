import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PointCounter extends TimerTask {
	/**
	 * @author Shrey Mittal
	 * @brief This module keeps track of points and highscore of user during Gameplay by creating PointCounter data type
	 * @version 1
	 */
	private static int points;
	private static int highscore;
	private static Timer timer;
	static Scanner sc;
	
	/**
	 * @author Shrey Mittal
	 * @brief Creates PointCounter object
	 * @param initial_points initial points value
	 * @param initial_highscore initial highscore value
	 */
	protected PointCounter(int initial_points, int initial_highscore){
		points = initial_points;
		highscore = initial_highscore;
		timer = new Timer();
		timer.schedule(this, 0, 100);
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief Stops counting points once collision detected
	 */
	protected void hasCollided(){
		timer.cancel();
		timer.purge();
		updateHighScore();
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief shows current points
	 * @return points
	 */
	protected int showPoints(){
		return points;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief shows current highscore
	 * @return highscore
	 */
	protected int showHighScore(){
		return highscore;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief updates highscore
	 */
	protected void updateHighScore(){
		if (points > highscore) highscore = points;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief resets points and highscore values to 0
	 */
	protected void reset(){
		points = 0;
		highscore = 0;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief produces String statement of points and highscore
	 * @return String of points and highscore
	 */
	protected String getRunningScore(){
		return ("SCORE: " + showPoints() + " || HIGHSCORE: " + showHighScore());
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief Increments points
	 */
	@Override
	public void run() {		
		points+=1;
	}
	
	//for demo
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in); // to simulate input
//		PointCounter pc = new PointCounter(0, 0);
//		while (true){
//			if (sc.nextInt() == 0) {
//				pc.hasCollided(); 
//			}
//			System.out.println(pc.getRunningScore());
//			System.out.println("Play Again? 1=continue 0=end");
//			if (sc.nextInt() == 1) { 
//				int h = pc.showHighScore();
//				pc = new PointCounter(0, h);
//			}
//			else break;			
//		}
//		System.out.println("Game Over!");
//		sc.close();
//	}
	
}
