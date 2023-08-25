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
import utils_for_tests.TestUtils;

public class NPCMockitoActivationTests {
    private ActivationActions activationActions;
    @Mock
    private GameLogicHandler gameLogicHandler;
    @Mock
    private PotLogic potLogic;

    @BeforeEach
    public void init() {
        gameLogicHandler = Mockito.mock(GameLogicHandler.class);
        potLogic = Mockito.mock(PotLogic.class);
        activationActions = new ActivationActions(gameLogicHandler, potLogic, PlayableCharacter.WITCH);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4", "5", "6", "7", "8"})
    public void testMockitoNPCItemDrop(int npcToActivateCode) {
        TestUtils.clearNPConActivatedStates();
        PlayableCharacter.WITCH.setItemHeld(null);
        Items expectedItem = TestUtils.getExpectedItemHeld(TestUtils.getNPCFromNumber(npcToActivateCode));

        mockGameLogicHandler(TestUtils.getNPCFromNumber(npcToActivateCode));
        activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);


        Assertions.assertEquals(expectedItem, PlayableCharacter.WITCH.getItemHeld());
    }

    private void mockGameLogicHandler(NonPlayableCharacters npc) {
        Mockito.when(gameLogicHandler.getNPCToBeActivated()).thenReturn(npc);
    }
}
