import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

import {Formik, Form, Field} from "formik";
import * as Yup from 'yup'

import "../css/components/SignUpForm.css";
import { postAddUser } from '../services/api';

const SignUpForm = () => {
    const history = useNavigate();

    const [error, setError] = useState({})
    const [success, setSuccess] = useState(false)

    const handleSubmit = async (values) => {
        try{
            const resp = await postAddUser(values.usuario, values.nome, values.senha)
            console.log(resp)
            if(resp.status === 200) {
                setSuccess(true)
            } 
        }
        catch(err){
            setError(err)
        }
    }

    const schema = Yup.object().shape({
        usuario: Yup.string().min(6, 'Usuario deve conter ao menos 6 caracteres.').max(30, 'Usuario deve conter no máximo 30 caracteres').required('Usuario é um campo obrigatório.'),
        nome: Yup.string().min(3, 'Nome deve conter no mínimo 3 caracteres.').max(30, 'Nome deve conter no máximo 30 caracteres').required('Nome é um campo obrigatório.'),
        senha: Yup.string().min(8, 'Sua senha deve conter no mínimo 8 caracteres, ao menos uma letra maiúscula, ao menos uma letra minúscula e ao menos um número').matches(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/, 'Sua senha deve conter ao menos uma letra maiúscula, ao menos uma letra minúscula e ao menos um número').required('Senha é um campo obrigatório'),
        confirmaSenha: Yup.string().oneOf([Yup.ref('senha'), null], 'Senhas precisam ser iguais').required('Confirmar senha é um campo obrigatório'),
    })

    return(
        <div className='login-form-wrap'>
            <h2>SignUp</h2>
            {success ? <p>Usuario criado com sucesso</p> : <></>}
            <Formik 
                validationSchema={schema}

                initialValues={{
                    usuario: '',
                    nome: '',
                    senha: '',
                    confirmaSenha: '',
                }}

                onSubmit={values => handleSubmit(values)}
            >
                {({errors}) => (
                    <Form>
                        <div className='signup-input-wrap'>
                            <label htmlFor="usuario">Usuário: </label>
                            <Field className="signup-input" id="usuario" name="usuario" type="text" placeholder="Usuário"></Field>
                            {errors.usuario && (
                                <div className='error-message'>{errors.usuario}</div>
                            )}
                        </div>

                        <div className='signup-input-wrap'>
                            <label htmlFor="nome">Nome: </label>
                            <Field className="signup-input" id="nome" name="nome" type="text" placeholder="Nome"></Field>
                            {errors.nome && (
                                <div className='error-message'>{errors.nome}</div>
                            )}
                        </div>

                        <div className='signup-input-wrap'>
                            <label htmlFor="senha">Senha: </label>
                            <Field className="signup-input" id="senha" name="senha" type="password" placeholder="Senha"></Field>
                            {errors.senha && (
                                <div className='error-message'>{errors.senha}</div>
                            )}
                        </div>

                        <div className='signup-input-wrap'>
                            <label htmlFor="confirmaSenha">Confirme sua senha: </label>
                            <Field className="signup-input" id="confirmaSenha" name="confirmaSenha" type="password" placeholder="Confirme sua senha"></Field>
                            {errors.confirmaSenha && (
                                <div className='error-message'>{errors.confirmaSenha}</div>
                            )}
                        </div>

                        <button type='submit'>Cadastrar</button>
                    </Form>
                )}
            </Formik>
        </div>
    )
}

export default SignUpForm