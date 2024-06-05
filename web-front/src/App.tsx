import './App.css'
import ListarPersonas from "./componentes/ListarPersonas.tsx";
import FormularioPersona from "./componentes/FormularioPersona.tsx";
import {useState} from "react";

function App() {

	const [renderCounter, setRenderCounter] = useState<number>(0);
	const [idPersona, setIdPersona] = useState<number | undefined>(undefined);

	return (
		<>
	

			counter : {renderCounter}<br/>
			idPersona : {idPersona}<br/>

			<hr style={{marginTop:"3em"}}/>

			<table style={{width: "100%"}}>
				<tbody>
				<tr>
					<td width={"50%"}>
						<ListarPersonas 
						   setIdPersona={setIdPersona}
						   renderCounter={renderCounter}/>
					</td> 
					<td style={{paddingLeft:"2em"}}>
						<FormularioPersona 
							idPersona={idPersona}
							renderCounter={renderCounter} 
							setRenderCounter={setRenderCounter}/>
					</td>
				</tr>
				</tbody>
			</table>

			

		</>
	)
}

export default App
