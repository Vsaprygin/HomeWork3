package com.vsaprygin.myapplication

class NotesRepository {
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