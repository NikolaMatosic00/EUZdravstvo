import axios from "axios";

const createVakcinacija = (vakcinacija) => {
  return axios
    .post("/zdravstveni-radnik/registrujVakcinaciju", vakcinacija)
    .then((response) => response.data);
};

const createVakcina = (vakcina) => {
  return axios
    .post("/zdravstveni-radnik/registrujVakcinu", vakcina)
    .then((response) => response.data);
};

const createOsiguranik = (osiguranik) => {
  return axios
    .post("/zdravstveni-radnik/registrujOsiguranika", osiguranik)
    .then((response) => response.data);
};

const getVakcinacije = () => {
  return axios
    .get("/zdravstveni-radnik/istorijaVakcinisanja")
    .then((response) => response.data);
};

const getVakcinacijeZaJMBG = (jmbg) => {
  return axios
    .get(`/zdravstveni-radnik/istorijaVakcinisanja?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const getVakcinacijeZaGradjanePoJMBG = (jmbg) => {
  return axios
    .get(`/gradjanin/isotirjaVakcinisanja?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const proveraZaDavanjeKrviPoJMBG = (jmbg) => {
  return axios
    .get(`/gradjanin/proveraZaDavanjeKrvi?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const getVakcine = () => {
  return axios
    .get("/zdravstveni-radnik/listaVakcina")
    .then((response) => response.data);
};

const getOsiguranici = () => {
  return axios
    .get("/zdravstveni-radnik/listaOsiguranika")
    .then((response) => response.data);
};

const getTransplatacije = () => {
  return axios
    .get("/transplatacija/evidencijaTransplatacija")
    .then((response) => response.data);
};

const getTransplatacijeZaJMBG = (jmbg) => {
  return axios
    .get(`/transplatacija/evidencijaTransplatacija?jmbg=${jmbg}`)
    .then((response) => response.data);
};

const createTransplantacija = (transplatacija) => {
  return axios
    .post("/transplatacija/evidentirajZahtevZaTransplataciju", transplatacija)
    .then((response) => response.data);
};

const zdravstvoService = {
  getVakcinacije,
  getVakcine,
  getOsiguranici,
  getVakcinacijeZaJMBG,
  createVakcinacija,
  createVakcina,
  createOsiguranik,
  getVakcinacijeZaGradjanePoJMBG,
  proveraZaDavanjeKrviPoJMBG,
  getTransplatacije,
  createTransplantacija,
  getTransplatacijeZaJMBG,
};

export default zdravstvoService;
