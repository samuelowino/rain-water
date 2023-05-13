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
            Text("menu")
        } content: {
            Text("content")
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
