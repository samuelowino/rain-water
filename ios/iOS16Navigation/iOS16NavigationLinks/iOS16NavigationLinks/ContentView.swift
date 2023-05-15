//
//  ContentView.swift
//  iOS16NavigationLinks
//
//  Created by Samuel Owino on 13/05/2023.
//

import SwiftUI

struct ContentView: View {
    
    @StateObject var viewModel = ViewModel()
    
    var body: some View {
        NavigationStack(path: $viewModel.path) {
            List(Category.allCases, id: \.self) { category in
                Section(category.rawValue) {
                    ForEach(recipes(in: category)) { recipe in
                        NavigationLink(recipe.name, value: recipe)
                    }
                }
            }
            .navigationTitle("Home")
            .navigationDestination(for: Recipe.self) { recipe in
                RecipeDetailed()
            }
        }
    }
}

class ViewModel: ObservableObject {
    // The navigation path
    @Published var path:[Recipe] = []
    
    func openRecipe(_ recipe: Recipe) {
        path = [recipe]
    }

    func popToRoot(){
        path.removeAll()
    }
}

enum Category: String, CaseIterable {
    case milk = "Milk"
    case drinks = "Drinks"
    case meat = "Meat"
    case other = "Other"
}

struct Recipe: Identifiable, Hashable {
    var id: UUID = UUID()
    var name: String = ""
    var category: Category = .other
}

private func recipes(in category: Category) -> [Recipe] {
    switch category {
    case .milk:
        return [
            Recipe(name: "Falifa stew", category: category),
            Recipe(name: "Maliwa", category: category),
            Recipe(name: "Dafi", category: category),
            Recipe(name: "Lifi", category: category),
        ]
    case .drinks:
        return [
            Recipe(name: "Gangi", category: category),
            Recipe(name: "Nagi", category: category),
            Recipe(name: "Zingi", category: category),
            Recipe(name: "Bambi", category: category),
        ]
    case .meat:
        return [
            Recipe(name: "Stewa", category: category),
            Recipe(name: "Ronada", category: category),
            Recipe(name: "Wuqata", category: category),
            Recipe(name: "Muspata", category: category),
        ]
    case .other:
        return [
            Recipe(name: "Jingat stew", category: category),
            Recipe(name: "Ria", category: category),
            Recipe(name: "Noif", category: category),
            Recipe(name: "Waquia", category: category),
        ]
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
