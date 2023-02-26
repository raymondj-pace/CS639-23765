Simple Async Task using Thread.sleep()

For the Progress Updater to work you need update the template parameters to: <Void, Integer, String>

![Screenshot 2023-02-26 at 4 46 27 PM](https://user-images.githubusercontent.com/94663542/221441149-600cd98c-764f-4393-a604-a31fff918b30.png)

Here `Integer` is what will be passed to the `onProgressUpdate()` method and `String` is passed to the `onPostExecute()` method.
The sleep value needs to be large enough so that the `publishProgress()` can be seen on the device.

<br>

Application start:

![SimpleAsyncTaskStart](https://user-images.githubusercontent.com/94663542/221438802-85e874c5-5ff5-4bef-8b81-83f3ba1d4008.png)

<br>

Progress indicator updating:

![SimpleAsyncTaskProgressUpdate](https://user-images.githubusercontent.com/94663542/221438829-061e4886-7320-45a6-a735-091d8b1b9734.png)

<br>

Task complete:

![SimpleAsyncTaskComplete](https://user-images.githubusercontent.com/94663542/221438843-edade7ef-a8a5-4fcf-a4d2-9ac5a0cbf7b9.png)

<br>

Physical Device - Nexus 6P

![SimpleAsyncTaskPhysical](https://user-images.githubusercontent.com/94663542/221438997-670ed68c-fddb-4f97-8cfc-41a4f643f9fa.png)

<br>

Video:

https://user-images.githubusercontent.com/94663542/221438863-01409952-6ee6-4da9-b58a-be65c376368e.mp4

