import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import zdravstvoService from "../../../services/api/zdravstvo-service";
import Input from "../../util/Input/Input";
import { Button } from "react-bootstrap";

const VakcineForm = () => {
  const history = useHistory();
  const [vakcina, setVakcina] = useState({
    naziv: "",
    izdavac: "",
  });

  useEffect(() => {}, []);

  const changeIzdavacHandler = (value) => {
    setVakcina((prevState) => ({
      ...prevState,
      izdavac: value,
    }));
  };

  const changeNazivHandler = (value) => {
    setVakcina((prevState) => ({
      ...prevState,
      naziv: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    zdravstvoService.createVakcina(vakcina).then(() => {
      history.push(`/vakcine`);
    });
  };

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Kreiranje vakcine (fajzer/moderna/sinofarm)</h3>
        <Input
          type="text"
          title="Naziv"
          value={vakcina.naziv}
          setValue={changeNazivHandler}
        />
        <Input
          type="text"
          title="Izdavac"
          value={vakcina.izdavac}
          setValue={changeIzdavacHandler}
        />
      </div>

      <div className="w-100 d-flex justify-content-end my-3">
        <Button type="submit" variant="info" onClick={submitFormHandler}>
          Kreiraj
        </Button>
      </div>
    </form>
  );
};

export default VakcineForm;
