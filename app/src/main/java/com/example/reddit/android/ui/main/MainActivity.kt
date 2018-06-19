package com.example.reddit.android.ui.main

import android.os.Bundle
import android.util.Log
import com.example.reddit.R
import com.example.reddit.android.ui.BaseActivity
import com.example.reddit.presentation.main.MainPresenter
import com.example.reddit.presentation.main.MainView
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject lateinit var presenter: MainPresenter

    override fun getActivityPresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", UUID.randomUUID().toString())

        presenter.takeView(this)
    }

}
