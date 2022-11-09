import React, { useState } from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

// Import data
import { usp_data, general_data, enem_data, ita_data, ufabc_data, ufscar_data, unesp_data, unicamp_data, unifesp_data } from "../data/universities";

import "../css/pages/UniversitiesPage.css";

const UniversitiesPage = () => {

    const [content, setContent] = useState(general_data)

    const handleChange = (data) => {
        setContent(data)
    }

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Universidades</h2>

                    <div className="uni-menu">
                        <div className="uni-menu-content">
                            <div className="uni-menu-item" onClick={() => handleChange(general_data)}>Estatísticas gerais</div>
                            <div className="uni-menu-item" onClick={() => handleChange(enem_data)}>ENEM</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ufabc_data)}>UFABC</div>
                            <div className="uni-menu-item" onClick={() => handleChange(usp_data)}>USP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ufscar_data)}>UFSCAR</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unicamp_data)}>UNICAMP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unesp_data)}>UNESP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unifesp_data)}>UNIFESP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ita_data)}>ITA</div>
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

export default UniversitiesPage;