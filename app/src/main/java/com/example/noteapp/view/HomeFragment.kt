package com.example.noteapp.view

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteapp.R
import com.example.noteapp.adapter.NotesAdapter
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.model.NoteModel
import com.example.noteapp.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: MainViewModel by viewModels()
    var oldMyNotes = arrayListOf<NoteModel>()
    lateinit var adapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        //layout manager
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rcvAllNotes.layoutManager = staggeredGridLayoutManager

        //get all notes
        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
            oldMyNotes = notesList as ArrayList<NoteModel>
            adapter = NotesAdapter(requireContext(), notesList)
            binding.rcvAllNotes.adapter = adapter
        }

        //filter critical
        binding.filterOrange.setOnClickListener {
            viewModel.getCriticalNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        //filter high
        binding.filterBlue.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }
        //filter all notes
        binding.allNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }
        //filter low
        binding.filterGreen.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        //filter routine
        binding.filterLightPink.setOnClickListener {
            viewModel.getRoutineNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        //filter medium
        binding.filterPink.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner) { notesList ->
                oldMyNotes = notesList as ArrayList<NoteModel>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)
        }
        return binding.root
    }

    //Option Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)

        val item = menu.findItem(R.id.app_bar_search)
        val searchView = item.actionView as SearchView
        searchView.queryHint = "Enter Notes Here..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                NotesFilteting(p0)
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    //Notes Filter
    private fun NotesFilteting(p0: String?) {

        val newFilteredList = arrayListOf<NoteModel>()

        for (i in oldMyNotes) {
            if (i.title.contains(p0!!) || i.subTitle.contains(p0)) {
                newFilteredList.add(i)
            }
        }
        adapter.filtering(newFilteredList)
    }
}