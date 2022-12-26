//
//  LandmarkRow.swift
//  ComposingLayouts
//
//  Created by Samuel Owino on 30/11/2021.
//

import SwiftUI


struct LandmarkRow: View {
    
    var landmark: Landmark
    
    var body: some View {
        HStack {
            landmark.image
                .resizable()
                .frame(width: 50, height: 50)
            
            VStack {
                Text(landmark.name)
                Text(landmark.park)
                    .lineLimit(1)
            }
            
            Spacer()
            
            if landmark.isFavorite {
                Image(systemName: "star.fill")
                    .foregroundColor(.yellow)
            }
        }
    }
}

struct LandmarkRow_Previews: PreviewProvider {
    static var landmarks = ModelData().landmarks
    static var previews: some View {
        Group {
            LandmarkRow(landmark: landmarks[1])
                .previewLayout(.fixed(width: 300, height: 70))
            
                    LandmarkRow(landmark: landmarks[6])
                        .previewLayout(.fixed(width: 300, height: 70))
        }
    }
}
