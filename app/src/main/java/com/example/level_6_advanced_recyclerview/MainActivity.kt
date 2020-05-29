package com.example.level_6_advanced_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.level_6_advanced_recyclerview.R.layout.activity_main
import com.example.level_6_advanced_recyclerview.adapter.ColorAdapter
import com.example.level_6_advanced_recyclerview.model.ColorItem
import com.example.level_6_advanced_recyclerview.vm.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val colors = arrayListOf<ColorItem>()
    private val colorAdapter = ColorAdapter(colors, {colorItem -> onColorClick(colorItem) })
    private lateinit var viewModel: MainActivityViewModel


    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rvColors, "This color is: ${colorItem.hex}", Snackbar.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initViews()
        initViewModel()

    }

    private fun initViews(){

        rvColors.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvColors.adapter = colorAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider (this).get(MainActivityViewModel::class.java)

        viewModel.colorItems.observe(this, Observer {
            colors.clear()
            colors.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })
    }
}



