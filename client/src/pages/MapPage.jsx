import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

const MapPage = () =>{

    return (
        <>
            <Sidebar/>
            <div className="page-wrap">
                <Header/>
                <div className="page-content">
                    <h2>Mapa</h2>
                </div>
            </div>
        </>
    )
}

export default MapPage;