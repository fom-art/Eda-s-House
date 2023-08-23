package tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
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
    //TODO Check, if activated NPC gives appropriate items
    private GameController gameController;
    @Mock
    private Stage stage;
    @Mock
    private Scene scene;
    @Mock
    private Layout layout;

    private ActivationActions activationActions;

    @BeforeEach
    private void init() {
        stage = mock(Stage.class);
        scene = mock(Scene.class);
        gameController = new GameController();
        gameController.startForTest(stage, scene);
        layout = gameController.getLayout();
        activationActions = gameController.getSceneListenersSetter().getActivationActions();
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0", "4, 0", "5, 1", "6, 0", "7, 0", "8, 2"})
    public void testRightNpcActivated(int npcToActivateCode, int expectedOutcome) {
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        Items expectedItem = getExpectedItemHeld(npc);
        npc.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertEquals(expectedItem, layout.getWitch().getItemHeld());
        layout.getWitch().setItemHeld(null);
    }

    private Items getExpectedItemHeld(NonPlayableCharacters npc) {
        Items expectedItem = npc.getItemDropped();
        if (expectedItem != Items.EMPTY_ITEM) {
            return expectedItem;
        } else  {
            return null;
        }
    }
}
