package App;

import java.awt.Color;

public class Constants {

    public class SelectionConstants {
        /* Background */
        public final static Color BACKGROUND_COLOR = Color.getHSBColor(0f, 0.05f, 0.1f);

        /* Game Boxes */
        public final static Color GAME_BOX_COLOR = Color.getHSBColor(0f, 0.05f, 0.6f);
        public final static Color GAME_BORDER_COLOR = Color.getHSBColor(0f, 0.05f, 0.4f);
    }

    public class SnakeConstants{
            
        /* Color Constants */
        // Background
        public final static Color BACKGROUND_COLOR = Color.getHSBColor(0.8f, 0.05f, 0.9f);
        public final static Color BACKGROUND_CHECKER_COLOR = Color.getHSBColor(0.8f, 0.05f, 0.8f);

        // Snake
        public final static Color SNAKE_BODY_COLOR = Color.getHSBColor(0.3f, 0.5f, 0.3f);
        public final static Color SNAKE_MOUTH_COLOR = Color.getHSBColor(0f, 0.5f, 0.8f);
        public final static Color SNAKE_EYES_COLOR = Color.getHSBColor(0.6f, 0.6f, 0.2f);

        // Food
        public final static Color FOOD_BASE_COLOR = Color.getHSBColor(0f, 0.8f, 0.7f);
        public final static Color FOOD_STEM_COLOR = Color.getHSBColor(0.1f, 0.6f, 0.3f);
        public final static Color FOOD_LEAF_COLOR = Color.getHSBColor(0.3f, 0.6f, 0.5f);


        // Text
        public final static Color TEXT_GAME_OVER_COLOR = Color.getHSBColor(0f, 0.8f, 0.3f);
        public final static Color TEXT_SCORE_COLOR = Color.getHSBColor(0.8f, 0.05f, 0.1f);
        public final static Color TEXT_SPEED_COLOR = Color.getHSBColor(0.8f, 0.05f, 0.3f);

        /* Score */
        public static int high_score = 0;

        /* Tile Constants */
        public static final int TILE_SIZE = 25;

        /* Game Constants */
        public static final int DEFAULT_LOOP_DELAY = 100;
    }

    public class PacmanConstants{
        /* Tiles */
        public static final int ROW_COUNT = 21;
        public static final int COLUMN_COUNT = 19;
        public static final int TILE_SIZE = 32; 

        /* High Score */
        public static int high_score = 0;
    }
}
