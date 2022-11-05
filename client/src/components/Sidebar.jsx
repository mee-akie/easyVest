import React from "react";
import { useNavigate } from "react-router-dom";

import "../css/components/Sidebar.css"

// Import logos
import areaDoAluno from "../img/aluno.png";
import agenda from "../img/agenda.png";
import universidades from "../img/universidades.png";
import simulados from "../img/simulados.png";
import mapa from "../img/mapa.png";

const Sidebar = () => {

    const history = useNavigate();

    const handleItemCLick = (_route) => {
        history(_route)
    }

    return (
        <div className="sidebar">
            <div className="sidebar-item" onClick={() => handleItemCLick('/')}>
                <img src={areaDoAluno} alt="" />
                <div>Área do Aluno</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/calendar')}>
                <img src={agenda} alt="" />
                <div>Agenda</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/universities')}>
                <img src={universidades} alt="" />
                <div>Universidades</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/questions')}>
                <img src={simulados} alt="" />
                <div>Simulados</div>
            </div>

            <div className="sidebar-item" onClick={() => handleItemCLick('/map')}>
                <img src={mapa} alt="" />
                <div>Mapa</div>
            </div>

        </div>
    )
}

export default Sidebar;