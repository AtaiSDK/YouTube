package com.example.youtube.core.base


import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding,
                            VM: ViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    protected abstract fun inflateViewBinding(): VB


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = inflateViewBinding()
        setContentView(binding.root)

        checkInternetConnection()
        initView()
        initLiveData()
        initListener()

    }
    open fun initListener() {}

    open fun initLiveData() {}

    open fun initView() {}

    open fun checkInternetConnection() {
    }
}