import VakcinacijeForm from "../components/Vakcinacije/VakcinacijeForm/VakcinacijeForm";
import StandardLayout from "../layouts/StandardLayout";

const VakcinacijeFormPage = (props) => {
  return (
    <StandardLayout title="Kreiraj vakcinu">
      <VakcinacijeForm />
    </StandardLayout>
  );
};

export default VakcinacijeFormPage;
