import React from "react";
import {useState, useEffect } from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";
import Calendar from "../components/Calendar";

import '../css/pages/CalendarPage.css'
import { getEvents } from "../services/api";
import { components } from "react-select";

const CalendarPage = () => {

    const [events, setEvents] = useState([])
    const [value, setValue] = useState(0);

    const fetchData = () => {
        
        getEvents(JSON.parse(localStorage.getItem('u')).id).then((response) =>{
            const parsedArray = []
            for(let i = 0; i<response.data.length; i++){
                parsedArray.push({
                    start: response.data[i].registro_inicio.replace(' ', 'T'),
                    end: response.data[i].registro_fim.replace(' ', 'T'),
                    id: response.data[i].registro_id,
                    text: response.data[i].registro_nome
                })
            }
            setEvents(parsedArray)
        } )
    }

    useEffect(() => {
        fetchData()
    }, [])

    return (
        <div className="wrapper">
            <Sidebar />
            <div className="page-wrap">
                <Header />
                <div className="page-content">
                    <h2>Agenda</h2>
                    <div className="agenda-page-wrapper">
                        <div className="calendar-wrapper">
                            <Calendar events={events} />
                        </div>
                    </div> 
                </div>
            </div>
        </div>
    )
}

export default CalendarPage;