# Encoding and Decoding Custom Types

Make your data types encodable and decodable for compatibility with external representations such as JSON

The Swift standard library defines a standardized approach to data **decoding** and **encoding**. You can adopt this approach by implementing the **Encodable** and **Decodable** protocols.

To support both encoding and decoding implement the **Codable protocol** which combines both the Encodable and Decodable protocols.

```swift
struct UserResource : Codable {
    var name: String
    var email: String
    var password: String
}
```

# Using JSON With Custom Types

## JSONEncoder

An object that encodes instances of data types and JSON objects.

```swift
class JSONEncoder
```

```swift
struct User : Codable {
    var name: String
    var email: String
    var password: String
}

func toJson(user: User) -> String? {
    let jsonEncoder: JSONEncoder = JSONEncoder()
    jsonEncoder.outputFormatting = .prettyPrinted

    do {
        let data = try jsonEncoder.encode(user)
        return String(data: data, encoding: .utf8)
    } catch {
        print("Error while encoding user \(error)")
        return nil
    }
}

let user = User(name: "John Doe", email: "doe.john@gmail.com", password: "veryStringPASSword")

let json = toJson(user:user)

if let json {
    print("User Payload:\n\(json)")

    /**
    User Payload:
    {
        "name" : "John Doe",
        "email" : "doe.john@gmail.com",
        "password" : "veryStringPASSword"
    }
    **/
}
```

## JSONDecoder

An object that decodes instances of a data type from JSONObjects

```swift
class JSONDecoder
```

```swift
func fromJson(payload: Data) -> User? {
    do {
        let jsonDecoder: JSONDecoder = JSONDecoder()
        let user = try jsonDecoder.decode(User.self, from: payload)
        return user
    } catch {
        print("Failed to decode user payload \(payload) \(error)")
        return nil
    }
}

let userBJson: Data? = """
{
    "name" : "Samuel Owino",
    "email" : "samuel.owino@gmail.com",
    "password" : "notSoStrongPassword"
}
""".data(using: .utf8)

if let userBJson {
    let userB = fromJson(payload: userBJson)

    if let userB {
        print("User From JSON \(userBJson) is:\n\(userB)")

    }
}
```

