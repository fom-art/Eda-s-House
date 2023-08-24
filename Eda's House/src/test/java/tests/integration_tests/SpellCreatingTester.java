package tests.integration_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.model.constants.Items;
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
    @CsvSource({"0, 4, 9, 2", "1, 0, 3, 7", "2, 0, 3, 1", "3, 1, 7, 3", "4, 4, 3, 2"})
    public void testSpellCreated(int expectedPotionCode, int firstItemCode, int secondItemCode, int thirdItemCode) {
        Items[] itemsList = new Items[]{TestUtils.getItemFromNumber(firstItemCode),
                TestUtils.getItemFromNumber(secondItemCode),TestUtils.getItemFromNumber(thirdItemCode)};

        for (Items item : itemsList){
            layout.getWitch().setItemHeld(item);
            activationActions.interactWithPot();
        }

        activationActions.interactWithPot();
        Assertions.assertEquals(TestUtils.getPotionFromNumber(expectedPotionCode), layout.getWitch().getPotionHeld());
    }

    @ParameterizedTest
    @CsvSource({"9, 6, 7, 0"})
    public void testSnakesOilCreation(int expectedItemCode, int firstItemCode, int secondItemCode, int thirdItemCode) {
        Items[] itemsList = new Items[]{TestUtils.getItemFromNumber(firstItemCode),
                TestUtils.getItemFromNumber(secondItemCode),TestUtils.getItemFromNumber(thirdItemCode)};

        for (Items item : itemsList){
            layout.getWitch().setItemHeld(item);
            activationActions.interactWithPot();
        }

        activationActions.interactWithPot();
        Assertions.assertEquals(TestUtils.getItemFromNumber(expectedItemCode), layout.getWitch().getItemHeld());
    }

}
