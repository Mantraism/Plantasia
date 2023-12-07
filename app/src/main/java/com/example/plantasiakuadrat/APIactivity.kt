package com.example.plantasiakuadrat
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.plantasiakuadrat.data.MainAdapter
//import com.example.plantasiakuadrat.data.remote.ApiService
//import com.example.plantasiakuadrat.data.remote.UsersItem
//import com.example.plantasiakuadrat.databinding.ActivityApiactivityBinding
//import com.example.plantasiakuadrat.databinding.ActivityMainBinding
//import com.example.plantasiakuadrat.util.constant.BASE_URL
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class APIactivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityApiactivityBinding
//    private lateinit var viewAdapter: MainAdapter
//    private lateinit var viewManager: RecyclerView.LayoutManager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityApiactivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        viewManager = LinearLayoutManager(this)
//        getUsersData()
//    }
//
////    private fun getUsersData() {
////        var retrofit = Retrofit.Builder()
////            .baseUrl(BASE_URL)
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////            .create(ApiService::class.java)
////
////        retrofit.getPlants().enqueue(object : retrofit2.Callback<List<UsersItem>> {
////            override fun onResponse(
////                call: retrofit2.Call<List<UsersItem>>,
////                response: retrofit2.Response<List<UsersItem>>
////            ){
////                if (response.isSuccessful){
////                    val data = response.body()!!
////                    viewAdapter = MainAdapter(baseContext, data)
////                    binding.itemRv.apply {
////                        layoutManager = viewManager
////                        adapter = viewAdapter
////                    }
////                }
////            }
//
//            override fun onFailure(call: retrofit2.Call<List<UsersItem>>, t: Throwable) {
//                t.printStackTrace()
//            }
//        })
//    }
//
//
//}