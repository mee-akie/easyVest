import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import { getAllUniversities, getAllUsers, getUser, getUserId } from "../services/api";

const CalendarPage = () => {

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Agenda</h2>
                </div>
            </div>
        </div>
    )
}

export default CalendarPage;