import React from "react";
import styled from 'styled-components';
import Select from 'react-select';

const SearchDropdown = (props) => {

    return(
			<Container>
					<h4>{props.title}</h4>
					<Select
						closeMenuOnSelect={false}
						options={props.options}
						defaultValue={{ label: "-- Select --", value: 0 }}
					/>
			</Container>
    )
}

const Container = styled.div`
	width: 280px;
	height: 95px;
	padding: 10px 20px 0px 30px;

	h4 {
		font-size: 15px;
		height: 15px;
		line-height: 15px;
		padding: 10px 0px 0px 0px;
	 }
`

export default SearchDropdown;