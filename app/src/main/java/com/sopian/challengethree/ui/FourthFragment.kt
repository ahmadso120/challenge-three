package com.sopian.challengethree.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sopian.challengethree.Person
import com.sopian.challengethree.databinding.FragmentFourthBinding
import com.sopian.challengethree.ui.ThirdFragment.Companion.EXTRA_KEY_PERSON
import com.sopian.challengethree.utils.isValid
import com.sopian.challengethree.utils.shortToast

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    private val args: FourthFragmentArgs by navArgs()

    private var ageTextWatcher: TextWatcher? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val savedStateHandle = navController.previousBackStackEntry!!.savedStateHandle

        with(binding) {
            ageTextWatcher = object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (ageEdt.text.toString().trim().length == 2) {
                        jobEdt.requestFocus()
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            }
            ageEdt.addTextChangedListener(ageTextWatcher)

            navigateBackToScreen3.setOnClickListener {
                val age = ageEdt.text.toString().trim()
                val address = addressEdt.text.toString().trim()
                val job = jobEdt.text.toString().trim()

                if (!age.isValid() && !address.isValid() && !job.isValid()) {
                    requireActivity().shortToast("Tolong lengkapi data")
                    return@setOnClickListener
                }

                val person = Person(
                    args.person.name,
                    address,
                    age.toInt(),
                    job
                )

                savedStateHandle.set(EXTRA_KEY_PERSON, person)
                navController.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.ageEdt.removeTextChangedListener(ageTextWatcher)
        _binding = null
    }
}