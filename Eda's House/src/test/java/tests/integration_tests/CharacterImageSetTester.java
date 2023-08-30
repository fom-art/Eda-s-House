package tests.integration_tests;

import com.example.edashouse.controller.GameController;
import com.example.edashouse.controller.MovementActions;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

/**
 * Integration tests for character image setting in response to movement actions.
 */
public class CharacterImageSetTester {

    private GameController gameController;

    @Mock
    private Stage stage;

    @Mock
    private Scene scene;

    private Layout layout;
    private MovementActions movementActions;

    /**
     * Initializes the necessary objects before each test.
     */
    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);

        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        layout = gameController.getLayout();
        movementActions = gameController.getSceneListenersSetter().getMovementActions();
    }

    /**
     * Tests that the character's image is set correctly based on movement direction.
     *
     * @param directionNumber the code representing the movement direction
     */
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4"})
    public void testImageSet(int directionNumber) {
        ActionsConstants direction = TestUtils.getDirectionFromNumber(directionNumber);
        String expectedImageUrl = layout.getWitch().getImageURLFromAction(direction);

        movementActions.receiveAction(direction, true);

        Assertions.assertEquals(expectedImageUrl, layout.getWitch().getCurrentImageURL());
    }
}
