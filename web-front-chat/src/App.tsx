import './App.css'
import Formulario from "./componentes/Formulario.tsx";
import Listado from "./componentes/Listado.tsx";

function App() {


	return (
		<>
			<h1>Sala de chat</h1>

			<div className={"contenedor"}>
				<div className={"columna-1"}>
					<Listado/>
				</div>
				<div className={"columna-2"}>
					<Formulario/>
				</div>
			</div>
		</>
	)
}

export default App
