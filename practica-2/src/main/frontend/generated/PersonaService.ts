import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import type Persona_1 from "./com/practica/estructura/models/Persona.js";
import client_1 from "./connect-client.default.js";
async function createPersona_1(usuario: string | undefined, edad: number | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("PersonaService", "createPersona", { usuario, edad }, init); }
async function lisAllPersona_1(init?: EndpointRequestInit_1): Promise<Array<Persona_1 | undefined> | undefined> { return client_1.call("PersonaService", "lisAllPersona", {}, init); }
async function updatePersona_1(id: number | undefined, usuario: string | undefined, edad: number | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("PersonaService", "updatePersona", { id, usuario, edad }, init); }
export { createPersona_1 as createPersona, lisAllPersona_1 as lisAllPersona, updatePersona_1 as updatePersona };
