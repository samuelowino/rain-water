# FileManager API

The FileManager api is a convenient interface to the contents of the file system and provides a primary means of interacting with it.

```swift
class FileManager : NSObject
```

A file manager object lets you examine the contents of the file system and make changes to it. The file manager is your primary mode of interacting with the file system. It can be used to **locate, create, copy and move files and directories**. You can also use it to **get information about a file or directory or change some of it's attributes**

The location of a file is specified as **NSUr** or **NSString** objects.

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

