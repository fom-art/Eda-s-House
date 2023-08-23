package tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import utils_for_tests.TestUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NPCActivationTester {
    //TODO Check, if activated NPC gives appropriate items
    /**
     * The underlying logic is as follows: each NPC has its own "isToBeActivatedStatus"
     * Therefore, I need to simulate, that called a NPC has it set to true
     * <p>
     * To achieve this goal, the test will be structured into the following steps:
     * <p>
     * - Simulate Layout
     * <p>
     * - Simulate character movement
     * - Verify the outcomes of the simulated movement (coordinates and character direction)
     * - Confirm the object designated for activation
     * <p>
     * - Simulate object activation
     * - Validate the response from the activated object
     */
    @Mock
    private Layout mockedLayout;
    @Mock
    private ActivationActions mockedActivationActions;
    @Mock
    private GameLogicHandler mockedGameLogicHandler;

    private int outcome;

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0", "4, 0", "5, 1", "6, 0", "7, 0", "8, 2"})
    public void testRightNpcActivated(int npcToActivateCode, int expectedOutcome) {
        NonPlayableCharacters npc = TestUtils.getNPCFromNumber(npcToActivateCode);
        assert npc != null;
        Items expectedItem = npc.getItemDropped();

        setMockedActivationActions();
        setMockedGameLogicHandler(npc);

        mockedActivationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);

    }

    private void setMockedGameLogicHandler(NonPlayableCharacters npcToReturn) {
        mockedGameLogicHandler = mock(GameLogicHandler.class);
        when(mockedGameLogicHandler.getNPCToBeActivated()).thenReturn(npcToReturn);
    }

    //TODO finish this method by adding different conditions for
    // methods called in ActivationActions.makeAnAction()
    private void setMockedActivationActions() {
        mockedActivationActions = mock(ActivationActions.class);
    }
}
