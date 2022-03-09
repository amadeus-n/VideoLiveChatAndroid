<img align="right"
src="https://user-images.githubusercontent.com/99466907/157395662-2ceb1e46-529b-460a-8fce-12dadcf1d53a.png"
alt="Amity Social Cloud SDKs" width="50%" />

<img align="left"
src="https://user-images.githubusercontent.com/100549875/155947065-3cc4291c-d600-40a1-bc49-4ff5e9b9d1be.svg"
alt="Amity logo" width="120px" />

<br />
<br />

# Amity Social Cloud SDKs
Boost app engagement and grow your user base with plug-and-play social
features. Amity modules are <b>ready to use</b> — the only things left
to do are integration and frontend.

Learn more about Amity here: [amity.co→](https://amity.co/)

<br />
<br />

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

<br />
<br />

<img align="left"
src="https://user-images.githubusercontent.com/100549875/156137190-46c08727-042b-4f3d-858b-d50868ebb0b3.png"
alt="Amity Social Cloud SDKs" width="50%" />

## Resources

**Developer Portal** <br />
Learn about building, deploying, and managing Amity Social Cloud. <br />
[Portal→](https://www.amity.co/developer-portal)

**Documentation** <br />
Everything you need to integrate Amity Social Cloud. <br />
[Docs→](https://docs.amity.co/)

**Developer Kits** <br />
Explore Amity Social Cloud UI Kits and Template Apps. <br />
[Developer Kits→](https://www.amity.co/developer-kits)

**Community** <br />
Join the community of Amity Social Cloud developers. <br />
[Community→](https://community.amity.co/)

**FAQ** <br />
Get the answers to the most asked questions. <br />
[FAQ→](https://www.amity.co/faq)

<br />
<br />
<br />
<br />
<br />
<br />

## Amity Chat SDK
Amity Chat SDK is an easy-to-integrate solution that enables
high-performing chat services on your app. From one-on-one to
large-scale group messaging, power them with <b>Amity Chat SDK</b>,
built with <b>messaging service APIs</b> to ignite connections and
open discussions.

Learn more about Amity Chat on [our
website→](https://www.amity.co/products/amity-chat) or view the Amity
Chat [Docs→](https://docs.amity.co/chat)

<br />

## Amity Social SDK
Get in-app communities up and running using Amity Social SDK. Enable
<b>plug-and-play social features using supercharged social APIs</b>
and see preference-based groups thrive within your platform.

Learn more about Amity Chat on [our
website→](https://www.amity.co/products/amity-social) or view the
Amity Social [Docs→](https://docs.amity.co/social)

<br />

## Amity Video SDK
The Amity Video SDK, powered by <b>video APIs</b>, elevates your
application's user experience by adding interactive features such as
<b>in-app Stories and Live Streaming</b>. Engage your users with
captivating, memorable virtual events to participate in along with
other viewers from around the world.

Learn more about Amity Chat on [our
website→](https://www.amity.co/products/amity-video) or view the Amity
Video [Docs→](https://docs.amity.co/video)

<br />

## About Amity
The future is social — and we at Amity are on a mission to make social
experiences more accessible than ever. Amity Social Cloud allows
companies to easily integrate plug-and-play social features into their
apps and digital channels to drive engagement, build communities, and
grow revenue.

<b>🟢 We're hiring!</b> View all [open positions→](https://www.amity.co/careers)

<br />

## License
Public Framework. Copyright © 2022 Amity.
