package com.kleinreveche.testapps.features.notes.ui.notes

import com.kleinreveche.testapps.features.notes.domain.model.Note
import com.kleinreveche.testapps.features.notes.domain.util.NoteOrder
import com.kleinreveche.testapps.features.notes.domain.util.OrderType

data class NotesState (
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)