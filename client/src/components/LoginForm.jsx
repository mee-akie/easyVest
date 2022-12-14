import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

import "../css/components/LoginForm.css";

const LoginForm = () => {
    const history = useNavigate();

    const [form, setForm] = useState({usuario: '', senha: '',})

    const [error_message, setError] = useState('')

    const handleSubmit = async (e) => {
        try{
            e.preventDefault()
            console.log(form)
        }
        catch(err){
            
        }
    }

    const handleChange = (e) =>{
        setForm({...form, [e.target.name]: e.target.value})
    }

    return(
        <div className='login-form-wrap'>
            <h2>Login</h2>
            <p className='error'>{error_message}</p>
            <form onSubmit={handleSubmit}>
                <div className="form-input-wrap">
                    <label htmlFor='usuario'>Usuário:</label>
                    <input name="usuario" type="text" className='login-input' placeholder='Usuário' onChange={handleChange}></input>
                </div>
                <div className="form-input-wrap">
                    <label htmlFor='senha'>Senha:</label>
                    <input name = "senha" type="password" className='login-input' placeholder='Senha' onChange={handleChange}></input>
                </div>
                <button onClick={handleSubmit}>Login</button>
            </form>
        </div>
    )
}

export default LoginForm