import axios from "axios";

const createOsiguranik = (osiguranik) => {
  return axios
    .post("/croso/evidentirajZaposlenog", osiguranik)
    .then((response) => response.data);
};

const getOsiguraniciZaPIBIliJMBG = (pibIliJMBG) => {
  return axios
    .get(`/croso/izlistajOsiguranike?pibIliJMBG=${pibIliJMBG}`)
    .then((response) => response.data);
};

const getOsiguranici = () => {
  return axios
    .get("/croso/izlistajOsiguranike")
    .then((response) => response.data);
};

const crosoService = {
  getOsiguranici,
  getOsiguraniciZaPIBIliJMBG,
  createOsiguranik,
};

export default crosoService;
