//
//  RegistrationView.swift
//  iOS16Navigation
//
//  Created by Samuel Owino on 01/05/2023.
//

import SwiftUI

struct RegistrationView: View {
    var body: some View {
        VStack {
            Text("Sign up form")
                .font(.title)
            
            NavigationLink("Sign in", destination: SigninView())
                .buttonStyle(PlainButtonStyle())
                .padding()
            
            Button {
                UserDefaults.standard.set(true, forKey: "user.exists.key")
            } label: {
                Label("Click to Finish Sign up", systemImage: "bin")
                    .padding()
                    .background(.orange)
                    .clipShape(RoundedRectangle(cornerRadius: 14))
            }
        }
        
    }
}

struct RegistrationView_Previews: PreviewProvider {
    static var previews: some View {
        RegistrationView()
    }
}
