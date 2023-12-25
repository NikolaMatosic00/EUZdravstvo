import React, { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import rfzoService from "../../services/api/rfzo-service";
import Input from "../util/Input/Input";

const dateOptions = {
  year: "numeric",
  month: "numeric",
  day: "numeric",
  hour: "numeric",
  minute: "numeric",
};

const GradjaninUplate = () => {
  const [uplate, setUplate] = useState([]);
  const [jmbg, setJmbg] = useState(true);
  const [status, setStatus] = useState(false);

  useEffect(() => {
    if (jmbg && jmbg.length > 3) {
      rfzoService.getGradjaninUplateZaJMBG(jmbg).then((data) => {
        setUplate(data);
      });
      rfzoService.getProveraDaLiJeZdravstvenoOsiguran(jmbg).then((data) => {
        setStatus(data.status);
      });
    }
  }, [jmbg]);

  return (
    <>
      <Input type="text" title="JMBG" setValue={setJmbg} />
      {`Status osiguranja: ${status ? "OSIGURAN" : "NIJE OSIGURAN"}`}
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Vreme uplate</th>
            <th>Ukupan iznos uplate</th>
            <th>Zdravstveno osiguranje</th>
            <th>Osiguranik JMBG</th>
            <th>Firma PIB</th>
          </tr>
        </thead>

        <tbody>
          {uplate.map((uplata) => {
            const vremeUplate = new Date(uplata.vremeUplate);

            return (
              <tr key={uplata.id} className="pointer">
                <td>{uplata.id}</td>
                <td>{vremeUplate.toLocaleDateString("de-DE", dateOptions)}</td>
                <td>{uplata.ukupanIznosUplate + "RSD"}</td>
                <td>{uplata.odTogaZdravstvenoOsiguranje + "RSD"}</td>
                <td>{uplata.refOsiguranikJMBG}</td>
                <td>{uplata.refFirmaPIB}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default GradjaninUplate;
