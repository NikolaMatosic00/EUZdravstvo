import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import zdravstvoService from "../../../services/api/zdravstvo-service";
import Input from "../../util/Input/Input";
import { Button } from "react-bootstrap";

const OsiguraniciForm = () => {
  const history = useHistory();
  const [osiguranik, setOsiguranik] = useState({
    ime: "",
    prezime: "",
    jmbg: "",
    datumRodjenja: "",
  });

  useEffect(() => {}, []);

  const changeImeHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      ime: value,
    }));
  };

  const changeJmbgHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      jmbg: value,
    }));
  };

  const changePrezimeHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      prezime: value,
    }));
  };

  const changeDatumRodjenjaHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      datumRodjenja: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    zdravstvoService.createOsiguranik(osiguranik).then(() => {
      history.push(`/osiguranici`);
    });
  };

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Osiguranik</h3>
        <Input
          type="text"
          title="Ime"
          value={osiguranik.ime}
          setValue={changeImeHandler}
        />
        <Input
          type="text"
          title="Prezime"
          value={osiguranik.prezime}
          setValue={changePrezimeHandler}
        />
        <Input
          type="text"
          title="JMBG"
          value={osiguranik.jmbg}
          setValue={changeJmbgHandler}
        />
        <Input
          type="date"
          title="Rodjendan"
          value={osiguranik.datumRodjenja}
          setValue={changeDatumRodjenjaHandler}
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

export default OsiguraniciForm;
