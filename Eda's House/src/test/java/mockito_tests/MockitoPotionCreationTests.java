package mockito_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.utils.PotLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class MockitoPotionCreationTests {
    @Mock
    private GameLogicHandler gameLogicHandler;
    private ActivationActions activationActions;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({"0, 4, 9, 2", "1, 0, 3, 7", "2, 0, 3, 1", "3, 1, 7, 3", "4, 4, 3, 2"})
    public void testSpellCreated(int expectedPotionCode, int firstItemCode, int secondItemCode, int thirdItemCode) {
        ArrayList<Items> itemsArrayList = new ArrayList<>();
        itemsArrayList.add(TestUtils.getItemFromNumber(firstItemCode));
        itemsArrayList.add(TestUtils.getItemFromNumber(secondItemCode));
        itemsArrayList.add(TestUtils.getItemFromNumber(thirdItemCode));

        mockActivationAction(itemsArrayList);

        Potions potion = TestUtils.getPotionFromNumber(expectedPotionCode);

        when(gameLogicHandler.getNPCToBeActivated()).thenReturn(NonPlayableCharacters.POT);

        activationActions.startMakingPotion();
        activationActions.interactWithPot();

        Assertions.assertEquals(potion, PlayableCharacter.WITCH.getPotionHeld());
    }

    private void mockActivationAction(ArrayList<Items> itemsArrayList) {
        activationActions = new ActivationActions(gameLogicHandler, new PotLogic(itemsArrayList), PlayableCharacter.WITCH);
    }
}
