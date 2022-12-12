package com.vsaprygin.myapplication

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.vsaprygin.myapplication.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
//    lateinit var dao: NoteDao
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
//       val room = Room.databaseBuilder(requireContext(), LocalDB::class.java, "Notes").build()
//           dao = room.noteDao()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener(){
            val title = binding.editTitle.text.toString()
            val content = binding.editContent.text.toString()
            val notes=Notes( title = title, content = content, id=1)
            NotesRepository.add(notes)
//            {dao.insert(notes)}

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}