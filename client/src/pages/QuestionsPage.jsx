import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import Simulado from "../components/Simulado";

import "../css/pages/QuestionsPage.css";

const QuestionsPage = () => {

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Simulados</h2>

                    <div className="uni-menu">
                        <div className="uni-menu-content">
                            <div className="uni-menu-item">ENEM</div>
                            <div className="uni-menu-item">UFABC</div>
                            <div className="uni-menu-item">USP</div>
                            <div className="uni-menu-item">UFSCAR</div>
                            <div className="uni-menu-item">UNICAMP</div>
                            <div className="uni-menu-item">UNESP</div>
                            <div className="uni-menu-item">UNIFESP</div>
                            <div className="uni-menu-item">ITA</div>
                        </div>
                    </div>

                    <div className="simulados-container">
                        <Simulado simulado_name="Fuvest 2021" simulado_questions="/" simulado_answers="/"></Simulado>
                        <Simulado simulado_name="Fuvest 2020" simulado_questions="/" simulado_answers="/"></Simulado>
                        <Simulado simulado_name="Fuvest 2019" simulado_questions="/" simulado_answers="/"></Simulado>
                        <Simulado simulado_name="Fuvest 2018" simulado_questions="/" simulado_answers="/"></Simulado>
                        <Simulado simulado_name="Fuvest 2017" simulado_questions="/" simulado_answers="/"></Simulado>
                    </div>

                </div>
            </div>
        </div>
    )
}

export default QuestionsPage;