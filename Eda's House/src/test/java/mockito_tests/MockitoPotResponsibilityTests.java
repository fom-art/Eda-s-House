package mockito_tests;

import com.example.edashouse.controller.ActivationActions;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.utils.PotLogic;
import com.example.edashouse.model.utils.PotionsLogicHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils_for_tests.TestUtils;

import static org.mockito.Mockito.when;

public class MockitoPotResponsibilityTests {
    @Mock
    private PotLogic potLogic;
    @Mock
    private PotionsLogicHandler potionsLogicHandler;
    @Mock
    private GameLogicHandler gameLogicHandler;
    private ActivationActions activationActions;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        activationActions = new ActivationActions(gameLogicHandler, potLogic, PlayableCharacter.WITCH);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3", "4"})
    public void testPotResponsibility(int potionNumber) {
        Potions potion = TestUtils.getPotionFromNumber(potionNumber);

        when(gameLogicHandler.getNPCToBeActivated()).thenReturn(NonPlayableCharacters.POT);
        when(potLogic.getPotionResult()).thenReturn(potion);

        activationActions.interactWithPot();

        Assertions.assertEquals(potion, PlayableCharacter.WITCH.getPotionHeld());
    }
}
