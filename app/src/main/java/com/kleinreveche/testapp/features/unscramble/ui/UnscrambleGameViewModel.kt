package com.kleinreveche.testapp.features.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kleinreveche.testapp.features.unscramble.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel containing the app data and methods to process the data
 */
class UnscrambleGameViewModel : ViewModel() {

    // Game UI state
    private val _uiState = MutableStateFlow(UnscrambleGameUiState())
    val uiState: StateFlow<UnscrambleGameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    init {
        resetGame()
    }

    /*
     * Re-initializes the game data to restart the game.
     */
    fun resetGame() {
        usedWords.clear()
        _uiState.value = UnscrambleGameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    /*
     * Update the user's guess
     */
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /*
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // User's guess is correct, increase the score
            // and call updateGameState() to prepare the game for next
            var updatedScore = 0
            when{
                currentWord.length <= 3 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
                currentWord.length == 4 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_FOUR).toInt()
                currentWord.length == 5 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_FIVE).toInt()
                currentWord.length == 6 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_SIX).toInt()
                currentWord.length == 7 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_EIGHT).toInt()
                currentWord.length == 8 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_NINE).toInt()
                currentWord.length == 9 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_TEN).toInt()
                currentWord.length == 10 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_ELEVEN).toInt()
                currentWord.length >= 11 -> updatedScore = _uiState.value.score.plus(SCORE_INCREASE).times(SCORE_MULTIPLIER_TWELVE).toInt()
            }
            updateGameState(updatedScore)
        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }

    /*
     * Skip to next word
     */
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    /*
     * Picks a new currentWord and currentScrambledWord and updates UiState according to
     * current game state.
     */
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            //Last round in the game, update isGameOver to true, don't pick a new word
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }
}