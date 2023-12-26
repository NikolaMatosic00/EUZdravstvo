import React, { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import zdravstvoService from "../../services/api/zdravstvo-service";
import Input from "../util/Input/Input";

const dateOptions = {
  year: "numeric",
  month: "numeric",
  day: "numeric",
  hour: "numeric",
  minute: "numeric",
};

const GradjaninVakcinacije = () => {
  const [vakcinacije, setVakcinacije] = useState([]);
  const [dozvoljenoDavanjeKrvi, setDozvoljenoDavanjeKrvi] = useState(false);

  const [jmbg, setJmbg] = useState([]);

  useEffect(() => {
    if (jmbg && jmbg.length > 3) {
      zdravstvoService.getVakcinacijeZaGradjanePoJMBG(jmbg).then((data) => {
        setVakcinacije(data);
      });
      zdravstvoService.proveraZaDavanjeKrviPoJMBG(jmbg).then((data) => {
        setDozvoljenoDavanjeKrvi(!!data.status);
      });
    }
  }, [jmbg]);

  return (
    <>
      <Input type="text" title="JMBG" setValue={setJmbg} />
      {`Dozvoljeno davanje krvi: ${dozvoljenoDavanjeKrvi ? "DA" : "NE"}`}
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Vreme doze</th>
            <th>Sledeca doza</th>
            <th>Broj doze</th>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Vakcina</th>
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
                <td>
                  {vremeVakcinisanja.toLocaleDateString("de-DE", dateOptions)}
                </td>
                <td>
                  {preporucenoVremeZaSledecuDozu.toLocaleDateString(
                    "de-DE",
                    dateOptions
                  )}
                </td>
                <td>{vakcinacija.brojDoze}</td>
                <td>{vakcinacija.osiguranik.ime}</td>
                <td>{vakcinacija.osiguranik.prezime}</td>
                <td>{vakcinacija.vakcina.naziv}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default GradjaninVakcinacije;
