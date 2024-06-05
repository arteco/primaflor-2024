import Titulo from "./Titulo.tsx";
import {Persona} from "../../src-generated/openapi";
import {useEffect, useState} from "react";
import {usePersonaController} from "../util/api.ts";

export interface ListPersonasProp{
	renderCounter: number;
	setIdPersona:  React.Dispatch<React.SetStateAction<number| undefined>>
}

export default ({renderCounter, setIdPersona}: ListPersonasProp) => {
	
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
				{personas.map((persona,i) => (
					<li style={{lineHeight:"2em"}} key={i}>
						{persona.nombre}
						<button style={{float:"right", fontSize:"0.8em"}}
								onClick={_ => {
									if(confirm("Desea borrar el registro?")){
										personaController.deletePersona(persona.id as number)
										.then(_=> {
											actualizarPersonas();
										})
									}
								}}
						>borrar</button>
						<button style={{float:"right", fontSize:"0.8em",marginRight:"1em"}}
								onClick={_ => {
										// Se ha seleccionado una persona
										setIdPersona(persona.id)
								}}
						>editar</button>
					</li>
				))}
			</ul>
			{personas.length == 0 && (
				<p>No hay personas</p>
			)}
		</>
	)
}