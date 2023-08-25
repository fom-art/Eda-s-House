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

public class ItemPuttingTester {
    //TODO Test if right items are being put into the pot
    private GameController gameController;
    @Mock
    private Stage stage;
    @Mock
    private Scene scene;
    private Layout layout;

    private ActivationActions activationActions;

    @BeforeEach
    private void init() {
        MockitoAnnotations.openMocks(this);
        gameController = new GameController();
        gameController.startForTest(stage, scene, new GameLogicHandler());
        layout = gameController.getLayout();
        activationActions = gameController.getSceneListenersSetter().getActivationActions();
    }

    /**
     * @param firstItemCode
     * @param secondItemCode
     * @param thirdItemCode  Some parameters may have number value -1.
     *                       Such parameters mean that I want to make these slots empty.
     *                       I make it to check cases when pot is not fully filled.
     */
    @ParameterizedTest
    @CsvSource({"4, 6, -1", "1, 3, -1", "7, 6, -1", "0, 7, -1", "4, 3, -1", "4, -1, -1", "4, 3, -1", "1, -1, -1",
            "4, 3, -1", "6, 3, -1", "6, 2, -1", "6, -1, -1", "-1, -1, -1"})
    public void testItemsHeldInPot(int firstItemCode, int secondItemCode, int thirdItemCode) {
        ArrayList<Items> itemsList = new ArrayList<>();
        itemsList.add(TestUtils.getItemFromNumber(firstItemCode));
        itemsList.add(TestUtils.getItemFromNumber(secondItemCode));
        itemsList.add(TestUtils.getItemFromNumber(thirdItemCode));
        for (int i = 0; i < 3; i++) {
            itemsList.remove(null);
        }
        for (Items item : itemsList) {
            if (item != null) {
                layout.getWitch().setItemHeld(item);
                activationActions.interactWithPot();
            }
        }
        Assertions.assertEquals(itemsList, activationActions.potLogic().getItemsPut());
    }
}
