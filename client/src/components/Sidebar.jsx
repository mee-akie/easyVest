import React from "react";
import { useNavigate } from "react-router-dom";

import "../css/components/Sidebar.css"

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

const Sidebar = () => {

    const history = useNavigate();

    const handleItemCLick = (_route) => {
        history(_route)
    }

    return (
        <div className="sidebar">
            <div className="sidebar-item" onClick={() => handleItemCLick('/')}>
                <FontAwesomeIcon icon="graduation-cap" />
                <div>Área do Aluno</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/calendar')}>
                <FontAwesomeIcon icon="calendar-alt" />
                <div>Agenda</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/universities')}>
                <FontAwesomeIcon icon="building-columns" />
                <div>Universidades</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/questions')}>
                <FontAwesomeIcon icon="book" />
                <div>Simulados</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/map')}>
                <FontAwesomeIcon icon="map-location-dot" />
                <div>Mapa</div>
            </div>

        </div>
    )
}

export default Sidebar;