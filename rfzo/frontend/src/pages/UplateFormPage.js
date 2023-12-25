import UplateForm from "../components/Uplate/UplateForm/UplateForm";
import StandardLayout from "../layouts/StandardLayout";

const UplateFormPage = (props) => {
  return (
    <StandardLayout title="Kreiraj uplatu">
      <UplateForm />
    </StandardLayout>
  );
};

export default UplateFormPage;
