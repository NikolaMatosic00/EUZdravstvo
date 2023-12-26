import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import zdravstvoService from "../../services/api/zdravstvo-service";
import Input from "../util/Input/Input";

const Transplatacije = () => {
  const history = useHistory();
  const [transplatacije, setTransplatacije] = useState([]);
  const [jmbg, setJmbg] = useState([]);

  useEffect(() => {
    if (jmbg && jmbg.length > 3) {
      zdravstvoService.getTransplatacijeZaJMBG(jmbg).then((data) => {
        setTransplatacije(data);
      });
    } else {
      zdravstvoService.getTransplatacije().then((data) => {
        setTransplatacije(data);
      });
    }
  }, [jmbg]);

  const goToFormHandler = () => {
    history.push(`/transplatacije/form`);
  };

  return (
    <>
      <div className="w-100 d-flex justify-content-end my-3">
        <Button variant="info" onClick={goToFormHandler}>
          Kreiraj zahtev
        </Button>
      </div>
      <Input type="text" title="JMBG" setValue={setJmbg} />
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>JMBG</th>
            <th>Komentar</th>
          </tr>
        </thead>

        <tbody>
          {transplatacije.map((t) => {
            return (
              <tr key={t.id} className="pointer">
                <td>{t.id}</td>
                <td>{t.jmbg}</td>
                <td>{t.komentar}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Transplatacije;
