package com.example.plantasiakuadrat.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantasiakuadrat.data.remote.response.PlantResponse
import com.example.plantasiakuadrat.data.remote.response.PlantResponseItem
import com.example.plantasiakuadrat.databinding.FragmentHomeBinding
import okhttp3.internal.http.hasBody
import org.koin.android.ext.android.inject

class   HomeFragment : Fragment() {


    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel:HomeViewModel by inject()
    private var list: ArrayList<PlantResponseItem> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Test 1
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val bottomNavigationView = binding.root.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController: NavController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//
//        binding.button2.setOnClickListener{
//            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment)
//        }
//
//        bottomNavigationView.setupWithNavController(navController)
//        return binding.root
//    }
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val bottomNavigationView = binding.root.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController()
//        val navController: NavController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment, R.id.settingFragment))
//        setupActionBarWithNavController()
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.profileFragment, R.id.settingFragment))
//        setupActionBarWithNavController(requireActivity() as AppCompatActivity, navController, appBarConfiguration)
        init()
        observeData()
//        bottomNavigationView.setupWithNavController(navController)
        return binding.root

    }
    private fun observeData(){
        with(viewModel){
            Log.d("homeFragment","observeDataViewModel")
            observePlant.observe(requireActivity()){
                it.let { data ->
                    list = data.body()!!
                    Log.d("home","observeData: $list")
                    with(binding.rvPlant){
                        adapter = HomeAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
                    }

                }
            }
        }
    }
    private fun init(){
        viewModel.getPlant()
    }

}

//package com.example.plantasiakuadrat.ui
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.NavController
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.ui.setupWithNavController
//import com.example.plantasiakuadrat.R
//import com.example.plantasiakuadrat.databinding.FragmentHomeBinding
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class HomeFragment : Fragment() {
//
//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val bottomNavigationView =
//            binding.root.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        // Use findNavController() without specifying the View since you're in a Fragment
//        val navController: NavController = findNavController()
//
//        binding.button2.setOnClickListener {
//            navController.navigate(R.id.action_homeFragment_to_detailFragment)
//        }
//
//        bottomNavigationView.setupWithNavController(navController)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.navigation.Navigation
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.ui.setupWithNavController
//import com.example.plantasiakuadrat.R
//import com.example.plantasiakuadrat.databinding.FragmentHomeBinding
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class HomeFragment : Fragment() {
//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val bottomNavigationView =
//            binding.root.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController()
//
//        binding.button2.setOnClickListener {
//            // Use Navigation.createNavigateOnClickListener for navigation actions
//            val action = findNavController(it).navigate.action_homeFragment_to_detailFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        bottomNavigationView.setupWithNavController(navController)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
//
