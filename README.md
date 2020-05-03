# DeeplinkInAndroid

## Definition
Deep links are URLs that take users directly to specific content in your app. In Android, you can set up deep links by adding intent filters and extracting data from incoming intents to drive users to the right activity.

However, if other apps installed on a user's device can handle the same intent, users might not go directly to your app. For example, clicking a URL in an email from a bank might lead to a dialog asking the user whether to use the browser or the bank's own app to open the link.

<b>Android App Links</b> on Android 6.0 (API level 23) and higher allow an app to designate itself as the default handler of a given type of link. If the user doesn't want the app to be the default handler, they can override this behavior from their device's system settings.

## Create Deep Links to App Content
### Add intent filters for incoming links
To create a link to your app content, add an intent filter that contains these elements and attribute values in your manifest:

```<intent-filter>
  ...
  <action android:name="android.intent.action.VIEW" />
  <category android:name="android.intent.category.DEFAULT" />
  <category android:name="android.intent.category.BROWSABLE" />
  <data
     android:scheme="http"
     android:host="example.com" />
</intent-filter>
```

Specify the ```ACTION_VIEW``` intent action so that the intent filter can be reached from Google Search.
Include the ```BROWSABLE``` category. It is required in order for the intent filter to be accessible from a web browser. Without it, clicking a link in a browser cannot resolve to your app.
Also include the ```DEFAULT``` category. This allows your app to respond to implicit intents. Without this, the activity can be started only if the intent specifies your app component name.


### Read data from incoming intents
```override fun onResume() {
        super.onResume()
        val `in` = intent        //Keywords can be user as variables in kotlin using symbol (`)
        val data: Uri? = `in`.data

        if (data!=null){    // check for null data
            if(validateDeeplink(data)){  // check for validate data
                data_tv.setText("Deeplink Data is $data");
            }
        }

    }
```
    
Once the system starts your activity through an intent filter, you can use data provided by the ```Intent``` to determine what you need to render. Call the ```getData()``` and ```getAction()``` methods to retrieve the data and action associated with the incoming ```Intent```. You can call these methods at any time during the lifecycle of the activity.


## The difference between deep links and app links
A <b>deep link</b> is an intent filter that allows users to directly enter a specific activity in your Android app. Clicking one of these links might open a disambiguation dialog, which allows the user to select one of multiple apps (including yours) that can hande the given URL

An <b>Android App Link</b> is a deep link based on your website URL that has been verified to belong to your website. So clicking one of these immediately opens your app if it's installed—the disambiguation dialog does not appear. Though the user may later change their preference for handling these links

![Difference between deep links and app links](https://user-images.githubusercontent.com/53623174/80914543-c8e8bd80-8d69-11ea-9d77-9406ecc77d71.PNG)
