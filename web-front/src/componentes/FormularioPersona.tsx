import Titulo from "./Titulo.tsx";
import {useState} from "react";
import {usePersonaController} from "../util/api.ts";
import {Persona} from "../../src-generated/openapi";

export interface FormPersonaProp {
	renderCounter: number;
	setRenderCounter:  React.Dispatch<React.SetStateAction<number>>;
}

export default ({renderCounter, setRenderCounter}: FormPersonaProp) => {

	const personaController = usePersonaController();

	const [id, setId] = useState<number | undefined>();
	const [nombre, setNombre] = useState<string>('')
	const [edad, setEdad] = useState<number>(0);

	return (
		<>
			<Titulo texto={"Formulario de persona"}></Titulo>

			<form>
				<label>id</label><br/>
				<input name={"id"} type={"number"}
					   onChange={e => setId(parseInt(e.target.value))}/><br/><br/>

				<label>Nombre</label><br/>
				<input name={"nombre"} type={"texto"}
					   onChange={e => setNombre(e.target.value)}/><br/><br/>

				<label>Edad</label><br/>
				<input name={"edad"} type={"number"}
					   onChange={e => setEdad(parseInt(e.target.value))}/><br/><br/>

				<button type={"button"} onClick={() => {
					//TODO: validar antes de enviar
					const persona: Persona = {id, nombre, edad};
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
			</form>

			<span>Datos: {nombre} + {edad} + {id}</span>
		</>
	)
}