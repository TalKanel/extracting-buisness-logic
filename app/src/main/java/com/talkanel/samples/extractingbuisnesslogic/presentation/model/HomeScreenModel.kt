package com.talkanel.samples.extractingbuisnesslogic.presentation.model

import com.talkanel.samples.extractingbuisnesslogic.presentation.contracts.HomeScreen
import com.talkanel.samples.extractingbuisnesslogic.presentation.contracts.HomeScreen.Model.Status


class HomeScreenModel : HomeScreen.Model {

    private var listener: HomeScreen.Model.StatusChangedListener? = null
    private var status: HomeScreen.Model.Status = HomeScreen.Model.Status.LoadingContent()

    init {
        listener?.onStatusChanged(Status.LoginSessionExpired())
    }

    override fun subscribe(listener: HomeScreen.Model.StatusChangedListener) {
        this.listener = listener
    }

    override fun unsubscribe() {
        listener = null
    }

    override fun getStatus(): HomeScreen.Model.Status {
        return status
    }
}