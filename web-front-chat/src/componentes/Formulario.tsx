export interface FormularioProps {
	mensajes: string[];
	setMensajes: React.Dispatch<React.SetStateAction<string[]>>;
}


const Formulario = ({mensajes, setMensajes}: FormularioProps) => {
	return (
		<>
			<h2>Formulario de Mensaje</h2>
			<form>
				<label style={{display: "block", marginBottom: "5px"}}>Envía tu texto</label>
				<textarea id={"inpMensaje"} style={{display: "block", marginBottom: "5px", width: "100%"}}
						  placeholder={"Indica aquí tu mensaje"}></textarea>
				<button type={"button"} onClick={ () => {
					const htmlElement = document.getElementById("inpMensaje");
					const textarea = htmlElement as HTMLTextAreaElement;
					const mensaje = textarea.value;
					if (mensaje != '') {
						setMensajes([...mensajes, mensaje])
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