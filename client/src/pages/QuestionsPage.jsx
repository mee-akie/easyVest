import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

const QuestionsPage = () =>{

    return (
        <>
            <Sidebar/>
            <div className="page-wrap">
                <Header/>
                <div className="page-content">
                    <h2>Simulados</h2>
                </div>
            </div>
        </>
    )
}

export default QuestionsPage;