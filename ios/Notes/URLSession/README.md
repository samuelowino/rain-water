# IOS Networking

## Core APIs
* **URLSession**
* **URLSessionDataTask**
* **URLSessionDownloadTask**
* **URLSession.shared**
* **URLSessionConfiguration**
* **URLSessionDelegate**
* **URLSessionTask**
* **URLSessionTask.resume**
* **URLSessionTaskDelegate**
* **URLSessionTaskDelegate.dataTaskWith(:completionHandler)**

- - -

## URLSession

An object that coordinates a group of related network data transfer tasks.

```swift
class URLSession : NSObject
```

The URLSession class provides APIs for downloading data from and uploading data to endpoints indicated by URLs.

You can use related APIs such as **URLSessionDelegate** and **URLSessionTaskDelegate** to perform **Authentication** and receive events like **redirection** and task completion.

## URL Loading System

URL data loading is performed asynchronously.

Use a **URLSession instance** to create one or more **URLSessionTask instances** which can fetch and return data to your app.

To configure a session use a **URLSessionConfiguration object**

You can use one **URLSession repeatedly to create multiple tasks**

!["URL Loading System"](../../6789dd96-afdc-4c18-b8eb-01f9012dc04d-2.png)

## Types of URLSessions

The URLSession API defines four types of tasks:

* **Data tasks**: Sends and receive data using **NSData objects**
* **Upload tasks**: Similar to data tasks but they also send data and support background uploads while the app isn't running.
* **Download tasks**: Retrieve data in the form of a file and support background uploads and downloads.
* **WebSocket Tasks**: Exchange objects over **TCP** and **TLS** using the **WebSocket Protocol**

## Using a Session Delegate

Tasks in a URLSession also share a common delegate object. You implement this delegate to obtain and share information when various events occur such as when:

* **Authentication fails**
* **Data arrives from the server**
* **Data becomes available for caching**

If you don't need the features provided by a delegate, you can use URLSession without providing one by just passing nil.

## Asynchronicity and URL Sessions

Like most networking APIs the URLSession API is highly asynchronous 



