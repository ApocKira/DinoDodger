import javafx.scene.image.Image;

public class DinoDodger{
	/**
	 * @author Shrey Mittal
	 * @version 1
	 * @brief DinoDodger is medium of communication between UI and the PlayScene module
	 */
	protected static int POINTS = 0;
	protected static int HIGHSCORE = 0;
	
	//static Image test = new Image("test.png");
	
	static Image character_1 = new Image("images//trex-sprite-1.png"), character_2 = new Image("images//trex-sprite-2.png"), character_3 = new Image("images//trex-sprite-3.png");
	static Image landscape_1 = new Image("images//ground.png"), landscape_2 = new Image("images//ground2.png"), landscape_3 = new Image("images//ground3.png");
	
	/**
	 * @author Shrey Mittal
	 * @brief returns selected Character
	 * @return Image of character selected
	 */
	protected static Image getCharacterSelected(){
		if (UI.c1) return character_1;
		else if (UI.c2) return character_2;
		else if (UI.c3) return character_3;
		return character_1;
	}
	
	/**
	 * @author Shrey Mittal
	 * @brief returns selected Landscape
	 * @return Image of landscape selected
	 */
	protected static Image getLandScapeSelected(){
		if (UI.l1) return landscape_1;
		else if (UI.l2) return landscape_2;
		else if (UI.l3) return landscape_3;
		return landscape_1;
	}
}
