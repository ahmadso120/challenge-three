package com.sopian.challengethree.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sopian.challengethree.Person
import com.sopian.challengethree.databinding.FragmentSecondBinding
import com.sopian.challengethree.utils.isValid
import com.sopian.challengethree.utils.shortToast

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            navigateToScreen3.setOnClickListener {
                val name = nameEdt.text.toString().trim()

                if (!name.isValid()) {
                    requireActivity().shortToast("Name is required")
                    return@setOnClickListener
                }

                val person = Person(name)
                val action = SecondFragmentDirections.actionScreen2FragmentToScreen3Fragment(person)
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}