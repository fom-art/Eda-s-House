package mockito_tests;

import com.example.edashouse.controller.ActivationActions;
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

import static org.mockito.Mockito.when;

/**
 * Unit tests to ensure the responsiveness of the pot interaction using the Mockito framework.
 */
public class MockitoPotResponsivenessTests {

    @Mock
    private PotLogic potLogic;
    @Mock
    private GameLogicHandler gameLogicHandler;
    private ActivationActions activationActions;

    /**
     * Initializes mock objects and the ActivationActions before each test.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        activationActions = new ActivationActions(gameLogicHandler, potLogic, PlayableCharacter.WITCH);
    }

    /**
     * Tests the responsiveness of the pot when creating different potions.
     *
     * @param potionNumber the number representing the potion
     */
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4"})
    public void testPotResponsibility(int potionNumber) {
        // Get the expected potion
        Potions potion = TestUtils.getPotionFromNumber(potionNumber);

        // Mock game logic for interaction with the pot
        when(gameLogicHandler.getNPCToBeActivated()).thenReturn(NonPlayableCharacters.POT);
        // Mock the potion result from pot logic
        when(potLogic.getPotionResult()).thenReturn(potion);

        // Perform interaction with the pot
        activationActions.interactWithPot();

        // Assert the potion held by the witch after the interaction
        Assertions.assertEquals(potion, PlayableCharacter.WITCH.getPotionHeld());
    }
}
