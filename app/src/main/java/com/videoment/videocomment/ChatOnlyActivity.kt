package com.videoment.videocomment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ekoapp.ekosdk.EkoClient
import com.videoment.videochatroom.chatfragment.ChatHomeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class ChatOnlyActivity : AppCompatActivity(R.layout.chatonly_activity) {

    val CHANNEL_ID = "channelID"
    val USER_ID = "userId"
    val USER_NAME = "userName"
    val API_KEY = "apiKey"

    var apikey = ""
    var chID = ""
    var userID = ""
    var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apikey = intent.getStringExtra(API_KEY) ?: ""
        chID = intent.getStringExtra(CHANNEL_ID) ?: ""
        userID = intent.getStringExtra(USER_ID) ?: ""
        userName = intent.getStringExtra(USER_NAME) ?: ""

        initEkoClient()
        initFragment(savedInstanceState)
    }

    private fun initEkoClient() {
        EkoClient.setup(apikey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        EkoClient.registerDevice(userID)
            .displayName(userName)
            .build()
            .submit()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        val channelObject = JSONObject()
        channelObject.put(CHANNEL_ID, chID)
        channelObject.put(USER_ID, userID)

        if (savedInstanceState == null) {
            val chatFrag = newInstance(channelObject, ChatHomeFragment())
            addFragment(chatFrag, com.videoment.videochatroom.R.id.chatFragment)
        }
    }

    private fun newInstance(channelObject: JSONObject, frag: Fragment): Fragment {
        val args = Bundle()
        args.putString(CHANNEL_ID, channelObject.getString(CHANNEL_ID))
        frag.arguments = args
        return frag
    }

    private fun addFragment(fragment: Fragment, viewID: Int) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                com.videoment.videochatroom.R.anim.design_bottom_sheet_slide_in,
                com.videoment.videochatroom.R.anim.design_bottom_sheet_slide_out
            )
            .replace(
                viewID,
                fragment,
                fragment.javaClass.simpleName
            )
            .commit()
    }

}