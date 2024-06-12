import {useEffect, useState} from "react";
import {MensajeEntity} from "../../src-generated/openapi";


const Listado = () => {

	const [mensajes,
		setMensajes] = useState<MensajeEntity[]>([]);

	useEffect(() => {
		const id = setInterval(() => {
			console.log("Solicitar mensajes")
			fetch("http://localhost:8080/mensajes")
			.then(resp => {
				resp.json()
				.then(json => {
					console.log( json)
					setMensajes(json as MensajeEntity[]);
				})
				.catch(err => alert("Respuesta del servidor no esperada " + err))
			})
			.catch();

		}, 3000)
		return () => {
			clearInterval(id);
		}
	}, []);

	return (
		<>
			<h2>Histórico de mensajes</h2>
			<ul>
				{mensajes.map((mensaje, i) => (
					<li key={"mensaje-" + i}>{mensaje.mensaje}</li>
				))}
			</ul>
			{mensajes.length == 0 && (
				<p>No hay mensajes aun</p>
			)}
		</>
	);
}

export default Listado;