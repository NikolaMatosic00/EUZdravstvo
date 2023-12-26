import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import zdravstvoService from "../../../services/api/zdravstvo-service";
import Select from "../../util/Select/Select";
import { Button } from "react-bootstrap";

const VakcinacijeForm = () => {
  const history = useHistory();
  const [osiguranici, setOsiguranici] = useState([]);
  const [vakcine, setVakcine] = useState([]);
  const [vakcinacija, setVakcinacija] = useState({
    idOsiguranik: 0,
    idVakcina: 0,
  });

  useEffect(() => {
    zdravstvoService.getVakcine().then((data) => {
      data.unshift({ id: 0, naziv: "select", izdavac: "" });
      setVakcine(data);
    });
    zdravstvoService.getOsiguranici().then((data) => {
      data.unshift({ id: 0, ime: "select", prezime: "", jmbg: "" });
      setOsiguranici(data);
    });
  }, []);

  const changeOsiguranikHandler = (value) => {
    setVakcinacija((prevState) => ({
      ...prevState,
      idOsiguranik: value,
    }));
  };

  const changeVakcinaHandler = (value) => {
    setVakcinacija((prevState) => ({
      ...prevState,
      idVakcina: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    zdravstvoService.createVakcinacija(vakcinacija).then((data) => {
      history.push(`/vakcinacije/${data}`);
    });
  };

  const optionsOsiguranici = osiguranici.map((o) => ({
    value: o.id,
    name: `${o.ime} ${o.prezime} ${o.jmbg}`,
  }));

  const optionsVakcine = vakcine.map((v) => ({
    value: v.id,
    name: `${v.naziv} ${v.izdavac}`,
  }));

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Podaci o vakcinaciji</h3>

        <Select
          title="Osiguranik"
          value={vakcinacija.idOsiguranik}
          setValue={changeOsiguranikHandler}
          options={optionsOsiguranici}
        />
        <Select
          title="Vakcina"
          value={vakcinacija.idVakcina}
          setValue={changeVakcinaHandler}
          options={optionsVakcine}
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

export default VakcinacijeForm;
