package com.example.simpleviewmodelkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simpleviewmodelkotlin.databinding.FragmentFirstBinding
import java.util.jar.Attributes.Name

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PersonViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGreet.setOnClickListener {
            val name = binding.editTextName.text.trim().toString()
            if (name.isEmpty()) {
                binding.editTextName.error = "No name"
                return@setOnClickListener
            }
            val ageStr = binding.editTextAge.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.editTextAge.error = "No age"
            }
            val salaryStr = binding.editTextSalary.text.trim().toString()
            if (salaryStr.isEmpty()) {
                binding.editTextSalary.error = "No Salary"
            }
            val newPerson = Person(name, ageStr.toInt(), salaryStr.toInt())
            viewModel.person.value = newPerson


            viewModel.person.observe(viewLifecycleOwner) { person ->
                binding.textviewName.text = "Hello ${person.name}"
                binding.textviewAge.text = "${person.age} years old"
                binding.textviewSalary.text = "Your salary is ${person.salary} kr"
            }

        }

        viewModel.name.observe(viewLifecycleOwner){name -> binding.textviewName.text = "Hello $name"
        }
        viewModel.age.observe(viewLifecycleOwner){ age -> binding.textviewAge.text = "$age years old"
        }
        viewModel.salary.observe(viewLifecycleOwner){salary -> binding.textviewSalary.text ="your salary is $salary kr"
        }
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}