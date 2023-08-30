package tests.integration_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.controller.GameController;
import com.example.edashouse.model.constants.Items;
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

import java.util.ArrayList;

/**
 * Integration tests for putting items into the pot.
 */
public class ItemPuttingTester {

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
     * Tests if the correct items are being put into the pot.
     *
     * @param firstItemCode  the code representing the first item
     * @param secondItemCode the code representing the second item
     * @param thirdItemCode  the code representing the third item
     */
    @ParameterizedTest
    @CsvSource({"4, 6, -1", "1, 3, -1", "7, 6, -1", "0, 7, -1", "4, 3, -1", "4, -1, -1", "4, 3, -1", "1, -1, -1",
            "4, 3, -1", "6, 3, -1", "6, 2, -1", "6, -1, -1", "-1, -1, -1"})
    public void testItemsHeldInPot(int firstItemCode, int secondItemCode, int thirdItemCode) {
        ArrayList<Items> itemsList = new ArrayList<>();
        itemsList.add(TestUtils.getItemFromNumber(firstItemCode));
        itemsList.add(TestUtils.getItemFromNumber(secondItemCode));
        itemsList.add(TestUtils.getItemFromNumber(thirdItemCode));

        itemsList.removeIf(item -> item == null);

        for (Items item : itemsList) {
            layout.getWitch().setItemHeld(item);
            activationActions.interactWithPot();
        }

        Assertions.assertEquals(itemsList, activationActions.potLogic().getItemsPut());
    }
}
