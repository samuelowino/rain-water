//
//  Resource.swift
//  RickestRick
//
//  Created by Samuel Owino on 17/01/2023.
//

import Foundation

struct EpisodeResource : Codable {
    var id: Int
    var name: String
    var air_date: String
    var episode: String
    var characters: [String]
    var url: String
    var created: String
}
