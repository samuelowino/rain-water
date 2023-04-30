//
//  SettingsView.swift
//  iOS16Navigation
//
//  Created by Samuel Owino on 01/05/2023.
//

import SwiftUI

struct SettingsView: View {
    
    @State var autoLogin = false
    
    var body: some View {
        VStack {
            Text("Settings")
            
            Spacer()
            
            Form {
                Section {
                    Toggle("Auto login", isOn: $autoLogin)
                } footer: {
                    Text("When enabled user will be auto logged in")
                }
            }
        }
    }
}

struct SettingsView_Previews: PreviewProvider {
    static var previews: some View {
        SettingsView()
    }
}
