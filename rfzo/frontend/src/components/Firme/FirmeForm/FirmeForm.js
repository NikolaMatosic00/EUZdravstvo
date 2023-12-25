import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import aprService from "../../../services/api/apr-service";
import Input from "../../util/Input/Input";
import { Button } from "react-bootstrap";

const FirmeForm = () => {
  const history = useHistory();
  const [firma, setFirma] = useState({
    naziv: "",
    adresa: "",
    pib: "",
    maticniBroj: "",
  });

  useEffect(() => {}, []);

  const changeNazivHandler = (value) => {
    setFirma((prevState) => ({
      ...prevState,
      naziv: value,
    }));
  };

  const changeAdresaHandler = (value) => {
    setFirma((prevState) => ({
      ...prevState,
      adresa: value,
    }));
  };

  const changeMaticniBrojHandler = (value) => {
    setFirma((prevState) => ({
      ...prevState,
      maticniBroj: value,
    }));
  };

  const changePIBHandler = (value) => {
    setFirma((prevState) => ({
      ...prevState,
      pib: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    aprService.createFirma(firma).then(() => {
      history.push(`/izlistajFirme`);
    });
  };

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Podaci o pravnom licu</h3>
        <Input
          type="text"
          title="Naziv"
          value={firma.naziv}
          setValue={changeNazivHandler}
        />
        <Input
          type="text"
          title="Adresa"
          value={firma.adresa}
          setValue={changeAdresaHandler}
        />
        <Input
          type="text"
          title="Maticni broj"
          value={firma.maticniBroj}
          setValue={changeMaticniBrojHandler}
        />
        <Input
          type="text"
          title="PIB"
          value={firma.pib}
          setValue={changePIBHandler}
        />
      </div>

      <div className="w-100 d-flex justify-content-end my-3">
        <Button type="submit" variant="dark" onClick={submitFormHandler}>
          Kreiraj
        </Button>
      </div>
    </form>
  );
};

export default FirmeForm;
