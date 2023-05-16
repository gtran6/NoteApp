package com.example.noteapp.view

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentCreateNotesBinding
import com.example.noteapp.model.NoteModel
import com.example.noteapp.viewmodel.MainViewModel
import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binding.pPink.setImageResource(R.drawable.ic_baseline_done_24)

        binding.pPink.setOnClickListener {
            priority = "1"
            binding.pPink.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pBlue.setImageResource(0)
            binding.pGreen.setImageResource(0)
            binding.pLightPink.setImageResource(0)
        }
        binding.pBlue.setOnClickListener {
            priority = "2"
            binding.pBlue.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pPink.setImageResource(0)
            binding.pGreen.setImageResource(0)
            binding.pLightPink.setImageResource(0)
        }
        binding.pOrange.setOnClickListener {
            priority = "3"
            binding.pOrange.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pPink.setImageResource(0)
            binding.pBlue.setImageResource(0)
            binding.pGreen.setImageResource(0)
            binding.pLightPink.setImageResource(0)
        }
        binding.pGreen.setOnClickListener {
            priority = "4"
            binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pPink.setImageResource(0)
            binding.pBlue.setImageResource(0)
            binding.pLightPink.setImageResource(0)
        }
        binding.pLightPink.setOnClickListener {
            priority = "5"
            binding.pLightPink.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pOrange.setImageResource(0)
            binding.pPink.setImageResource(0)
            binding.pBlue.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }


        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        return binding.root
    }

    private fun createNotes(it: View?) {

        val title = binding.edtTitle.text.toString()
        val subTitle = binding.edtSubTitle.text.toString()
        val notes = binding.edtNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = NoteModel(
            null,
            title = title,
            subTitle = subTitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }
}