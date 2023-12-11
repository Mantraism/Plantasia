package com.example.plantasiakuadrat

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantasiakuadrat.databinding.FragmentProfileBinding
import com.example.plantasiakuadrat.databinding.FragmentSettingBinding
import com.example.plantasiakuadrat.ui.home.HomeFragment


class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var mp: MediaPlayer


override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mp = MediaPlayer.create(requireContext(), R.raw.sample)

        binding.plantMusic.setOnClickListener {
            mp.start()
        }
//        binding.plantList.setOnClickListener {
//            // Use Navigation to navigate to the HomeFragment
//            Navigation.findNavController(requireView())
//                .navigate(R.id.action_settingFragment_to_homeFragment)
//        }
//        binding.plantProfile.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_settingFragment_to_profileFragment)
//        }
    }

}



