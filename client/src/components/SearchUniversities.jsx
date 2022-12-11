import React from "react";
import styled from "styled-components";
import { GetAllCourses } from "../services/api"
import SearchDropdown from "../components/SearchDropdown";

function createDataOptions(data) {
	let options = []

	if (data != null){
		data.forEach(element => {
			options.push({ label: element.nome, value: element.nome })
		});
	}

	return options
}

const SearchUniversities = () => {	
	const courses = createDataOptions(GetAllCourses())
	const city = createDataOptions(GetAllCourses())

	return(
		<Container>
			<h3>Busque universidades por:</h3>
			<SearchDropdown title='Curso de graduação (opcional)' options={courses}/>
			<SearchDropdown title='Cidade (opcional)' options={city}/>
		</Container>
	)
}

const Container = styled.div`
	width: 300px;
	background-color: var(--cinzaClaro);
	margin-top: 70px;
	margin-left: 55px;
	margin-right: 30px;
	height: 400px;
	padding: 10px 10px 0px 0px;
	border-radius: 10px;
	border: solid;
	border-color: var(--azulEscuro);

	h3 {
		height: 20px;
		text-transform: uppercase;
		line-height: 1.3;
		padding-left: 25px;
	 }
`

export default SearchUniversities;