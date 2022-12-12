package com.vsaprygin.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.vsaprygin.myapplication.databinding.FragmentFirstBinding


class FirstFragment() : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    lateinit var dao: NoteDao
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val room = Room.databaseBuilder(requireContext(), LocalDB::class.java, "Notes").build()
        dao = room.noteDao()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.exitBtn.setOnClickListener{
          System.exit(0)
        }
        val adapter = NotesListAdapter()
        adapter.items = NotesRepository.getAll()
        adapter.items.forEach {
          dao.insert(it)
        }
        binding.recyclerView.adapter = adapter
    }


}