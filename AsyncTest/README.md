# Asyncronous Image Loader App

In file AndroidManifest.xml be sure to have:
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />
    
     <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:networkSecurityConfig="@xml/network_security_config"
```        

<br/>
<br/>
Create the file network_security_config.xml under the res/xml subdirectory as:
<br/>
<br/>

```
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">localhost</domain>
    </domain-config>
</network-security-config>
```


## NOTE:
Be sure to pass a reference of the MainActivity app to the AsyncTaskImgDownloader via a constructor method otherwise you will not be able to use: `getString(R.string.<your string id>)`

## TODO:
Try to get the screen to not completely redraw.

<br/>
<br/>

App was tested on a Huawei Nexus 6P, Android 8.1 (API 27 - Oreo)

![AsyncImageVirtual](https://user-images.githubusercontent.com/94663542/221378965-bbea7bb3-e40e-4217-8eb8-edfbadd5c71e.png)

![ImageAsyncReload](https://user-images.githubusercontent.com/94663542/221378955-db719a63-2a40-455a-8b3d-36da97d2fc85.jpg)

https://user-images.githubusercontent.com/94663542/221379048-1c6f46e3-276e-4acc-9042-71b1c92231ce.mp4



        
        
