package com.vsaprygin.myapplication

class NotesRepository {
    private val list = mutableListOf<Notes>()
    init {
        for (i in 1..10) {
            val notes = Notes(i, "title", "Content")
            list.add(notes)
        }
    }
    fun getAll() = list
}