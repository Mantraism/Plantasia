package com.example.plantasiakuadrat.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_SplashFragment_to_RegisterFragment)
        }, 3000)
        return binding.root
    }

}