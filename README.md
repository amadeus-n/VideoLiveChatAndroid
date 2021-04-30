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
### Call module using

```
val videoChatIntent = Intent(this, com.videoment.videochatroom.MainActivity::class.java)
        videoChatIntent.putExtra(API_KEY, "apiKey")
        videoChatIntent.putExtra(CHANNEL_ID, "channelID")
        videoChatIntent.putExtra(USER_ID, "userId")
        videoChatIntent.putExtra(USER_NAME, "userName")
        videoChatIntent.putExtra(VIDEO_NAME, "videoName")
        videoChatIntent.putExtra(VIDEO_URL, "videoUrl")
        startActivity(videoChatIntent)
        this.finish()

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
4. 
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
