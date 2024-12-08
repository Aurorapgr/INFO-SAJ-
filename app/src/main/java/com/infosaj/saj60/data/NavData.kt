package com.infosaj.saj60.data


object NavData {
    val Nav1 : List<NavInfo> = listOf(
        NavInfo(
            id = "0",
            title = "Saúde",
            tabInfo = listOf(
                "Sistema Único de Saúde - SUS",
                "Instituições Filantrópicas e ONGS",
                "Serviços da UFRB",
                "Defensoria Pública"
            )
        ),
        NavInfo(
            id = "1",
            title = "Assitência Social",
            tabInfo = listOf(
                "CRAS - Centro de Referência de Assistência Social",
                "CREAS - Centro de Referência Especializado de Assistência Social",
                "Espaço Conviver SAJ"
            )
        ),
        NavInfo(
            id = "2",
            title = "Lazer e Educação",
            tabInfo = listOf(
                "UATI - Universidade Aberta à Terceira Idade (UNEB)",
                "VOSA - Voluntários Solidários em Ação",
                "Secretaria de Educação"
            )
        ),
        NavInfo(
            id = "3",
            title = "Direitos e Segurança",
            tabInfo = listOf(
                "Central de Denúncias",
                "Defensoria Pública",
                "Ministério Público",
                "Conselho municipal dos direitos da pessoa idosa",
                "Delegacia",
                "Informações sobre o Empréstimo Consignado",
                "Informações sobre o Benefício de Prestação Continuada - BPC"
            )
        )
    )
}