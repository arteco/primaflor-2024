export interface TitulosProps {
	texto: string;
}


export default ({texto}: TitulosProps) => {
	return (
		<h1>{texto}</h1>
	)
}