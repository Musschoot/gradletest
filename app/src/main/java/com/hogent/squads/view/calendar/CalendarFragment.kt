package com.hogent.squads.view.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.hogent.squads.databinding.FragmentCalendarBinding
import com.hogent.squads.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var userViewModel: UserViewModel
    private var _binding: FragmentCalendarBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
        println("createdCalendarFragment onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val view = binding.root

        userViewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        println("createdCalendarFragment onCreateView()")
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
