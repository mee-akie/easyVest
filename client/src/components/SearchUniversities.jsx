import React from "react";
import styled from "styled-components";
import { getAllCourses, getAllCampi } from "../services/api"
import SearchDropdown from "../components/SearchDropdown";

function createCoursesOptions(data) {
	let options = []

	if (data != null){
		options.push({ label: "-- Select --", value: 0 })

		data.forEach(element => {
			options.push({ label: element.nome, value: element.id })
		});
	}

	return sortOptionsByLabel(options)
}

function createCityOptions(data) {
	let options = []

	if (data != null){

		// remove repeat data
		let uniqueData = []
		data.forEach(element => {
			uniqueData.push(element.campus_cidade)
		});
		uniqueData = [...new Set(uniqueData)]

		options.push({ label: "-- Select --", value: 0 })

		uniqueData.forEach(element => {
			options.push({ label: element, value: element })
		});
	}

	return sortOptionsByLabel(options)
}

function sortOptionsByLabel(options) {
	return options.sort(function(a, b) {
		const nameA = a.label.toUpperCase();
		const nameB = b.label.toUpperCase();
		
		if (nameA < nameB) {
			return -1;
		}
		if (nameA > nameB) {
			return 1;
		}
	
		return 0;
	})
}

const SearchUniversities = () => {
	const courses = createCoursesOptions(getAllCourses())
	const city = createCityOptions(getAllCampi())

	return(
		<Container>
			<h3>Busque universidades por:</h3>
			<SearchDropdown title='Curso de graduação (opcional)' options={courses}/>
			<SearchDropdown title='Cidade (opcional)' options={city}/>
			<Button> {'BUSCAR'} </Button>
		</Container>
	)
}

const Container = styled.div`
	width: 300px;
	background-color: var(--cinzaClaro);
	margin-top: 70px;
	margin-left: 55px;
	margin-right: 30px;
	height: 370px;
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

const Button = styled.button`
  background-color: var(--azulEscuro);
  color: white;
  font-size: 18px;
  padding: 10px 60px;
  border-radius: 10px;
	border-color: white;
  margin: 40px 45px;
  cursor: pointer;

	:hover{
    background-color: var(--azulEscuro);
		opacity: 0.8;
    color: white;
    transition-duration: 0.3s;
    cursor: pointer;
}
`

export default SearchUniversities;