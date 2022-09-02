package com.kleinreveche.testapp.features.unscramble.ui

data class UnscrambleGameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 0,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)