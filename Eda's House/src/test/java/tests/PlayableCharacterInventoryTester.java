package tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
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

public class PlayableCharacterInventoryTester {
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
    @CsvSource({"0", "1", "2", "3", "4", "6", "7"})
    public void testItemHeldFreeingAfterPotInteraction(int npcToActivateCode) {
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        Items item = TestUtils.getExpectedItemHeld(npc);
        layout.getWitch().setItemHeld(item);

        NonPlayableCharacters pot = NonPlayableCharacters.POT;

        pot.setToBeActivated(true);
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        Assertions.assertNull(layout.getWitch().getItemHeld());
        activationActions.getPotLogic().clear();
    }

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
