import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

const StudentHome = () => {

    return (
        <div className="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Home</h2>

                    <div>
                    EasyVest é um site que visa agregar informações diversas sobre o ENEM e os principais vestibulares de universidades públicas do estado de São Paulo (datas, formas de ingresso, campi, cursos, programas sociais, etc.), além de oferecer ferramentas para auxiliar os estudos dos usuários. Dentre as universidades selecionadas para estarem na plataforma, tem-se: UFABC, USP, UFSCAR, UNICAMP, UNESP, UNIFESP e ITA. Além da agregação de dados, o software visa oferecer a possibilidade de construir uma agenda de estudos para o aluno e um calendário de datas de vestibulares, além de incluir simulados de provas anteriores e mapas com os campus que integram cada universidade. Também será possível que o aluno filtre os dados, possibilitando a busca por curso, endereço, etc.
                    </div>

                </div>
            </div>
        </div>
    )
}

export default StudentHome;