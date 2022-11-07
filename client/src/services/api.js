import axios from 'axios'

export const api = axios.create({
    baseURL: 'http://localhost:8080',
})

export const getAllUsers = async () => { 
    return await api.get('/api/usuario/listar')
}

export const getUser = async (id) => {
    return await api.get(`/api/usuario/${id}`)
}

export const getAllUniversities = async () => {
    return await api.get('/api/universidade/listar')
}
