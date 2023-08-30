package mockito_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.PotLogic;
import com.example.edashouse.model.utils.GameLogicHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

/**
 * Unit tests using the Mockito framework to simulate NPC activation and item dropping.
 */
public class NPCMockitoActivationTests {

    private ActivationActions activationActions;

    @Mock
    private GameLogicHandler gameLogicHandler;
    @Mock
    private PotLogic potLogic;

    /**
     * Initializes mock objects and the ActivationActions before each test.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        activationActions = new ActivationActions(gameLogicHandler, potLogic, PlayableCharacter.WITCH);
    }

    /**
     * Tests NPC activation and item dropping using Mockito framework.
     *
     * @param npcToActivateCode the code representing the NPC to activate
     */
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8"})
    public void testMockitoNPCItemDrop(int npcToActivateCode) {
        // Clear NPC activation states and held items before the test
        TestUtils.clearNPConActivatedStates();
        PlayableCharacter.WITCH.setItemHeld(null);
        PlayableCharacter.WITCH.setPotionHeld(null);

        // Get the expected item based on the activated NPC
        Items expectedItem = TestUtils.getExpectedItemHeld(TestUtils.getNPCFromNumber(npcToActivateCode));

        // Mock the game logic handler to simulate NPC activation
        mockGameLogicHandler(TestUtils.getNPCFromNumber(npcToActivateCode));
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

        // Assert that the expected item is now held by the witch
        Assertions.assertEquals(expectedItem, PlayableCharacter.WITCH.getItemHeld());
    }

    /**
     * Mocks the game logic handler to simulate NPC activation.
     *
     * @param npc the NPC to be activated
     */
    private void mockGameLogicHandler(NonPlayableCharacters npc) {
        Mockito.when(gameLogicHandler.getNPCToBeActivated()).thenReturn(npc);
    }
}
