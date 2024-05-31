import Titulo from "./Titulo.tsx";
import {Persona} from "../../src-generated/openapi";
import {useEffect, useState} from "react";
import {usePersonaController} from "../util/api.ts";

export interface ListPersonasProp{
	renderCounter: number;
}

export default ({renderCounter}: ListPersonasProp) => {

	const personaController = usePersonaController();

	const [personas, setPersonas] = useState<Persona[]>([])

	const actualizarPersonas = () => {
		personaController.getPersonas().then(resp => {
			setPersonas(resp.data);
		});
	};

	useEffect(() => {
		actualizarPersonas();
	}, [renderCounter]);


	return (
		<>
			<Titulo texto={"Listado de personas"}/>
			<button onClick={_ => {
				actualizarPersonas();
			}}>actualizar</button>
			<ul>
				{personas.map((persona) => (
					<li>{persona.nombre}</li>
				))}
			</ul>
			{personas.length == 0 && (
				<p>No hay personas</p>
			)}
		</>
	)
}