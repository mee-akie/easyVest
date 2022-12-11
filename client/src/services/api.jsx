import React, {useState} from 'react'
import axios from 'axios'

export const getAllUsers = async () => { 
  return await axios.get('/api/usuario/listar')
}

export const getUser = async (id) => {
  return await axios.get(`/api/usuario/${id}`)
}

export const getAllUniversities = async () => {
	return await axios.get('/api/universidade/listar')
}

export function GetAllCourses() {
  const [data, setData] = React.useState(null);

  React.useEffect(() => {
    axios.get('/api/curso/listar').then((response) => {
      setData(response.data);
    });
  }, []);

  return data
}