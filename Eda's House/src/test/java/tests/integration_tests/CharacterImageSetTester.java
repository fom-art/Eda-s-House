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

public class CharacterImageSetTester {
    private GameController gameController;
    @Mock
    private Stage stage;
    @Mock
    private Scene scene;
    private Layout layout;



    private MovementActions movementActions;

    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);

        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        layout = gameController.getLayout();
        movementActions = gameController.getSceneListenersSetter().getMovementActions();
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4"})
    public void testImageSet(int directionNumber) {
        ActionsConstants direction = TestUtils.getDirectionFromNumber(directionNumber);
        String expectedImageUrl = layout.getWitch().getImageURLFromAction(direction);

        movementActions.receiveAction(direction, true);

        Assertions.assertEquals(expectedImageUrl, layout.getWitch().getCurrentImageURL());
    }
}
