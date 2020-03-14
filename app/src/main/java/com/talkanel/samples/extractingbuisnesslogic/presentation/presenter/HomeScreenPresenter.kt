package com.talkanel.samples.extractingbuisnesslogic.presentation.presenter

import com.talkanel.samples.extractingbuisnesslogic.presentation.contracts.HomeScreen
import com.talkanel.samples.extractingbuisnesslogic.presentation.contracts.HomeScreen.Model.Status
import com.talkanel.samples.extractingbuisnesslogic.presentation.model.HomeScreenModel

class HomeScreenPresenter(
    private val model: HomeScreenModel,
    private val view: HomeScreen.View
) : HomeScreen.Presenter {

    override fun onViewCreated() {
        val status = model.getStatus()
        when (status) {
            is Status.LoginSessionExpired -> view.showLoginDialog()
        }
    }

    override fun onViewForeground() {
        model.subscribe(object : HomeScreen.Model.StatusChangedListener {
            override fun onStatusChanged(status: HomeScreen.Model.Status) {
                when (status) {
                    is Status.LoginSessionExpired -> view.showLoginDialog()
                }
            }
        })
    }

    override fun onViewBackground() {
        model.unsubscribe()
    }
}