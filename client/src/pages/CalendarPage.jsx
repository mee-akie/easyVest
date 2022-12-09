import React from "react";
import {useState} from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import Calendar from "../components/Calendar";

import '../css/pages/CalendarPage.css'


const CalendarPage = () => {

    const [events, setEvents] = useState([])

    return (
        <div class="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Agenda</h2>
                    <div className="agenda-page-wrapper">
                        <div className="calendar-wrapper">
                            <Calendar events={events}></Calendar>
                        </div>
                        <div>a</div>
                    </div> 
                </div>
            </div>
        </div>
    )
}

export default CalendarPage;