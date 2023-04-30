//
//  ContentView.swift
//  iOS16Navigation
//
//  Created by Samuel Owino on 01/05/2023.
//

import SwiftUI

struct ContentView: View {
    
    @State var isLoadingCompleted = false
    @AppStorage("user.exists.key") var userAlreadyExists = true
    @AppStorage("user.logged.in.key") var userLoggedin = false
    @State var autoSigninEnabled = false
    
    var body: some View {
        VStack {
            if isLoadingCompleted {
                if userAlreadyExists {
                    if autoSigninEnabled {
                        // EXISTING USER NAVIGATION SPLIT VIEW
                        NavigationSplitView {
                            DashboardView()
                        } detail: {
                            TasksDashboardView()
                        }
                    } else {
                        if userLoggedin {
                            // EXISTING USER NAVIGATION SPLIT VIEW
                            NavigationSplitView {
                                DashboardView()
                            } detail: {
                                TasksDashboardView()
                            }
                        } else {
                            // NEW USER NAVIGATION SPLIT VIEW
                            NavigationStack {
                                SigninView()
                            }
                        }
                        
                    }
                } else {
                    // NEW USER NAVIGATION SPLIT VIEW
                    NavigationStack {
                        RegistrationView()
                    }
                }
            } else {
               SplashView()
            }
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: DispatchTime.now() + 2.5){
                withAnimation {
                    isLoadingCompleted = true
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
