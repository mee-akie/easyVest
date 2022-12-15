import React from 'react'
import ReactDOM from 'react-dom'
import {BrowserRouter as Router, Navigate, Route, Routes} from "react-router-dom";

import "./css/Global.css";

// Import pages
import StudentHome from "./pages/StudentHome";
import CalendarPage from "./pages/CalendarPage";
import UniversitiesPage from "./pages/UniversitiesPage";
import QuestionsPage from "./pages/QuestionsPage";
import MapPage from "./pages/MapPage";
import LoginPage from "./pages/LoginPage";

import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';

library.add(fas);

const Private = ({children}) => {
  const recoveredUser = localStorage.getItem('u')
  if(recoveredUser == null || recoveredUser == ''){
      return <Navigate to='/login' replace={true}/>
  }
  return children
}

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<StudentHome />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/calendar" element={<Private><CalendarPage/></Private>} />
        <Route path="/universities" element={<UniversitiesPage />} />
        <Route path="/questions" element={<QuestionsPage />} />
        <Route path="/map" element={<MapPage />} />
      </Routes>
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);