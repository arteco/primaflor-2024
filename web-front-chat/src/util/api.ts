import {Configuration, MensajeControllerApiFactory} from "../../src-generated/openapi";

export function useMensajeController() {
	return MensajeControllerApiFactory({
		basePath: "http://localhost:8080"
	} as Configuration);

}

