import { useHistory } from "react-router-dom";
import React, { useEffect, useState } from "react";
import zdravstvoService from "../../../services/api/zdravstvo-service";
import Input from "../../util/Input/Input";
import { Button } from "react-bootstrap";

const TransplatacijeForm = () => {
  const history = useHistory();
  const [transplatacija, setTransplatacija] = useState({
    jmbg: "",
    komentar: "",
  });

  useEffect(() => {}, []);

  const changeKomentarHandler = (value) => {
    setTransplatacija((prevState) => ({
      ...prevState,
      komentar: value,
    }));
  };

  const changeJmbgHandler = (value) => {
    setTransplatacija((prevState) => ({
      ...prevState,
      jmbg: value,
    }));
  };

  const submitFormHandler = (event) => {
    event.preventDefault();
    zdravstvoService.createTransplantacija(transplatacija).then(() => {
      history.push(`/transplatacije`);
    });
  };

  return (
    <form className="w-50 mx-auto">
      <div>
        <h3>Transplatacija detalji</h3>

        <Input
          type="text"
          title="Komentar"
          value={transplatacija.komentar}
          setValue={changeKomentarHandler}
        />
        <Input
          type="text"
          title="JMBG"
          value={transplatacija.jmbg}
          setValue={changeJmbgHandler}
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

export default TransplatacijeForm;
