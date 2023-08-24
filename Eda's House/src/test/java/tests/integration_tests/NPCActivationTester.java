package tests.integration_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.controller.MovementActions;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.CoordinatesCounter;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import utils_for_tests.TestUtils;

import static org.mockito.Mockito.mock;

public class NPCActivationTester {
    private GameController gameController;
    @Mock
    private Stage stage;
    @Mock
    private Scene scene;
    @Mock
    private Layout layout;

    private ActivationActions activationActions;
    private MovementActions movementActions;

    @BeforeEach
    private void init() {
        stage = mock(Stage.class);
        scene = mock(Scene.class);
        gameController = new GameController();
        gameController.startForTest(stage, scene);
        layout = gameController.getLayout();
        activationActions = gameController.getSceneListenersSetter().getActivationActions();
        movementActions = gameController.getSceneListenersSetter().getMovementActions();
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8"})
    public void testRightNpcActivated(int npcToActivateCode) {
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        Items expectedItem = TestUtils.getExpectedItemHeld(npc);
        npc.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertEquals(expectedItem, layout.getWitch().getItemHeld());
        layout.getWitch().setItemHeld(null);
    }

    @ParameterizedTest
    @CsvSource({"1, 5, 3, 3", "5, 4, 4, 5", "8, 5, 1, 8", "9, 4, 4, 8", "8, 9, 1, 7"})
    public void testNpcActivatedByMovement(int currentX, int currentY,
                                              int directionNumber, int npcHitNumber) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        ActionsConstants direction = TestUtils.getDirectionFromNumber(directionNumber);
        NonPlayableCharacters expectedNpc = TestUtils.getNPCFromNumber(npcHitNumber);

        layout.getWitch().setCoordinates(currentCoordinates);
        movementActions.receiveAction(direction, true);

        NonPlayableCharacters activatedNpc = GameLogicHandler.getNPCToBeActivated();
        Assertions.assertEquals(expectedNpc, activatedNpc);
    }


}
