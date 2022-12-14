import { useState, useEffect} from 'react'
import axios from 'axios'

// GET requests
function GetApiData(path) {
	const [data, setData] = useState(null);

  useEffect(() => {
    axios.get(path).then((response) => {
      setData(response.data);
    });
  }, [path]);

  return data
}


// USER API
export function getAllUsers() { 
	return GetApiData('/api/usuario/listar')
}

export function getUserById(id) {
	return GetApiData(`/api/usuario/${id}`)
}

export function GetUserByUsernamePassword(login, senha) {
  	return axios.post('api/usuario/login', {
		"login": login,
		"senha": senha
	})
}

export function postAddUser(login, nome, senha) {
	return axios.post('api/usuario/add', {
		"login": login,
		"nome": nome,
		"premium": false,
		"senha": senha
	})
}

//CALENDAR API
export function getEvents(id){
	return axios.get(`/api/registro/listar/${id}`)
}

export function postAddEvent(registro_nome, registro_inicio, registro_fim, usuario_id, usuario_premium, usuario_nome, usuario_senha, usuario_login){
	return axios.post('/api/registro/add', {
		"registro_nome": registro_nome,
		"registro_inicio": registro_inicio,
		"registro_fim": registro_fim,
		"usuario": {
			"usuario_id": usuario_id,
			"usuario_premium": usuario_premium,
			"usuario_nome": usuario_nome,
			"usuario_senha": usuario_senha,
			"usuario_login": usuario_login
    }
	})
}

export function putUpdateEvent(registro_id, registro_nome, registro_inicio, registro_fim, usuario_id, usuario_premium, usuario_nome, usuario_senha, usuario_login){
	return axios.put(`/api/registro/update/${registro_id}`, {
		"registro_nome": registro_nome,
		"registro_inicio": registro_inicio,
		"registro_fim": registro_fim,
		"usuario": {
			"usuario_id": usuario_id,
			"usuario_premium": usuario_premium,
			"usuario_nome": usuario_nome,
			"usuario_senha": usuario_senha,
			"usuario_login": usuario_login
    }
	})
}

export function deleteEvent(registro_id, registro_nome, registro_inicio, registro_fim, usuario_id, usuario_premium, usuario_nome, usuario_senha, usuario_login){
	return axios.delete(`/api/registro/delete`, {
		data:{
			"registro_id": registro_id,
			"registro_nome": registro_nome,
			"registro_inicio": registro_inicio,
			"registro_fim": registro_fim,
			"usuario": {
				"usuario_id": usuario_id,
				"usuario_premium": usuario_premium,
				"usuario_nome": usuario_nome,
				"usuario_senha": usuario_senha,
				"usuario_login": usuario_login}
		}
	})
}


// UNIVERSITY API
export function getAllUniversities() {
	return GetApiData('/api/universidade/listar')
}

export function getUniversityById(id) {
	return GetApiData(`/api/universidade/${id}`)
}

export function getAllUniversityCourses(universityId) {
	return GetApiData(`/api/universidade/listarCursos/${universityId}`)
}

export function getAllUniversityCampus(campusId) {
	return GetApiData(`/api/universidade/listarCampus/${campusId}`)
}


// EXAM API
export function getAllExams() {
	return GetApiData('/api/vestibular/listar')
}

export function getExamById(id) {
	return GetApiData(`/api/vestibular/${id}`)
}


// COURSE API
export function getAllCourses() {
	return GetApiData('/api/curso/listar')
}

export function getCourseById(id) {
	return GetApiData(`/api/curso/${id}`)
}


// CAMPUS API
export function getAllCampi() {
	return GetApiData('/api/campus/listar')
}

export function getCampusById(id) {
	return GetApiData(`/api/campus/${id}`)
}


// SUBJECT API
export function getAllSubjects() {
	return GetApiData('/api/disciplina/listar')
}

export function getSubjectById(id) {
	return GetApiData(`/api/disciplina/${id}`)
}


// CLASS API
export function getAllClasses() {
	return GetApiData('/api/aula/listar')
}

export function getClassById(id) {
	return GetApiData(`/api/aula/${id}`)
}


// THEME API
export function getAllThemes() {
	return GetApiData('/api/tema/listar')
}

export function getThemeById(id) {
	return GetApiData(`/api/tema/${id}`)
}


// EXERCISE LIST API
export function getAllExerciseList() {
	return GetApiData('/api/lista/listar')
}

export function getExerciseListById(id) {
	return GetApiData(`/api/lista/${id}`)
}


// EXERCISE API
export function getAllExercise() {
	return GetApiData('/api/exercicio/listar')
}

export function getExerciseById(id) {
	return GetApiData(`/api/exercicio/${id}`)
}