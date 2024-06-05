import './App.css'
import ListarPersonas from "./componentes/ListarPersonas.tsx";
import FormularioPersona from "./componentes/FormularioPersona.tsx";
import {useState} from "react";

function App() {

	const [renderCounter, setRenderCounter] = useState<number>(0)

	return (
		<>
			<table style={{width: "100%"}}>
				<tbody>
				<tr>
					<td width={"50%"}>
						<ListarPersonas renderCounter={renderCounter}/>
					</td>
					<td>
						<FormularioPersona renderCounter={renderCounter} setRenderCounter={setRenderCounter}/>
					</td>
				</tr>
				</tbody>
			</table>

			<hr style={{marginTop:"3em"}}/>

			counter : {renderCounter}

		</>
	)
}

export default App
