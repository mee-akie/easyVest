import React from "react";

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

import "../css/components/Simulado.css"

const Simulado = ({simulado_name, simulado_questions, simulado_answers}) =>{

    return(
        <>
            <div className="simulado-container">
                <FontAwesomeIcon className="simulado-icon" icon="book" />
                <p className="simulado-name">{simulado_name}</p>
                <a className="simulado-link" href={simulado_questions}>Link do simulado</a> <br />
                <a className="simulado-link" href={simulado_answers}>Link do gabarito</a>
            </div>
        </>
    )
}

export default Simulado;