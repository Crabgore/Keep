package com.geekbrains.android_1.hw3_1.ui.main

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.geekbrains.android_1.hw3_1.R
import com.geekbrains.android_1.hw3_1.ui.adapters.NotesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NotesAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        viewModel.viewState().observe(this, Observer { viewState ->
            viewState?.let { adapter.notes = it.notes }
        })
    }

    private fun initUI() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = NotesAdapter()

        rv_notes.layoutManager = GridLayoutManager(this, 2)
        rv_notes.adapter = adapter
    }
}
