import {useMensajeController} from "../util/api.ts";

const Formulario = () => {
	const mensajeCtrl = useMensajeController();


	return (
		<>
			<h2>Formulario de Mensaje</h2>
			<form>
				<label style={{display: "block", marginBottom: "5px"}}>Envía tu texto</label>
				<textarea id={"inpMensaje"} style={{display: "block", marginBottom: "5px", width: "100%"}}
						  placeholder={"Indica aquí tu mensaje"}></textarea>
				<button type={"button"} onClick={() => {
					const htmlElement = document.getElementById("inpMensaje");
					const textarea = htmlElement as HTMLTextAreaElement;
					const mensaje = textarea.value;
					if (mensaje != '') {
						mensajeCtrl.enviarMensaje(mensaje)
						.then(() => alert("Se ha enviado correctamente"))
						.catch(err => alert("Ha ocurrido un error " + err))
						textarea.value = ''
					} else {
						alert("Indique algún mensaje con contenido");
					}
				}}>Enviar
				</button>
			</form>
		</>
	);
};

export default Formulario;