import Foundation

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

