import React, { useState } from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

// Import data
import { enem_simulados, usp_simulados, unicamp_simulados, unesp_simulados, ita_simulados } from "../data/simulados";

import "../css/pages/QuestionsPage.css";

const QuestionsPage = () => {

    const [content, setContent] = useState(enem_simulados)

    const handleChange = (data) => {
        setContent(data)
    }

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Simulados</h2>

                    <div className="uni-menu">
                        <div className="uni-menu-content">
                            <div className="uni-menu-item" onClick={() => handleChange(enem_simulados)}>ENEM</div>
                            <div className="uni-menu-item" onClick={() => handleChange(usp_simulados)}>USP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unicamp_simulados)}>UNICAMP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unesp_simulados)}>UNESP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ita_simulados)}>ITA</div>
                        </div>
                    </div>

                    <div>
                        {content}
                    </div>

                </div>
            </div>
        </div>
    )
}

export default QuestionsPage;