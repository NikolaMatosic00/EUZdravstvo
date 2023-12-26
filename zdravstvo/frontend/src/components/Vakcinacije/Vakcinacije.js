import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import zdravstvoService from "../../services/api/zdravstvo-service";
import Input from "../util/Input/Input";

const dateOptions = {
  year: "numeric",
  month: "numeric",
  day: "numeric",
  hour: "numeric",
  minute: "numeric",
};

const Vakcinacije = () => {
  const history = useHistory();
  const [vakcinacije, setVakcinacije] = useState([]);
  const [jmbg, setJmbg] = useState([]);

  useEffect(() => {
    if (jmbg && jmbg.length > 3) {
      zdravstvoService.getVakcinacijeZaJMBG(jmbg).then((data) => {
        setVakcinacije(data);
      });
    } else {
      zdravstvoService.getVakcinacije().then((data) => {
        setVakcinacije(data);
      });
    }
  }, [jmbg]);

  const goToFormHandler = () => {
    history.push(`/vakcinacije/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="info" onClick={goToFormHandler}>
          Kreiraj vakcinaciju
        </Button>
      </div>
      <Input type="text" title="JMBG" setValue={setJmbg} />

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Broj doze</th>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Vakcina</th>
            <th>Vreme vakcinisanja</th>
            <th>Preporuceno vreme za sledecu dozu</th>
          </tr>
        </thead>

        <tbody>
          {vakcinacije.map((vakcinacija) => {
            const vremeVakcinisanja = new Date(vakcinacija.vremeVakcinisanja);
            const preporucenoVremeZaSledecuDozu = new Date(
              vakcinacija.preporucenoVremeZaSledecuDozu
            );
            return (
              <tr
                key={vakcinacija.id}
                className="pointer"
                style={
                  vakcinacija.brojDoze === 3
                    ? { background: "rgb(249,66,58)" }
                    : { background: "rgb(255,255,0)" }
                }
              >
                <td>{vakcinacija.id}</td>
                <td>{vakcinacija.brojDoze}</td>
                <td>{vakcinacija.osiguranik.ime}</td>
                <td>{vakcinacija.osiguranik.prezime}</td>
                <td>{vakcinacija.vakcina.naziv}</td>
                <td>
                  {vremeVakcinisanja.toLocaleDateString("de-DE", dateOptions)}
                </td>
                <td>
                  {preporucenoVremeZaSledecuDozu.toLocaleDateString(
                    "de-DE",
                    dateOptions
                  )}
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Vakcinacije;
