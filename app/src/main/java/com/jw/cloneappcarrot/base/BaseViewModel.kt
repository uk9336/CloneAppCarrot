package com.jw.cloneappcarrot.base

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.*
import com.jw.cloneappcarrot.common.Dlog
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.cancel
import java.io.Serializable

/**
 * Created by LJW on 2021/12/13.
 *
 * Description :
 */
abstract class BaseViewModel : ViewModel(), LifecycleEventObserver {

    lateinit var activity: BaseActivity<*, *>

    var compositeDisposable : CompositeDisposable = CompositeDisposable()

    var lifecycleOwner: LifecycleOwner? = null
        set(value) {
            field = value
            field?.let {
                it.lifecycle.addObserver(this)
                Dlog.d("lifecycle => $field")
            }
        }


    /**************************
     * ViewModel
     *************************/
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    /**************************
     * template
     *************************/
    protected abstract fun onInitInternal()

    /**************************
     * LifecycleEventObserver
     *************************/

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            // onCreate
            Lifecycle.Event.ON_CREATE -> {
                Dlog.d("ON_CREATE")
                onInitInternal()
            }
            // onStart
            Lifecycle.Event.ON_START -> {
                Dlog.d("ON_START")
            }
            // onResume
            Lifecycle.Event.ON_RESUME -> {
                Dlog.d("ON_RESUME")
            }
            // onPause
            Lifecycle.Event.ON_PAUSE -> {
                Dlog.d("ON_PAUSE")
            }
            // onStop
            Lifecycle.Event.ON_STOP -> {
                Dlog.d("ON_STOP")
            }
            // onDestroy
            Lifecycle.Event.ON_DESTROY -> {
                Dlog.d("ON_DESTROY")
            }
            // onAny
            Lifecycle.Event.ON_ANY -> {
                Dlog.d("ON_ANY")
            }
        }
    }

    /***********************************
     * Method
     ***********************************/

    /**
     * activity 전환
     *
     * @param intent
     */
    protected fun startActivity(intent: Intent) = activity.startActivity(intent)
    protected fun startActivity(intent: Intent, bundle: Bundle?) =
        activity.startActivity(intent, bundle)

    /**
     * activity 전환 with data
     *
     * @param toActivityClass
     * @param name String
     * @param data Serializable
     */
    protected fun startActivity(
        toActivityClass: Class<out BaseActivity<*, *>>,
        name: String,
        data: Serializable
    ) {
        startActivity(Intent(activity, toActivityClass).apply { putExtra(name, data) })
    }

    /**
     * activity 전환 with data, bundle
     *
     * @param toActivityClass
     * @param name String
     * @param data Serializable
     * @param bundle Bundle
     */
    protected fun startActivity(
        toActivityClass: Class<out BaseActivity<*, *>>,
        name: String,
        data: Serializable,
        bundle: Bundle?
    ) {
        startActivity(Intent(activity, toActivityClass).apply { putExtra(name, data) }, bundle)
    }

    /**
     * activity 전환 with data
     *
     * @param toActivityClass
     * @param bundle Bundle?
     */
    protected fun startActivity(
        toActivityClass: Class<out BaseActivity<*, *>>,
        bundle: Bundle? = null
    ) {
        startActivity(Intent(activity, toActivityClass).apply { bundle?.let { putExtras(it) } })
    }

    /**
     * Back key 눌렸을 경우 처리, 보통은 activity.finish() 이지만 특별히 처리가 필요한 경우에는 override 하여 사용한다.
     */
    protected open fun onBackPressInternal() {
        finish()
    }

    /**
     * 액티비티 종료
     */
    protected fun finish() {
        activity.finish()
    }

    /**
     * 앱 종료
     */
    protected fun exit() {
        activity.finishAffinity()
    }


    /***********************************
     * public
     ***********************************/
}