package com.kleinreveche.testapps.features.notes.domain.use_case

import com.kleinreveche.testapps.features.notes.domain.model.Note
import com.kleinreveche.testapps.features.notes.domain.repository.NoteRepository

class GetNote (
    private val repository: NoteRepository
        ){

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}