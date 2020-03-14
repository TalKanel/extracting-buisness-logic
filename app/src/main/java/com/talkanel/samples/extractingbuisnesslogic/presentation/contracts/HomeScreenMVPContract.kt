package com.talkanel.samples.extractingbuisnesslogic.presentation.contracts

interface HomeScreen {

    interface View {
        fun showLoginDialog()
    }

    interface Presenter {
        fun onViewForeground()
        fun onViewBackground()
        fun onViewCreated()
    }

    interface Model {

        fun subscribe(listener: StatusChangedListener)
        fun unsubscribe()

        fun getStatus(): Status

        interface StatusChangedListener {
            fun onStatusChanged(status: Status)
        }

        sealed class Status {
            class LoadingContent : Status()
            class ContentLoaded : Status()
            class LoggedOut : Status()
            class LoginSessionExpired : Status()
            class LoggingIn : Status()
            class LoggedIn : Status()
        }
    }
}