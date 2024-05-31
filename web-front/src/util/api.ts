import {Configuration, PersonaControllerApiFactory} from "../../src-generated/openapi";


export function usePersonaController() {
	return PersonaControllerApiFactory({
		basePath: "http://localhost:8080"
	} as Configuration);

}

