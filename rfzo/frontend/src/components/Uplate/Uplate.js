import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import rfzoService from "../../services/api/rfzo-service";
import Input from "../util/Input/Input";

const dateOptions = {
  year: "numeric",
  month: "numeric",
  day: "numeric",
  hour: "numeric",
  minute: "numeric",
};

const Uplate = () => {
  const history = useHistory();
  const [uplate, setUplate] = useState([]);
  const [pibIliJMBG, setPibIliJMBG] = useState([]);

  useEffect(() => {
    if (pibIliJMBG && pibIliJMBG.length > 3) {
      rfzoService.getUplateZaPIBIliJMBG(pibIliJMBG).then((data) => {
        setUplate(data);
      });
    } else {
      rfzoService.getUplate().then((data) => {
        setUplate(data);
      });
    }
  }, [pibIliJMBG]);

  const goToFormHandler = () => {
    history.push(`/istorijaUplata/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="dark" onClick={goToFormHandler}>
          Kreiraj uplatu
        </Button>
      </div>
      <Input type="text" title="PIB ili JMBG" setValue={setPibIliJMBG} />

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

export default Uplate;
