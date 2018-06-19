package com.example.reddit.presentation.main

import com.example.reddit.domain.usecase.UpdateTokenUseCase
import com.example.reddit.presentation.BasePresenter
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class MainPresenter @Inject constructor(private val updateTokenUseCase: UpdateTokenUseCase) : BasePresenter<MainView>() {

    override fun onTakeView(view: MainView) {
        super.onTakeView(view)

        updateTokenUseCase.execute(object : DisposableCompletableObserver() {
            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        }, Unit)
    }

}