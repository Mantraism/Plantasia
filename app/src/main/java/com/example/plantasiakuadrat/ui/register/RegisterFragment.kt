package com.example.plantasiakuadrat.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.data.local.entity.UserEntity
import com.example.plantasiakuadrat.databinding.FragmentRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
//        viewModel = RegisterViewModel(application = requireActivity().application)
//        binding.button.setOnClickListener{
//            val name = binding.username.text.toString()
//            val email = binding.email.text.toString()
//            val password = binding.password.text.toString()
//            val user = UserEntity(0,name,email,password)
//            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
//                viewModel.insertUser(user)
//            }
//            findNavController().navigate(R.id.action_RegisterFragment_to_navigationParentFragment)
//        }
        init()
        observeData()
        binding.loginbtn.setOnClickListener {
            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
        }
        return binding.root
    }
    private fun observeData(){
        with(viewModel){
            observeIsRegister().observe(viewLifecycleOwner){
                it.let { data ->
                    if (data){
                        findNavController().navigate(R.id.action_RegisterFragment_to_navigationParentFragment)
                    } else {
                        Toast.makeText(requireContext(),"Email sudah terdaftar", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
    private fun init(){
        binding.button.setOnClickListener {
            val name = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val user = UserEntity(0,name,email,password)
            viewModel.insertUser(user)
        }
    }
}