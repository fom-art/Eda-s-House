package tests.integration_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
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
 * Integration tests for the playable character's inventory interactions.
 */
public class PlayableCharacterInventoryTester {

    private GameController gameController;

    @Mock
    private Stage stage;

    @Mock
    private Scene scene;

    private Layout layout;

    private ActivationActions activationActions;

    /**
     * Initializes the necessary objects before each test.
     */
    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);

        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        layout = gameController.getLayout();
        activationActions = gameController.getSceneListenersSetter().getActivationActions();
    }

    /**
     * Tests the freeing of item held in the character's inventory after pot interaction.
     *
     * @param npcToActivateCode the code of the NPC to activate
     */
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "6", "7"})
    public void testItemHeldFreeingAfterPotInteraction(int npcToActivateCode) {
        activationActions.potLogic().clear();
        TestUtils.clearNPConActivatedStates();
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        Items item = TestUtils.getExpectedItemHeld(npc);
        layout.getWitch().setItemHeld(item);

        NonPlayableCharacters pot = NonPlayableCharacters.POT;

        pot.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertNull(layout.getWitch().getItemHeld());
    }

    /**
     * Tests the freeing of potion held in the character's inventory after windowsill interaction.
     *
     * @param potionToSellNumber the code of the potion to sell
     */
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4"})
    public void testPotionHeldFreeingAfterWindowsillInteraction(int potionToSellNumber) {
        Potions potion = TestUtils.getPotionFromNumber(potionToSellNumber);
        layout.getWitch().setPotionHeld(potion);

        NonPlayableCharacters windowsill = NonPlayableCharacters.WINDOWSILL;

        windowsill.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertNull(layout.getWitch().getPotionHeld());
    }
}
