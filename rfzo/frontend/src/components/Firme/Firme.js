import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import aprService from "../../services/api/apr-service";
import Input from "../util/Input/Input";

const Firme = () => {
  const history = useHistory();
  const [firme, setFirme] = useState([]);
  const [pib, setPib] = useState([]);

  useEffect(() => {
    if (pib && pib.length > 3) {
      aprService.getFirmeZaPIB(pib).then((data) => {
        setFirme(data);
      });
    } else {
      aprService.getFirme().then((data) => {
        setFirme(data);
      });
    }
  }, [pib]);

  const goToFormHandler = () => {
    history.push(`/izlistajFirme/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="dark" onClick={goToFormHandler}>
          Kreiraj firmu
        </Button>
      </div>
      <Input type="text" title="PIB" setValue={setPib} />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Naziv</th>
            <th>Adresa</th>
            <th>Maticni Broj</th>
            <th>PIB</th>
          </tr>
        </thead>

        <tbody>
          {firme.map((firma) => {
            return (
              <tr key={firma.id} className="pointer">
                <td>{firma.id}</td>
                <td>{firma.naziv}</td>
                <td>{firma.adresa}</td>
                <td>{firma.maticniBroj}</td>
                <td>{firma.pib}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Firme;
