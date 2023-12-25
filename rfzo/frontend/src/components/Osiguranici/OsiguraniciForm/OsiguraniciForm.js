import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import crosoService from "../../../services/api/croso-service";
import Input from "../../util/Input/Input";
import { Button } from "react-bootstrap";

const OsiguraniciForm = () => {
  const history = useHistory();
  const [osiguranik, setOsiguranik] = useState({
    ime: "",
    prezime: "",
    jmbg: "",
    refPib: "",
  });

  useEffect(() => {}, []);

  const changeImeHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      ime: value,
    }));
  };

  const changePrezimeHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      prezime: value,
    }));
  };

  const changeJmbgHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      jmbg: value,
    }));
  };

  const changeRefPibHandler = (value) => {
    setOsiguranik((prevState) => ({
      ...prevState,
      refPib: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    crosoService.createOsiguranik(osiguranik).then(() => {
      history.push(`/osiguranici`);
    });
  };

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Zaposleni</h3>
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
          type="text"
          title="PIB"
          value={osiguranik.refPib}
          setValue={changeRefPibHandler}
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

export default OsiguraniciForm;
