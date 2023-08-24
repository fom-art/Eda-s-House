package utils_for_tests;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;

public class TestUtils {
    /**
     * 1-right 2-left 3-up 4-down
     */
    public static ActionsConstants getDirectionFromNumber(int number) {
        switch (number) {
            case 1 -> {
                return ActionsConstants.RIGHT_KEY_PRESSED;
            }
            case 2 -> {
                return ActionsConstants.LEFT_KEY_PRESSED;
            }
            case 3 -> {
                return ActionsConstants.UP_KEY_PRESSED;
            }
            case 4 -> {
                return ActionsConstants.DOWN_KEY_PRESSED;
            }
        }
        return ActionsConstants.ESC_KEY_PRESSED;
    }

    public static NonPlayableCharacters getNPCFromNumber(int number) {
        switch (number) {
            case 0 -> {
                return NonPlayableCharacters.BELLFLOWER;
            }
            case 1 -> {
                return NonPlayableCharacters.BUGS;
            }
            case 2 -> {
                return NonPlayableCharacters.HUMANS_GARBAGE;
            }
            case 3 -> {
                return NonPlayableCharacters.KING;
            }
            case 4 -> {
                return NonPlayableCharacters.MOUSES;
            }
            case 5 -> {
                return NonPlayableCharacters.POT;
            }
            case 6 -> {
                return NonPlayableCharacters.SNAKES;
            }
            case 7 -> {
                return NonPlayableCharacters.SPIDERS;
            }
            case 8 -> {
                return NonPlayableCharacters.WINDOWSILL;
            }
        }
        return null;
    }

    public static Items getItemFromNumber(int number) {
        NonPlayableCharacters npc = getNPCFromNumber(number);
        if (npc != null) {
            return npc.getItemDropped();
        }
        else if (number == 9) {
            return Items.SNAKES_OIL;
        }
        return null;
    }

    public static Potions getPotionFromNumber(int number) {
        switch (number) {
            case 0 -> {
                return Potions.ELIXIR;
            }
            case 1 -> {
                return Potions.EXPLOSION_POTION;
            }
            case 2 -> {
                return Potions.FORESEEING_POTION;
            }
            case 3 -> {
                return Potions.MIST_POTION;
            }
            case 4 -> {
                return Potions.SUSPICIOUS_POTION;
            }
        }
        return null;
    }

    public static Items getExpectedItemHeld(NonPlayableCharacters npc) {
        Items expectedItem = npc.getItemDropped();
        if (expectedItem != Items.EMPTY_ITEM) {
            return expectedItem;
        } else  {
            return null;
        }
    }
}
