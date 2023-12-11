package com.example.plantasiakuadrat.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
//        viewModel = LoginViewModel(application = requireActivity().application)
//        binding.btnLogin.setOnClickListener {
//            val email = binding.email1.text.toString()
//            val password = binding.password1.text.toString()
//            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
//                viewModel.getUser(email, password)
//            }
//            findNavController().navigate(R.id.action_LoginFragment_to_navigationParentFragment)
//        }
        init()
        observeData()
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
        return binding.root
    }
    private fun observeData(){
        with(viewModel){
            Log.d("Test Login", "Error Login")
            observeIsLogin().observe(requireActivity()){
                it.let { data ->
                    if (data != null){
                        val bundle = Bundle().apply {
                            putString("email", binding.email1.text.toString())
                        }
                        Log.d("Test", "Error")
                        findNavController().navigate(R.id.action_LoginFragment_to_navigationParentFragment,bundle)
                    }
                }
            }
        }
    }
    private fun init(){
        with(binding){
            binding.btnLogin.setOnClickListener {
                if(email1.text.isNullOrBlank()){
                    email1.error = "Email Masih Kosong"
                }
                if(password1.text.isNullOrBlank()){
                    password1.error = "Password Masih Kosong"
                }
                if(!email1.text.isNullOrBlank() && !password1.text.isNullOrBlank()){
                    viewModel.getDataLogin(email1.text.toString(),password1.text.toString())
                }
            }
        }
    }
}