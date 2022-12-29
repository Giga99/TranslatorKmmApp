//
//  SmallLanguageIcon.swift
//  iosApp
//
//  Created by Igor Stevanovic on 30.12.22..
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SmallLanguageIcon: View {
    var language: UiLanguage
    
    var body: some View {
        Image(uiImage: UIImage(named: language.imageName.lowercased())!)
            .resizable()
            .frame(width: 30, height: 30)
    }
}

struct SmallLanguageIcon_Previews: PreviewProvider {
    static var previews: some View {
        SmallLanguageIcon(
            language: UiLanguage(imageName: "german", language: .german)
        )
    }
}
