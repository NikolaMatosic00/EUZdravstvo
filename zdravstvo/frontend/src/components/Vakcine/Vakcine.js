import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import zdravstvoService from "../../services/api/zdravstvo-service";

const Vakcine = () => {
  const history = useHistory();
  const [vakcine, setVakcine] = useState([]);

  useEffect(() => {
    zdravstvoService.getVakcine().then((data) => {
      setVakcine(data);
    });
  }, []);

  const goToFormHandler = () => {
    history.push(`/vakcine/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="info" onClick={goToFormHandler}>
          Kreiraj novu vakcinu
        </Button>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Izdavac</th>
            <th>Naziv</th>
          </tr>
        </thead>

        <tbody>
          {vakcine.map((vakcina) => {
            return (
              <tr key={vakcina.id} className="pointer">
                <td>{vakcina.id}</td>
                <td>{vakcina.izdavac}</td>
                <td>{vakcina.naziv}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Vakcine;
