import axios from "axios";

const createFirma = (firma) => {
  return axios
    .post("/apr/evidentirajFirmu", firma)
    .then((response) => response.data);
};

const getFirme = () => {
  return axios.get("/apr/izlistajFirme").then((response) => response.data);
};

const getFirmeZaPIB = (pib) => {
  return axios
    .get(`/apr/izlistajFirme?pib=${pib}`)
    .then((response) => response.data);
};

const aprService = {
  createFirma,
  getFirme,
  getFirmeZaPIB,
};

export default aprService;
