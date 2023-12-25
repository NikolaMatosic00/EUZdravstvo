import axios from "axios";

const createUplata = (uplata) => {
  return axios
    .post("/zdravstvenoOsiguranje/evidentirajUplatu", uplata)
    .then((response) => response.data);
};

const getUplate = () => {
  return axios
    .get("/zdravstvenoOsiguranje/istorijaUplata")
    .then((response) => response.data);
};

const getUplateZaPIBIliJMBG = (pibIliJMBG) => {
  return axios
    .get(`/zdravstvenoOsiguranje/istorijaUplata?pibIliJMBG=${pibIliJMBG}`)
    .then((response) => response.data);
};

const getGradjaninUplateZaJMBG = (jmbg) => {
  return axios
    .get(`/gradjanin/istoirjaUplata?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const getProveraDaLiJeZdravstvenoOsiguran = (jmbg) => {
  return axios
    .get(`/gradjanin/proveraDaLiJeZdravstvenoOsiguran?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const rfzoService = {
  createUplata,
  getUplate,
  getUplateZaPIBIliJMBG,
  getGradjaninUplateZaJMBG,
  getProveraDaLiJeZdravstvenoOsiguran,
};

export default rfzoService;
