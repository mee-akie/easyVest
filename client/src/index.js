import React from 'react'
import ReactDOM from 'react-dom'
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

// Import pages
import StudentHome from "./pages/StudentHome";
import CalendarPage from "./pages/CalendarPage";
import UniversitiesPage from "./pages/UniversitiesPage";
import QuestionsPage from "./pages/QuestionsPage";
import MapPage from "./pages/MapPage";

import "./css/Global.css";

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element = {<StudentHome/>}/>
        <Route path="/calendar" element = {<CalendarPage/>}/>
        <Route path="/universities" element = {<UniversitiesPage/>}/>
        <Route path="/questions" element = {<QuestionsPage/>}/>
        <Route path="/map" element = {<MapPage/>}/>
      </Routes>
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);