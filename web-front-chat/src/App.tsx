import './App.css'
import {useState} from "react";
import Formulario from "./componentes/Formulario.tsx";
import Listado from "./componentes/Listado.tsx";

function App() {

	const [
		mensajes,
		setMensajes] = useState<string[]>([]);

	return (
		<>
			<h1>Sala de chat</h1>

			<div className={"contenedor"}>
				<div className={"columna-1"}>
					<Listado mensajes={mensajes}/>
				</div>
				<div className={"columna-2"}>
					<Formulario mensajes={mensajes} setMensajes={setMensajes}/>
				</div>
			</div>
		</>
	)
}

export default App
