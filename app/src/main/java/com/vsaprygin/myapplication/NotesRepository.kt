package com.vsaprygin.myapplication

class NotesRepository (private val dao: NoteDao) {
    val list = dao.getAll()

    companion object {
        private val list = mutableListOf<Notes>()
        private var countId =0

        fun getAll() = list
        fun add(notes: Notes){
            notes.id = countId
            countId++
            list.add(notes)
        }

    }
}