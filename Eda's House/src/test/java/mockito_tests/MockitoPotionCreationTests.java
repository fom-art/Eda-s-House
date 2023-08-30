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

/**
 * Unit tests for potion creation using the Mockito framework.
 */
public class MockitoPotionCreationTests {

    @Mock
    private GameLogicHandler gameLogicHandler;
    private ActivationActions activationActions;

    /**
     * Initializes mock objects before each test.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the creation of a spell based on various item combinations.
     *
     * @param expectedPotionCode the expected potion code
     * @param firstItemCode      the code of the first item
     * @param secondItemCode     the code of the second item
     * @param thirdItemCode      the code of the third item
     */
    @ParameterizedTest
    @CsvSource({"0, 4, 9, 2", "1, 0, 3, 7", "2, 0, 3, 1", "3, 1, 7, 3", "4, 4, 3, 2"})
    public void testSpellCreated(int expectedPotionCode, int firstItemCode, int secondItemCode, int thirdItemCode) {
        // Prepare item array list
        ArrayList<Items> itemsArrayList = new ArrayList<>();
        itemsArrayList.add(TestUtils.getItemFromNumber(firstItemCode));
        itemsArrayList.add(TestUtils.getItemFromNumber(secondItemCode));
        itemsArrayList.add(TestUtils.getItemFromNumber(thirdItemCode));

        // Mock activation actions
        mockActivationAction(itemsArrayList);

        // Get expected potion
        Potions potion = TestUtils.getPotionFromNumber(expectedPotionCode);

        // Mock game logic for interaction with the pot
        when(gameLogicHandler.getNPCToBeActivated()).thenReturn(NonPlayableCharacters.POT);

        // Perform actions to create the potion
        activationActions.startMakingPotion();
        activationActions.interactWithPot();

        // Assert the potion held by the witch
        Assertions.assertEquals(potion, PlayableCharacter.WITCH.getPotionHeld());
    }

    /**
     * Mocks the activation actions for potion creation.
     *
     * @param itemsArrayList the list of items for potion creation
     */
    private void mockActivationAction(ArrayList<Items> itemsArrayList) {
        activationActions = new ActivationActions(gameLogicHandler, new PotLogic(itemsArrayList), PlayableCharacter.WITCH);
    }
}
