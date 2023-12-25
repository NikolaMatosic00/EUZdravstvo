import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import crosoService from "../../services/api/croso-service";
import Input from "../util/Input/Input";

const Osiguranici = () => {
  const history = useHistory();
  const [osiguranici, setOsiguranici] = useState([]);
  const [pibIliJMBG, setPibIliJMBG] = useState([]);

  useEffect(() => {
    if (pibIliJMBG && pibIliJMBG.length > 3) {
      crosoService.getOsiguraniciZaPIBIliJMBG(pibIliJMBG).then((data) => {
        setOsiguranici(data);
      });
    } else {
      crosoService.getOsiguranici().then((data) => {
        setOsiguranici(data);
      });
    }
  }, [pibIliJMBG]);

  const goToFormHandler = () => {
    history.push(`/osiguranici/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="dark" onClick={goToFormHandler}>
          Evidentiraj osiguranika
        </Button>
      </div>
      <Input type="text" title="PIB ili JMBG" setValue={setPibIliJMBG} />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Ime</th>
            <th>Prezime</th>
            <th>JMBG</th>
            <th>PIB</th>
          </tr>
        </thead>

        <tbody>
          {osiguranici.map((o) => {
            return (
              <tr key={o.id} className="pointer">
                <td>{o.id}</td>
                <td>{o.ime}</td>
                <td>{o.prezime}</td>
                <td>{o.jmbg}</td>
                <td>{o.refPib}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Osiguranici;
