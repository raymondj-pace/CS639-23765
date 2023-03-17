Firebase Activity app uses a ListView with a 2nd activity "activity_listview.xml", and the following Java code using an ArrayAdapter:

```
ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.activity_listview, R.id.textView, employeeNames);
simpleList.setAdapter(arrayAdapter);
```

A webView was first attempted which seemed very promising in that I could use fancy html tables to format the names. However, it was very difficult to get the view to update, even after trying numerous technices and tricks. Another problem with the webView is that it cannot exist (easily) within a ScrollView.

<br>

1. The employee list is sorted alphabetically by first name. The sort is possible via the `compareTo()` method added to the Employee class. In addition, the `toString()` method uses firstname plus a space character plus the lastname.

2. The keyboard auto capitalizes the firt character of every word. If someone's name was "Mary Ann" (firstname) "Johnson" (lastname) it will auto capitalize each word.

3. If you touch outside of either of the two EditText's then the keyboard will auto-hide.

4. If you try to Add a new employee but one or both of the edit fields are empty, a Toast message will display an message showing you to make the corrections.

5. The EditText's use "hint" values to show you what you should be entering. ("First name", "Last name")

6. Duplicate names are not checked for and nor are special characters. For example, I allow the use of something like "Raymond3" if such a nickname is desired to be saved.

7. <b>Problem:</b> I am unable to hide the keyboard when the app first starts. The EditText's have focus but I still try to hide the keyboard unsuccessfully at app start. The keyboard is successfully hidden when a new employee is added.

<br>


![Firebase-1](https://user-images.githubusercontent.com/94663542/225913871-d28c08f0-1339-4ecd-95c7-4e25e5bba38c.png)
![Firebase-2](https://user-images.githubusercontent.com/94663542/225913897-9acda334-f90b-49b3-bc38-116ea74b062f.png)
![Firebase-3](https://user-images.githubusercontent.com/94663542/225913948-946b892d-8ff1-4aba-8854-7daa9a7c7e30.png)
![Firebase-4](https://user-images.githubusercontent.com/94663542/225913977-df22e9bf-f6db-4809-b48e-ed921154a3a0.png)

https://user-images.githubusercontent.com/94663542/225815403-6ba5bd27-d57b-4696-9b04-2a9aa16bfc8a.mp4

