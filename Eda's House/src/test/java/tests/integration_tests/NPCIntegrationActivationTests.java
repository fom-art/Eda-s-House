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
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

import static org.mockito.Mockito.mock;

/**
 * Integration tests for NPC activation.
 */
public class NPCIntegrationActivationTests {

    private GameController gameController;

    @Mock
    private Stage stage;

    @Mock
    private Scene scene;

    @Mock
    private Layout layout;

    private ActivationActions activationActions;
    private MovementActions movementActions;
    private GameLogicHandler gameLogicHandler;

    /**
     * Initializes the necessary objects before each test.
     */
    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);

        stage = mock(Stage.class);
        scene = mock(Scene.class);
        layout = mock(Layout.class);

        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        activationActions = gameController.getSceneListenersSetter().getActivationActions();
        movementActions = gameController.getSceneListenersSetter().getMovementActions();
        gameLogicHandler = gameController.getGameLogicHandler();
    }

    /**
     * Tests the integration of NPC item dropping.
     *
     * @param npcToActivateCode the code of the NPC to activate
     */
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8"})
    public void testIntegrationNPCItemDrop(int npcToActivateCode) {
        TestUtils.clearNPConActivatedStates();
        layout.getWitch().setItemHeld(null);
        layout.getWitch().setPotionHeld(null);
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        Items expectedItem = TestUtils.getExpectedItemHeld(npc);
        npc.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertEquals(expectedItem, layout.getWitch().getItemHeld());
    }

    /**
     * Tests the integration of NPC activation by movement.
     *
     * @param currentX       the current X-coordinate of the character
     * @param currentY       the current Y-coordinate of the character
     * @param directionNumber the direction of movement
     * @param npcHitNumber   the code of the expected NPC hit by the movement
     */
    @ParameterizedTest
    @CsvSource({"1, 5, 3, 3", "5, 4, 4, 5", "8, 5, 1, 8", "9, 4, 4, 8", "8, 9, 1, 7"})
    public void testNpcActivatedByMovement(int currentX, int currentY,
                                           int directionNumber, int npcHitNumber) {
        int[] currentCoordinates = CoordinatesCounter.calculateCoordinates(currentX, currentY);
        ActionsConstants direction = TestUtils.getDirectionFromNumber(directionNumber);
        NonPlayableCharacters expectedNpc = TestUtils.getNPCFromNumber(npcHitNumber);

        layout.getWitch().setCoordinates(currentCoordinates);
        movementActions.receiveAction(direction, true);

        NonPlayableCharacters activatedNpc = gameLogicHandler.getNPCToBeActivated();
        Assertions.assertEquals(expectedNpc, activatedNpc);
    }
}
