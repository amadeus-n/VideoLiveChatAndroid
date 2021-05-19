package com.amityco.videocomment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ekoapp.ekosdk.EkoClient
import com.amityco.videochatroom.chatfragment.ChatHomeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class ChatOnlyActivity : AppCompatActivity(R.layout.chatonly_activity) {

    val CHANNEL_ID = "channelID"
    val USER_ID = "userId"

    var apikey = "apikey"
    var chID = "chID"
    var userID = "userID"
    var userName = "userName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            addFragment(chatFrag, com.amityco.videochatroom.R.id.chatFragment)
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
                com.amityco.videochatroom.R.anim.design_bottom_sheet_slide_in,
                com.amityco.videochatroom.R.anim.design_bottom_sheet_slide_out
            )
            .replace(
                viewID,
                fragment,
                fragment.javaClass.simpleName
            )
            .commit()
    }

}