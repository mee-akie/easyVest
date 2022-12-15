import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

import "../css/components/LoginForm.css";
import { GetUserByUsernamePassword } from '../services/api';

const LoginForm = () => {
    const history = useNavigate();

    const [form, setForm] = useState({usuario: '', senha: '',})

    const [error_message, setError] = useState('')

    const handleSubmit = async (e) => {
        try{
            e.preventDefault()
            const loginResponse = await GetUserByUsernamePassword(form.usuario, form.senha)
            if(loginResponse.status === 200){
                localStorage.setItem('u', JSON.stringify(loginResponse.data))
                history('/calendar')
            }
        }
        catch(err){
            if(err.response.status === 404)
                setError('Usuário ou senha inválidos')
        }
    }

    const handleChange = (e) =>{
        setForm({...form, [e.target.name]: e.target.value})
        setError('')
    }

    return(
        <div className='login-form-wrap'>
            <h2>Login</h2>
            <p className='error'>{error_message}</p>
            <form onSubmit={handleSubmit}>
                <div className="form-input-wrap">
                    <label htmlFor='usuario'>Usuário:</label>
                    <input id="loginUsuario" name="usuario" type="text" className='login-input' placeholder='Usuário' onChange={handleChange}></input>
                </div>
                <div className="form-input-wrap">
                    <label htmlFor='senha'>Senha:</label>
                    <input id="loginSenha" name = "senha" type="password" className='login-input' placeholder='Senha' onChange={handleChange}></input>
                </div>
                <button id="submitButton" onClick={handleSubmit}>Login</button>
            </form>
        </div>
    )
}

export default LoginForm