# Video Live Chat Demo App
## Stack Used
- Kotlin [Official](https://kotlinlang.org/)
- Pagedlist [Official](https://developer.android.com/reference/android/arch/paging/PagedList)
- Amity Chat SDK [Official](https://docs.amity.co/chat/android) 

## Import Module
```
In your Android Studio go to File -> New -> Import Module
```

## Add maven in your build.gradle (project level)
```
repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
```

### Import module to your project in build.gradle (Module level)

```
dependencies {
    implementation project(path: ':videochatroom')
}
```
### Import module using

```
import com.videoment.videochatroom.chatfragment.ChatHomeFragment

```

### Create Framelayout

```
    <FrameLayout
        android:id="@+id/chatFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/matchCoordinatorLayout"
        android:visibility="visible" />

```

### Call module using

```
        val channelObject = JSONObject()
        channelObject.put(CHANNEL_ID, chID)
        channelObject.put(USER_ID, userID)
            
         val chatFrag = newInstance(channelObject, ChatHomeFragment())
         addFragment(chatFrag, com.videoment.videochatroom.R.id.chatFragment)
         
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
```

## Amity Chat SDK Installation Guide
### Setup steps for the SDK 
1. Add the SDK to your project

## Add maven in your build.gradle (project level)
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

### Import SDK to your project in build.gradle (Module level)
```
implementation 'com.github.EkoCommunications.EkoMessagingSDKAndroid:eko-sdk:x.y.z'
```

2. Create new SDK Instance with your API Key

Before using the Chat SDK, you will need to create a new SDK instance with your API key (find it via the Admin Panel under setting).
```
class SimpleChatApp : Application() {

    override fun onCreate() {
        super.onCreate()

        EkoClient.setup("YOUR_API_KEY")
    }
}
```

3. Register Session for your device via User ID

In order to use any Chat SDK feature, you must first register the current device with an userId.
```
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EkoClient.registerDevice("userId 1")
                .displayName("John Doe")
                .build()
                .submit()
    }

}
```

4. Join the user to channel you want

```
val channelRepository = EkoClient.newChannelRepository();

channelRepository.joinChannel(channelId)
                .subscribe()
```

5. Retrieve messages in the channel

```
val messageRepository = EkoClient.newMessageRepository();
messageRepository.getMessageCollection(channelId)
        .build()
        .query()
        .subscribe( { adapter.submitList(it) } )
```

### Chat message options
1. Send message to the channel

```
messageRepository.createMessage(channelId)
        .with()
        .text("Hello Amity!")
        .build()
        .send()
        .subscribe()
```

2. React on message

```
EkoMessage message;
message.react()
     .addReaction("like")
     .subscribe()
     
```
3. Flag on message
```
EkoMessage message;
EkoMessageFlagger flagger = message.report();

```
To flag a message, call the following method:
```
// flag a message
flgger.flag()
      .doOnComplete(() -> {
        // Message is already flagged. you may update the UI accordingly here
      })
      .subscribe();
```

To unflag a message, call the following method:
```
// un-flag a message
flagger.unflag()
       .subscribe();
```
