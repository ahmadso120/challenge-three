package com.sopian.challengethree.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sopian.challengethree.Person
import com.sopian.challengethree.R
import com.sopian.challengethree.databinding.FragmentThirdBinding
import com.sopian.challengethree.utils.oddEven
import com.sopian.challengethree.utils.show

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        val name = args.person.name

        with(binding) {
            navigateToScreen4.setOnClickListener {
                val person = Person(name)
                val action = ThirdFragmentDirections.actionScreen3FragmentToScreen4Fragment(person)
                navController.navigate(action)
            }

            nameTv.text = name

            val savedStateHandle = navController.currentBackStackEntry!!.savedStateHandle
            savedStateHandle.getLiveData<Person>(EXTRA_KEY_PERSON).observe(viewLifecycleOwner) {
                nameTv.text = it.name

                ageLabel.show()
                ageTv.show()
                ageTv.text = getString(R.string.age_string, it.age, it.age?.oddEven())

                addressLabel.show()
                addressTv.show()
                addressTv.text = it.address

                jobLabel.show()
                jobTv.show()
                jobTv.text = it.job
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_KEY_PERSON = "extra_key_person"
    }
}