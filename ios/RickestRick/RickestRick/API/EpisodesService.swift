//
//  EpisodesService.swift
//  RickestRick
//
//  Created by Samuel Owino on 17/01/2023.
//

import Foundation

class EpisodesService {
    private let urlSession: URLSession
    private var dataTask: URLSessionDataTask?
    private let episodesUrl: String = "https://rickandmortyapi.com/api/episode/28"
    
    init(urlSession: URLSession) {
        self.urlSession = urlSession
    }
    
    func fetchEpisode(completion: @escaping (Result<EpisodeResource, Error>) -> ()){
        dataTask?.cancel()
        
        guard let urlComponents = URLComponents(string: episodesUrl) else {
            return
        }
        
        guard let validUrl = urlComponents.url else {
            return
        }
        
        var httpRequest = URLRequest(url: validUrl, cachePolicy: URLRequest.CachePolicy.reloadIgnoringLocalCacheData, timeoutInterval: TimeInterval(floatLiteral: 1_000 * 30))
        
        httpRequest.httpMethod = SupportedHttpMethods.GET.rawValue
        httpRequest.setValue("application/json", forHTTPHeaderField: "Content-Type")
        
        //Completion handler has: Data?, URLResponse? and Error?
        dataTask = urlSession.dataTask(with: httpRequest, completionHandler: { data, response, error in
            //api response here...
            if let error {
                print("Http request \(httpRequest) failed ❌ with error \(error)")
                return
            }
            
            print("Http request \(httpRequest) was successful ✅")
            
            guard let response else {
                return
            }
            
            if let httpReponse: HTTPURLResponse = response as? HTTPURLResponse {
                print("http response \(httpReponse)")
            }
            
            do {
                let episode: EpisodeResource = try JSONDecoder().decode(EpisodeResource.self, from: data!)
                print("Data Json \(episode)")
                
                completion(.success(episode))
            } catch {
                print("JSON decoding failed \(error)")
                completion(.failure(error))
            }
            
            
            
        })
        
        dataTask?.resume()
        
    }
    
}
