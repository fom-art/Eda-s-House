package tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
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

public class SpellCreatingTester {
    //TODO check the creation of spells
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
    @CsvSource({"0, 4, 6, 2", "1, 1, 3, 7", "2, 7, 6, 2", "3, 0, 7, 3", "4, 4, 3, 2",})
    public void testSpellCreated(int expectedPotionCode, int firstItemCode, int secondItemCode, int thirdItemCode) {
        layout.getWitch().setItemHeld(TestUtils.getItemFromNumber(firstItemCode));
        activationActions.interactWithPot();
        layout.getWitch().setItemHeld(TestUtils.getItemFromNumber(secondItemCode));
        activationActions.interactWithPot();
        layout.getWitch().setItemHeld(TestUtils.getItemFromNumber(thirdItemCode));
        activationActions.interactWithPot();

        activationActions.interactWithPot();
        Assertions.assertEquals(TestUtils.getPotionFromNumber(expectedPotionCode), layout.getWitch().getPotionHeld());
    }
}
