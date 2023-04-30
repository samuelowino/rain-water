//
//  SigninView.swift
//  iOS16Navigation
//
//  Created by Samuel Owino on 01/05/2023.
//

import SwiftUI

struct SigninView: View {
    var body: some View {
        VStack {
            Spacer()
            Text("Sign in form")
                .font(.title)
            
            NavigationLink("Sign up", destination: RegistrationView())
                .buttonStyle(PlainButtonStyle())
                .padding()
            
            Button {
                UserDefaults.standard.set(true, forKey: "user.exists.key")
                UserDefaults.standard.set(true, forKey:
                                            "user.logged.in.key")
            } label: {
                Label("Click to Finish Sign in", systemImage: "bin")
                    .font(.headline)
                    .foregroundColor(.white)
                    .padding()
                    .background(.black)
                    .clipShape(RoundedRectangle(cornerRadius: 14))
            }
            Spacer()
            
            
        }
    }
}

struct SigninView_Previews: PreviewProvider {
    static var previews: some View {
        SigninView()
    }
}
