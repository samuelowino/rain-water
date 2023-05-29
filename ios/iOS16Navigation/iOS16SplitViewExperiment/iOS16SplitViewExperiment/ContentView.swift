//
//  ContentView.swift
//  iOS16SplitViewExperiment
//
//  Created by Samuel Owino on 13/05/2023.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationSplitView {
            NavigationLink("Home") {
                Text("Home view 🏡")
            }
        } content: {
            NavigationLink("Home") {
                Text("content of home")
            }
        } detail: {
            Text("Detail")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
