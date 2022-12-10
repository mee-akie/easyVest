import React, { useState } from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

// Import data
import { usp_map, unicamp_map, unesp_map, ufabc_map, ufscar_map, unifesp_map, ita_map } from "../data/maps";

import "../css/pages/MapPage.css";

const MapPage = () => {

    const [content, setContent] = useState(usp_map)

    const handleChange = (data) => {
        setContent(data)
    }

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Mapa</h2>

                    <div className="uni-menu">
                        <div className="uni-menu-content">
                            <div className="uni-menu-item" onClick={() => handleChange(usp_map)}>USP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unicamp_map)}>UNICAMP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unesp_map)}>UNESP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ufabc_map)}>UFABC</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ufscar_map)}>UFSCAR</div>
                            <div className="uni-menu-item" onClick={() => handleChange(unifesp_map)}>UNIFESP</div>
                            <div className="uni-menu-item" onClick={() => handleChange(ita_map)}>ITA</div>
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

export default MapPage;