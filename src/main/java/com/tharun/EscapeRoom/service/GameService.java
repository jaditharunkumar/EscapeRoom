package com.tharun.EscapeRoom.service;

import org.springframework.stereotype.Service;

import com.tharun.EscapeRoom.model.GameProgress;

@Service
public class GameService {

    // CHECK DOOR
    public String checkDoor(GameProgress gameProgress) {

        gameProgress.setAttempts(gameProgress.getAttempts() + 1);

        if (gameProgress.isHasKey()) {

            gameProgress.setEscaped(true);

            return "You have the key! 🔑 You opened the door! 🚪 "
                    + "🎉 CONGRATULATIONS! YOU ESCAPED!";

        } else {

            return "The door is locked! 🔒 You need a key to open it.";
        }
    }

    // SEARCH ROOM
    public String searchRoom(GameProgress gameProgress, int searchChoice) {

        gameProgress.setAttempts(gameProgress.getAttempts() + 1);

        switch (searchChoice) {

        case 1:

            gameProgress.setHasClue(true);

            return "You searched under the table. You found a clue! 📜 "
                    + "The clue says: \"Look at the painting.\"";

        case 2:

            return "You searched on the table. Oops! Nothing useful here.";

        case 3:

            return "You searched behind the table. Oops! Nothing useful here.";

        case 4:

            return "Going back to the main menu...";

        default:

            return "Invalid choice.";
        }
    }

    // CHECK PAINTING
    public String checkPainting(GameProgress gameProgress, String buttonChoice) {

        gameProgress.setAttempts(gameProgress.getAttempts() + 1);

        if (gameProgress.isHasClue()) {

            if (buttonChoice.equalsIgnoreCase("y")) {

                gameProgress.setDrawerUnlocked(true);

                return "You remembered the clue. You checked the painting. 🖼️ "
                        + "You found a hidden button! 🔘 "
                        + "You pressed the button. CLICK! 🔊 "
                        + "The drawer has been unlocked! 🗄️";

            } else {

                return "You remembered the clue. You checked the painting. 🖼️ "
                        + "You found a hidden button! 🔘 "
                        + "You did not press the button.";
            }

        } else {

            return "You don't know what to look for. "
                    + "Find the clue first.";
        }
    }
    
 // OPEN DRAWER
    public String openDrawer(GameProgress gameProgress) {

        gameProgress.setAttempts(gameProgress.getAttempts() + 1);

        if (gameProgress.isDrawerUnlocked()) {

            if (!gameProgress.isHasKey()) {

                gameProgress.setHasKey(true);

                return "The drawer is unlocked! 🗄️ "
                        + "You opened the drawer. "
                        + "You found a KEY! 🔑";

            } else {

                return "You already found the key.";
            }

        } else {

            return "The drawer is locked! 🔒 "
                    + "You need to unlock it first.";
        }
    }
}