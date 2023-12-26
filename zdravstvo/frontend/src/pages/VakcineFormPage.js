import VakcineForm from "../components/Vakcine/VakcineForm/VakcineForm";
import StandardLayout from "../layouts/StandardLayout";

const VakcineFormPage = (props) => {
  return (
    <StandardLayout title="Kreiraj vakcinu">
      <VakcineForm />
    </StandardLayout>
  );
};

export default VakcineFormPage;
