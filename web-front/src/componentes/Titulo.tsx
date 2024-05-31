export interface TitulosProps {
	texto: string;
	estilo?: string
}

export default ({texto, estilo = "texto-grande"}: TitulosProps) => {
	return (
		<h1 className={estilo}>{texto}</h1>
	)
}

/*
function Titulo({texto, estilo}: TitulosProps ){
	return (
		<h1 className={estilo}>{texto}</h1>
	);
}

export default Titulo;
*/


/*
const nombres = ["Pepe", "Manuel", "Antonio"];
const filtrado = (nombre: string) => nombre.indexOf("e")>=0;
filtrado("Ramón")
const nombresConE = nombres.filter(filtrado );

*/
