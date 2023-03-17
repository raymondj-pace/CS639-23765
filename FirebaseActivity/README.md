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

<br>


![Firebase-1](https://user-images.githubusercontent.com/94663542/225808647-224dcc94-558a-4d64-a8ea-050494c3bb26.png)

![Firebase-2](https://user-images.githubusercontent.com/94663542/225808711-ead16341-4430-4a0b-811c-b8ac496671ce.png)

![Firebase-3](https://user-images.githubusercontent.com/94663542/225808735-76b8fd38-10ad-422b-a5ed-70f0d1c21be1.png)

![Firebase-4](https://user-images.githubusercontent.com/94663542/225808764-b17d9da3-2ad4-4f6f-8cfe-ca98ae1dde80.png)

https://user-images.githubusercontent.com/94663542/225815403-6ba5bd27-d57b-4696-9b04-2a9aa16bfc8a.mp4

