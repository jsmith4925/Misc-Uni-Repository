#include <iostream>
#include <string>
#include <stdio.h> 
#include <stdlib.h>    
#include <time.h>

enum Moves{
    Rock,
    Paper,
    Scissors
};

enum Results{
    Win,
    Loss,
    Draw
};

int wins, losses, draws = 0;

int getComputerChoice() {
    /* random int between 0 and 2 */
    srand(time(NULL));
    int computerChoice = rand() % 3;
    
    switch (computerChoice) {
        case 0:
            std::cout << "Computer plays: Rock" << std::endl;
            break;
        case 1:
            std::cout << "Computer plays: Paper" << std::endl;
            break;
        case 2:
            std::cout << "Computer plays: Scissors" << std::endl;
            break;
    }
    return computerChoice;
}

int getPlayerChoice() {

    char userInput;
    Moves userMove;

    std::cout << "Pick either (R)ock,(P)aper, or (S)cissors. \n";
    std::cin >> userInput;
    userInput = toupper(userInput);

    switch (userInput) {
    case 'R':
        userMove = Rock;
        break;
    case 'P':
        userMove = Paper;
        break;
    case 'S':
        userMove = Scissors;
        break;
    default:
        std::cout << "NO" << std::endl;
        getPlayerChoice();
    }

    return userMove;
}

int updateResults(int result) {
    
    switch (result) {
        case 0:
            std::cout << "You win!" << std::endl;
            wins++;
            break;
        case 1:
            std::cout << "You lost :(" << std::endl;
            losses++;
            break;
        case 2:
            std::cout << "DRAW!" << std::endl;
            draws++;
            break;
        default:
            break;
    }
}

int playRound(){

    int p = getPlayerChoice();
    int c = getComputerChoice();

    if (p == c) {
        updateResults(Results::Draw);
    }
    else if ((p - c) % 3 == 1) {
        updateResults(Win);
    }
    else {
        updateResults(Loss);
    }
}

int gameLoop() {
    bool game = true;
    char playAgainChoice;


    while (game) {

        playRound();
        
        std::cout << "Play again? (Y/N): ";
        std::cin >> playAgainChoice;
        playAgainChoice = toupper(playAgainChoice);

        if (playAgainChoice == 'N') {
            game = false;
        }
    
    }

}

int main() {
    gameLoop();
    return 0;
}