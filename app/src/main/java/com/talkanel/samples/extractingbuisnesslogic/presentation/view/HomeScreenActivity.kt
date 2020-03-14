package com.talkanel.samples.extractingbuisnesslogic.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.talkanel.samples.extractingbuisnesslogic.R
import com.talkanel.samples.extractingbuisnesslogic.presentation.contracts.HomeScreen
import com.talkanel.samples.extractingbuisnesslogic.presentation.model.HomeScreenModel
import com.talkanel.samples.extractingbuisnesslogic.presentation.presenter.HomeScreenPresenter

class HomeScreenActivity : AppCompatActivity(), HomeScreen.View {

    private lateinit var presenter: HomeScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = HomeScreenPresenter(HomeScreenModel(), this)
        presenter.onViewCreated()
    }

    override fun onStart() {
        super.onStart()

        presenter.onViewForeground()
    }

    override fun showLoginDialog() {

    }
}
