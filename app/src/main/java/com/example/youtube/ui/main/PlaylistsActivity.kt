package com.example.youtube.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube.core.base.BaseActivity
import com.example.youtube.core.base.PlaylistAdapter
import com.example.youtube.databinding.ActivityMainBinding

class PlaylistsActivity : BaseActivity<ActivityMainBinding, PlaylistsViewModel>() {
    override val viewModel: PlaylistsViewModel
    get() = ViewModelProvider(this)[PlaylistsViewModel::class.java]

    override fun inflateViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private var adapter = PlaylistAdapter()

    override fun initLiveData() {
        super.initLiveData()
        viewModel.getPlayList(10).observe(this){
            adapter.setListModel(it)
        }
    }

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList(1)
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()

    }
}