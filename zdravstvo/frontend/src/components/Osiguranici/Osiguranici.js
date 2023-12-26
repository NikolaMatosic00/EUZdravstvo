import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import zdravstvoService from "../../services/api/zdravstvo-service";

const Osiguranici = () => {
  const history = useHistory();
  const [osiguranici, setOsiguranici] = useState([]);

  useEffect(() => {
    zdravstvoService.getOsiguranici().then((data) => {
      setOsiguranici(data);
    });
  }, []);

  const goToFormHandler = () => {
    history.push(`/osiguranici/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="info" onClick={goToFormHandler}>
          Kreiraj
        </Button>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Ime</th>
            <th>Prezime</th>
            <th>JMBG</th>
            <th>Rodjendan</th>
          </tr>
        </thead>

        <tbody>
          {osiguranici.map((osiguranik) => {
            return (
              <tr key={osiguranik.id} className="pointer">
                <td>{osiguranik.id}</td>
                <td>{osiguranik.ime}</td>
                <td>{osiguranik.prezime}</td>
                <td>{osiguranik.jmbg}</td>
                <td>{osiguranik.datumRodjenja}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Osiguranici;
