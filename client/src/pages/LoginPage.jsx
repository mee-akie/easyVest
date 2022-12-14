import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

import "../css/pages/LoginPage.css";

// Import components
import Header from "../components/Header";
import LoginForm from '../components/LoginForm';
import SignUpForm from '../components/SignUpForm';

const LoginPage = () => {

    const [isLogin, setIsLogin] = useState(true)

    return(
        <div className='wrapper'>
            <div className='login-page-wrap'>
                <Header/>
                <div className='form-wrapper'>
                    {isLogin ? <LoginForm/> : <SignUpForm/>}

                    <div className='swap-function'>
                        <p>{isLogin ? <>Não tem uma conta?</>: <>Já possui uma conta?</>}</p>
                        <p className="swap-text" onClick={() => {setIsLogin(!isLogin)}}>{isLogin ? <>Cadastre-se.</>: <>Entrar.</>}</p>
                    </div>
                </div>
            </div>
        </div>  
    )
}

export default LoginPage