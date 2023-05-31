# FileManager API

The FileManager api is a convenient interface to the contents of the file system and provides a primary means of interacting with it.

```swift
class FileManager : NSObject
```

A file manager object lets you examine the contents of the file system and make changes to it. The file manager is your primary mode of interacting with the file system. It can be used to **locate, create, copy and move files and directories**. You can also use it to **get information about a file or directory or change some of it's attributes**

The location of a file is specified as **NSURL** or **NSString** objects.

In **iOS 5 and later** and **macOS 10.7 and later**, FileManager can be used for **managing items stored in iCloud**. 

## URL

A value that represents the location of a resource, such as an item on a remote server or the path to a local file.

You can get the contents of a local file as String by using **String** ```init(contentsOf: encoding: ) ```

The String constructor produces a String by reading data from a given URL interpreted using a given encoding. Any errors are written into the ```inout error``` argument.

``` swift
init (
    contentsOf url: URL,
    encoding enc: String.Encoding
) throws
```

Create a shared instance of ```FileManager``` with ```FileManager.default``` . This will grant the app access to the **shared FileManager**  object for the process.

You can obtain the URL to the app documents directory with 

```swift
let manager = FilaManager.default
try let docUrl = manager.urls(for: SearchPathDirectory.documentDirectory, in: .userDomainMask)
```

---

## FileManager.SearchPathDirectory

**SearchPathDirectory** is is an enumeration in Swift that represents various directories in the file system. SearchPathDirectory is used together with **FileManager** to locate and manipulate files and directories.

**SearchPathDirectory** defines several pre-defined directories that are commondly used in iOS, macOS and other Apple platforms. Each case of the enumeration represents a specific directory with a different purpose.

### SearchPathDirectory.applicationDirectory (/Applications)
> value: 1

> case applicationDirectory = 1

This is the directory where the application is installed. This directory is **read-only** on iOS and macOS.

### SearchPathDirectory.documentDirectory
> value: 9

> case documentDirectory = 9

The directory where the application can store user generated content. Files stored here are typically backed up by iCloud **(if enabled)**

---

## FileManager.SearchPathDomainMask

FileManager.SearchPathDomainMask is an enumeration in Swift that is used in conjuction with ```FileManager,SearchPathDirectory``` to specify **the domain or scope in which the search for directories should be performed**

Each case of the enumeration represents a different domain. Here are some commonly used cases:

* ```userDomainMask``` : 
The search is  limited to the **current user's home directory**. This is the most common case used for accessing user-specific directories.

* ```localDomainMask```:
The search is limited to the **local domain**, which typically includes directories shared by multiple users on the same machine.

* ```networkDomainMask```:
The search is limited to the **network domain**, which includes directories shared over the network.

* ```systemDomainMask```:
The search is limited to the **system domain**, which includes directories containing system related files.

---

# File System Operations

## 1. Create Directory

Use ```append(path: directoryHint)``


