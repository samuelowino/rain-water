//
//  ContentView.swift
//  RickestRick
//
//  Created by Samuel Owino on 17/01/2023.
//

import SwiftUI

struct ContentView: View {
    @State var episode: EpisodeResource? = nil
    var body: some View {
        VStack {
            if episode != nil {
                Text("Episode Name: \(episode!.name)")
                Text("Episode Air Date: \(episode!.air_date)")
            }
        }
        .padding()
        .task {
            EpisodesService(urlSession: URLSession.shared).fetchEpisode { result in
                do {
                    let remoteEpisode = try result.get()
                    
                    DispatchQueue.main.async {
                        episode = remoteEpisode
                    }
                    
                    print("Data \(remoteEpisode)")
                } catch {
                    print("Failed \(error)")
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
