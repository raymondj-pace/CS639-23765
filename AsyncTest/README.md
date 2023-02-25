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

<br/>
<br/>

App was tested on a Huawei Nexus 6P, Android 8.1 (API 27 - Oreo)
![Screenshot 2023-02-25 at 1 47 54 PM](https://user-images.githubusercontent.com/94663542/221374937-cdc16385-e793-41dc-a013-a743f2d68f55.png)


![RandomImage](https://user-images.githubusercontent.com/94663542/221375154-8c545ac9-8fc1-4cb5-ab0e-d94530a18273.jpg)




        
        
