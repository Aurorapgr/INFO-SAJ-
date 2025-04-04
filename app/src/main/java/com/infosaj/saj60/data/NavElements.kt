package com.infosaj.saj60.data

import com.infosaj.saj60.Cdd
import com.infosaj.saj60.GenericView
import com.infosaj.saj60.UsfStandard

object NavElements {
    val telas: List<Tela> = listOf(
        Tela(
            title = "Saúde",
            btns = listOf(
                Btn("Sistema Único de Saúde - SUS",1,null, null, null),
                Btn("Instituições Filantrópicas e ONGS",2,null, null, null),
                Btn("Serviços da UFRB",3,null, null, null),
                Btn("Defensoria Pública",null,UsfStandard::class.java, DirSegData.dirSeg, 0)
            )
        ),
        Tela(
            title = "SUS",
            btns = listOf(
                Btn("USF’S - Unidades de Saúde da Família ",4,null, null, null),
                Btn("Policlínica Regional de Santo Antônio de Jesus",null,UsfStandard::class.java, Data.sus, 0),
                Btn("HRSAJ - Hospital Regional de Santo Antônio de Jesus ",null,UsfStandard::class.java, Data.sus, 1),
                Btn("Policlínica Municipal",null,UsfStandard::class.java, Data.sus, 2),
                Btn("UNACON",null, UsfStandard::class.java, Data.sus, 3)
            )
        ),
        Tela(
            title = "INSTITUIÇÕES FILANTRÓPICAS E ONGS",
            btns = listOf(
                Btn("IDSAJ - Instituto dos diabéticos de SAJ", refpt = null,UsfStandard::class.java, Data.instOngs, 0),
                Btn("ASDEV", refpt = null,UsfStandard::class.java, Data.instOngs, 1),
                Btn("Lar dos Idosos", refpt = null,UsfStandard::class.java, Data.instOngs, 2)
            )
        ),
        Tela(
            title = "UFRB - Serviços da Universidade Federal do Recôncavo da Bahia",
            btns = listOf(
                Btn("LABCOV - Laboratório de Vigilância e Diagnóstico Avançado", refpt = null,UsfStandard::class.java, Data.servUFRB, 0),
                Btn("Serviço de Psicologia", refpt = null,UsfStandard::class.java, Data.servUFRB, 1)
            )
        ),
        Tela(
            title = "USF’S - Unidades de Saúde da Família ",
            btns =listOf(
                Btn("USF Alto do Morro", null, UsfStandard::class.java, Data.usfs, 0),
                Btn("USF Alto Santo Antônio", null, UsfStandard::class.java, Data.usfs, 1),
                Btn("USF Alto Sobradinho I e II", null, UsfStandard::class.java, Data.usfs, 2),
                Btn("USF do Andaiá", null, UsfStandard::class.java, Data.usfs, 3),
                Btn("USF do Amparo", null, UsfStandard::class.java, Data.usfs, 4),
                Btn("USF Aurelino Pereira Dos Reis", null, UsfStandard::class.java, Data.usfs, 5),
                Btn("USF Bairro Irmã Dulce", null, UsfStandard::class.java, Data.usfs, 6),
                Btn("USF Bela Vista", null, UsfStandard::class.java, Data.usfs, 7),
                Btn("USF Boa Vista Bomfim", null, UsfStandard::class.java, Data.usfs, 8),
                Btn("UBS Casaca de Ferro", null, UsfStandard::class.java, Data.usfs, 9),
                Btn("UBS Cidade Nova II", null, UsfStandard::class.java, Data.usfs, 10),
                Btn("USF do Calabar Urbis I", null, UsfStandard::class.java, Data.usfs, 11),
                Btn("USF Fernando Queiroz", null, UsfStandard::class.java, Data.usfs, 12),
                Btn("USF Geraldo Pessoa Salles II", null, UsfStandard::class.java, Data.usfs, 13),
                Btn("USF Marita Amâncio", null, UsfStandard::class.java, Data.usfs, 14),
                Btn("USF Povoado do Cocão Minas do Sapé", null, UsfStandard::class.java, Data.usfs, 15),
                Btn("USF São Francisco I e II", null, UsfStandard::class.java, Data.usfs, 16),
                Btn("USF São Paulo", null, UsfStandard::class.java, Data.usfs, 17),
                Btn("USF Santa Madalena", null, UsfStandard::class.java, Data.usfs, 18),
                Btn("USF Urbis III", null, UsfStandard::class.java, Data.usfs, 19),
                Btn("USF Viriato Lobo", null, UsfStandard::class.java, Data.usfs, 20),
                Btn("UBS Zilda Arns", null, UsfStandard::class.java, Data.usfs, 21)
            )
        ),
        Tela(
            title = "Assitência Social",
            btns = listOf(
                Btn("CRAS - Centro de Referência de Assistência Social",null,UsfStandard::class.java,Data.assSocial,0),
                Btn("CREAS - Centro de Referência Especializado de Assistência Social",null,UsfStandard::class.java,Data.assSocial,1),
                Btn("Espaço Conviver SAJ",null,UsfStandard::class.java,Data.assSocial,2),
            )
        ),
        Tela(
            title = "Lazer e Educação",
            btns = listOf(
                Btn("UATI - Universidade Aberta à Terceira Idade (UNEB)",null,UsfStandard::class.java,LazerEducData.lazerEduca,0),
                Btn("VOSA - Voluntários Solidários em Ação",null,UsfStandard::class.java,LazerEducData.lazerEduca,1),
                Btn("Secretaria de Educação",null,UsfStandard::class.java,LazerEducData.lazerEduca,2)
            )
        ),
        Tela(
            title = "Direitos e Segurança",
            btns = listOf(
                Btn("Central de Denúncias",null, Cdd::class.java,DirSegData.dirSeg,0),
                Btn("Defensoria Pública",null,UsfStandard::class.java,DirSegData.dirSeg,0),
                Btn("Ministério Público",null,UsfStandard::class.java,DirSegData.dirSeg,1),
                Btn("Conselho municipal dos direitos da pessoa idosa",null,UsfStandard::class.java,DirSegData.dirSeg,2),
                Btn("Delegacia",null,UsfStandard::class.java,DirSegData.dirSeg,3),
                Btn("Informações sobre o Empréstimo Consignado",null,UsfStandard::class.java,DirSegData.dirSeg,4),
                Btn("Informações sobre o Benefício de Prestação Continuada - BPC",null,UsfStandard::class.java,DirSegData.dirSeg,5)
            )
        )
    )
}