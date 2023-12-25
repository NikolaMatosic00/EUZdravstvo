import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import crosoService from "../../../services/api/croso-service";
import aprService from "../../../services/api/apr-service";
import rfzoService from "../../../services/api/rfzo-service";
import Select from "../../util/Select/Select";
import { Button } from "react-bootstrap";
import Input from "../../util/Input/Input";

const UplateForm = () => {
  const history = useHistory();
  const [osiguranici, setOsiguranici] = useState([]);
  const [firme, setFirme] = useState([]);
  const [uplata, setUplata] = useState({
    idZaposleni: 0,
    idFirma: 0,
    iznos: 0,
    vremeUplate: "",
  });

  useEffect(() => {
    aprService.getFirme().then((data) => {
      data.unshift({ id: 0, naziv: "select", pib: "" });
      setFirme(data);
    });
    crosoService.getOsiguranici().then((data) => {
      data.unshift({ id: 0, ime: "select", prezime: "", jmbg: "", refPib: "" });
      setOsiguranici(data);
    });
  }, []);

  const changeFirmaHandler = (value) => {
    setUplata((prevState) => ({
      ...prevState,
      idFirma: value,
    }));
  };

  const changeOsiguranikHandler = (value) => {
    setUplata((prevState) => ({
      ...prevState,
      idZaposleni: value,
    }));
  };

  const changeVremeUplateHandler = (value) => {
    setUplata((prevState) => ({
      ...prevState,
      vremeUplate: value,
    }));
  };

  const changeIznosHandler = (value) => {
    console.log(value);
    setUplata((prevState) => ({
      ...prevState,
      iznos: +value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    rfzoService.createUplata(uplata).then((data) => {
      history.push(`/istorijaUplata/${data}`);
    });
  };

  const optionsOsiguranici = osiguranici.map((o) => ({
    value: o.id,
    name: `${o.ime} ${o.prezime} ${o.jmbg} ${o.refPib}`,
  }));

  const optionsFirme = firme.map((f) => ({
    value: f.id,
    name: `${f.naziv} ${f.pib}`,
  }));

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Podaci o uplati</h3>

        <Select
          title="Osiguranik"
          value={uplata.idZaposleni}
          setValue={changeOsiguranikHandler}
          options={optionsOsiguranici}
        />
        <Select
          title="Firma"
          value={uplata.idFirma}
          setValue={changeFirmaHandler}
          options={optionsFirme}
        />
        <Input
          type="date"
          title="Vreme uplate"
          value={uplata.vremeUplate}
          setValue={changeVremeUplateHandler}
        />
        <Input
          type="number"
          title="Iznos"
          value={uplata.iznos}
          setValue={changeIznosHandler}
        />
      </div>

      <div className="w-100 d-flex justify-content-end my-3">
        <Button type="submit" variant="dark" onClick={submitFormHandler}>
          Unesi
        </Button>
      </div>
    </form>
  );
};

export default UplateForm;
