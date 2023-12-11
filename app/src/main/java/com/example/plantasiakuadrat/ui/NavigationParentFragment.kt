    package com.example.plantasiakuadrat.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plantasiakuadrat.ProfileFragment
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.SettingFragment
import com.example.plantasiakuadrat.databinding.FragmentNavigationParentBinding
import com.example.plantasiakuadrat.ui.home.HomeFragment
import com.example.plantasiakuadrat.ui.register.RegisterFragment


    class NavigationParentFragment : Fragment() {
    private var _binding: FragmentNavigationParentBinding? = null
        private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)

        val homeFragment = HomeFragment()
        val settingFragment = SettingFragment()
        val registerFragment = RegisterFragment()
        val email = arguments?.getString("email") ?: ""
        val profileFragment = ProfileFragment().apply{
            arguments = Bundle().apply {
                putString("email", email)
            }
        }
        val iconColorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ),
            intArrayOf(
                Color.parseColor("#787878"),
                Color.parseColor("#7BFC4E")
            )
        )
        binding.bottomNavigationView.itemIconTintList = iconColorStates
        binding.bottomNavigationView.itemTextColor = iconColorStates
        setCurrentFragment(settingFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> setCurrentFragment(homeFragment)
                R.id.profileFragment -> setCurrentFragment(profileFragment)
                R.id.settingFragment -> setCurrentFragment(settingFragment)
            }
            true
        }

        return binding.root
    }
        private fun setCurrentFragment(fragment: Fragment) {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.parent_fragment, fragment)
                commit()
            }
        }



    }