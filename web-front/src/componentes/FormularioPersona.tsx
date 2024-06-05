import Titulo from "./Titulo.tsx";
import {useEffect, useState} from "react";
import {usePersonaController} from "../util/api.ts";
import {Persona} from "../../src-generated/openapi";

export interface FormPersonaProp {
	idPersona?: number;
	renderCounter: number;
	setRenderCounter:  React.Dispatch<React.SetStateAction<number>>;
}

export default ({renderCounter, setRenderCounter, idPersona}: FormPersonaProp) => {

	const personaController = usePersonaController();

	const [id, setId] = useState<number | string | undefined>();
	const [nombre, setNombre] = useState<string>('')
	const [edad, setEdad] = useState<number>(0);

	useEffect(()=>{
		if (idPersona){
			personaController.getPersona(idPersona)
			.then(resp => {
				const persona = resp.data;
				setId(persona.id);
				setNombre(persona.nombre);
				setEdad(persona.edad);
			})
		}
	},[idPersona])

	return (
		<>
			<Titulo texto={"Formulario de persona"}></Titulo>

			<form>
				<label>id</label><br/>
				<input name={"id"} type={"number"}
					   value={id}
					   onChange={e => setId(parseInt(e.target.value))}/><br/><br/>

				<label>Nombre</label><br/>
				<input name={"nombre"} type={"texto"}
					   value={nombre}
					   onChange={e => setNombre(e.target.value)}/><br/><br/>

				<label>Edad</label><br/>
				<input name={"edad"} type={"number"}
					   value={edad}
					   onChange={e => setEdad(parseInt(e.target.value))}/><br/><br/>

				<button type={"button"} onClick={() => {
					//TODO: validar antes de enviar
					const persona: Persona = {id, nombre, edad};
					/*
					const p : Persona = {
						id : id,
						nombre: nombre,
						edad: edad,
					}
					*/
					personaController.savePersona(persona)
					.then(resp => {
						alert(JSON.stringify(resp.data));
						setRenderCounter(renderCounter + 1);
					}).catch(resp => {
						// TODO en caso de error, mostrar mensaje amigable al usuario
						alert(JSON.stringify(resp))
					})
				}}>Guardar
				</button>
				<button type={"button"} style={{marginLeft:"1em"}}
					onClick={_ =>{
						setId('');
						setNombre('')
						setEdad(0);
					}}>
					Limpiar
				</button>
			</form>

			<span>Datos: {nombre} + {edad} + {id}</span>
		</>
	)
}