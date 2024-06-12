export interface ListadoProps {
	mensajes: string[];
}

const Listado =  ({mensajes}: ListadoProps) => {
	return (
		<>
			<h2>Histórico de mensajes</h2>
			<ul>
				{mensajes.map((mensaje, i) => (
					<li key={"mensaje-" + i}>{mensaje}</li>
				))}
			</ul>
			{mensajes.length == 0 && (
				<p>No hay mensajes aun</p>
			)}
		</>
	);
}

export  default  Listado;