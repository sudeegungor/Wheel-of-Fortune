# Wheel-of-Fortune
A Java program for a simple version of the “Wheel of Fortune” (Çarkıfelek) game. Please
keep in mind that the official “Wheel of Fortune” rules and instructions are different
depending on the game version you will implement.
The main aim of the game is to solve the word puzzle and gain money as you can.
Description About the Game
There is only one player.
The game is played with a special wheel that determines the dollar value of the called letters. The wheel is split into 8 segments as
follows: 10, 50, 100, 250, 500, 1000, Double Money, and Bankrupt.
The computer randomly determines a word and then a player tries to guess it by suggesting letters. The word should be a country in
English such as Turkey, Germany, France, Italy, etc. There are 195 countries in the world.
The letters of the hidden word represented by tiles are face down. A player spins the wheel by naming the letters one-by-one to
solve the puzzle. Both consonants and vowels can be guessed by the player after spinning the wheel. If the player guesses a letter
that is part of the word, the computer writes it in all its correct positions. If the called letter cannot be found in the word, the player
cannot earn any money from this turn.
Before guessing a letter, a player must spin the wheel to determine how much each letter, if revealed. Every spin is risky because
the wheel also includes bankrupt, resulting in the loss of all earnings to that point. In the case of “Double Money” segment, the
current amount of money is doubled if the player guesses correctly.
The game is over when the player completes the whole word correctly. The player gets the money he/she earns. 

The Beginning of the Game
Generate a random number (x), print this number on the screen, and get x
th word of S1.
For example; if the randomly generated number is 3, the country “ALGERIA” is selected from the list.
Store this word in a Queue (Q1).
In addition to Q1, create an empty Queue, named Q2, for the game board

Game Playing
The game board (Q2) must be seen on the screen, permanently.
The program should randomly select a letter from S2. After that, the letter should be deleted from S2.
If the selected letter does not exist in Q1, the player does not earn anything in this step.
If the user suggests a letter that exists in Q1, the computer writes it in all its correct positions in Q2. 

Scoring
If the guess is correct, then a prize according to the wheel segment is paid. The amount in the wheel segment is multiplied by the
number of times that the letter appears in the word.
End of the Game
The game is over when the player completes the whole word correctly.
High Score Table
If the player earns a score within the top-10 results, he/she will be displayed in the High-Score table. 
